package com.es.websocket;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.es.socket.SocketClient;


//webSocket获取下面客户端传来的数据，实时采集到数据通过websocket实时显示到浏览器上，也就是在客户端上面显示
@ServerEndpoint(value = "/websocket")
public class WebSocket {
	//注释：2017.11.9 此处定义静态变量，以在其他方法中获取所有连接
	private static final Set<WebSocket> connections = new CopyOnWriteArraySet<>();
	//注释：2017.11.9 
	private Session session;
	private SocketClient socketClient;

	/**
	 * @category 打开Websocket连接
	 * @param session
	 */
	// 保证C++与javaService只连接一次 然后通过java广播 ，建立连接，建立连接时入参为session
	//注释：2017.11.9 当websocket客户端连接到服务器的时候，此方法将会执行，并且传递一个session会话对象来，我们拿到这个session，就可以向客户端发送消息
	@OnOpen
	public void start(Session session) {
		this.session = session;
		connections.add(this);// 将此对象存入集合中以在之后广播用，如果要实现一对一订阅，则类型对应为map，这里广播就所随意
		System.out.println(connections.size());
		System.out.println("websocket开启");
		/**
		 * 与c++的Socket的连接只有一个通道，通过WebSocket广播来实现各个客户端数据的分发
		 */
		System.out.println(socketClient);
		if (connections.size() < 2) {
			socketClient = OurFactory.getSocketClient(OurFactory.getHost(), OurFactory.getPort());
			/**
			 * 开启监视线程，监视当前连接数和Socket服务器是否断开
			 * 如果当前连接数为0，表示所有的客户端都与WebSocket服务器断开，此时将Socket通道断开
			 * 如果Socket服务器断开，清空所有客户端
			 */
			new Thread(new Runnable() {

				@Override
				public void run() {
					while (true) {
						/**
						 * 如果当前连接数为0，表示所有的客户端都与WebSocket服务器断开，此时将Socket通道断开
						 */
						/**
						 * 如果Socket服务器断开，清空所有客户端
						 */
						if (socketClient.getSocket().isClosed()) {
							connections.clear();
							break;
						}
					}
				}
			}).start();
		}
	}

	/**
	 * @category 关闭WebSocket连接
	 */
	//客户端关闭的时候，就会自动执行
	@OnClose
	public void end() {
		System.out.println("开始关闭WebSocket");
		connections.remove(this);//将socket对象从集合中移除，以便广播时不发送此连接。如果不移除就会报错
		System.out.println("websocket关闭");
		if (connections.size() == 0) {
			socketClient.closeSocket();
		}
	}
	/**
	 * @category 数据双向传输
	 * @param message
	 *            接受客户端传来的数据 、
	 */
	//客户端给服务器发送消息，这个方法会自动调用，并且可以拿到发送过来的数据
	@OnMessage
	public void incoming(String message) {
		/**
		 * 当客户端发来关闭信号，则将当前WebSocket通道关闭
		 */
		System.out.println("我进来了"+message+"---"+connections.size()+"-------------"+message);
		if (message.equals("clientClosed")) {
			end();
		}
		/**
		 * 与Socket的连接只有一个通道，通过WebSocket广播来实现各个客户端数据的分发
		 */
		else if(connections.size() < 2) {
			/**
			 * 创建一线程，用于Socket发送数据
			 */
			new Thread(new Runnable() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					try {
						socketClient.getData();
					} catch (UnknownHostException e) {
						// TODO Auto-generated catch block
						for (WebSocket webSocket : connections) {
							connections.remove(webSocket);
						}
						e.printStackTrace();
					}
				}
			}).start();
			/**
			 * 向客户端循环发送Socket发送过来的数据
			 */
		while (true) {
/*				System.out.println();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				broadcast(str);*/
			//System.out.println();
				if (null != socketClient.getReceiveMessage()) {
					System.out.println("-------------------" + socketClient.getReceiveMessage());
					broadcast(OurFactory.getSocketMsg().updateReceiveMsg(socketClient.getReceiveMessage()));
					// broadcast("0000");
					socketClient.setReceiveMessage(null);
				}
			}
		}
	}

	/**
	 * @category WebSocket传输出错
	 * @param t
	 * @throws Throwable
	 */
	@OnError
	public void onError(Throwable t) throws Throwable {
		System.out.println("出错了");
	}

	/**
	 * @category 向客户端发送数据
	 * @param msg
	 *            发送的数据
	 */
	private static void broadcast(String msg) {
		/**
		 * 向每一个客户端都发送数据
		 */
		//System.out.println("向客户端分发数据");
		//修改:2017.11.11 广播：遍历客户端集，发送消息，注意发送要用的session，用session.getBasicRemote().sendText(msg)发送消息
		for (WebSocket client : connections) { //修改：2017.11.11 遍历所有
			try {  //修改：2017.11.11  如果这个client已经下线
				synchronized (client) {
					client.session.getBasicRemote().sendText(msg);
				}
			} catch (IOException e) {
				System.out.println("发送失败");
				try {
					client.session.close();
				} catch (IOException e1) {
					// Ignore
				}
				broadcast("websocket关闭");
			}
		}
	}
}
