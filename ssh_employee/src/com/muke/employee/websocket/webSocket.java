package com.muke.employee.websocket;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@ServerEndpoint(value = "/client")
public class webSocket {
	    private static final Log log = LogFactory.getLog(webSocket.class);

	    private static final String GUEST_PREFIX = "Guest";
	    private static final AtomicInteger connectionIds = new AtomicInteger(0);
	    private static final Set<webSocket> connections = new CopyOnWriteArraySet<webSocket>();

	    private String nickname;
	    private Session session;

	    public webSocket() {
	        nickname = GUEST_PREFIX + connectionIds.getAndIncrement();
	    }

	    /*
	     * 当websocket的客户端连接到服务器时候，这个方法就会执行，并且传递一个session会话对象来
	     * 我们拿到这话session，就是可以给客户端发送消息
	     */
	    @OnOpen
	    public void start(Session session) {
	        this.session = session;
	        connections.add(this);
	        String message = String.format("* %s %s", nickname, "has joined.");
	        broadcast(message);
	    }

	    /* 客户端被关闭时候，就会自动会调用这个方法 */
	    @OnClose
	    public void end() {
	        connections.remove(this);
	        String message = String.format("* %s %s", nickname, "has disconnected.");
	        broadcast(message);
	    }

	    /* 客户端给服务器发送消息，这个方法会自动调用，并且可以拿到发送过来的数据 */
	    @OnMessage
	    public void incoming(String message) {
	        // Never trust the client
	        System.out.println(message);
	        broadcast(message);
	    }

	    /* 发生了异常自动执行 */
	    @OnError
	    public void onError(Throwable t) throws Throwable {
	        log.error("Chat Error: " + t.toString(), t);
	    }

	    /* 广播：遍历客户端集，发送消息，注意发送要用的session，用session.getBasicRemote().sendText(msg)发送消息 */
	    private static void broadcast(String msg) {
	        for (webSocket client : connections) {// 遍历所有
	            try {// 如果这个client已经在线
	                synchronized (client) {
	                    client.session.getBasicRemote().sendText(msg);// 发送消息
	                }
	            } catch (IOException e) {// 如果这个client不在线
	                log.debug("Chat Error: Failed to send message to client", e);
	                connections.remove(client);
	                try {
	                    client.session.close();
	                } catch (IOException e1) {
	                    // Ignore
	                }
	                String message = String.format("* %s %s", client.nickname, "has been disconnected.");
	                broadcast(message);
	            }
	        }
	    }
	
	
	
}
