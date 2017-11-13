package com.es.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import com.es.websocket.OurFactory;



public class SocketClient {
	private String receiveMessage;  //接受Socket服务器发送过来的数据
	private String sendMessage;     //向Socket服务器发送的数据
	private Socket socket;          //Socket
	
	public String getReceiveMessage() {
		return receiveMessage;
	}
	public void setReceiveMessage(String receiveMessage) {
		this.receiveMessage = receiveMessage;
	}
	public String getSendMessage() {
		return sendMessage;
	}
	public void setSendMessage(String sendMessage) {
		this.sendMessage = sendMessage;
	}
	public Socket getSocket() {
		return socket;
	}
	public void setSocket(Socket socket) {
		this.socket = socket;
	}
	/**
	 * @category 构造函数，实例化的时候创建Socket连接通道
	 */
	public SocketClient(String host, int port) {
		try {
			socket = new Socket(host, port);
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (socket.isConnected()) {
			System.out.println("is connected");
		} else {
			return;
		}
	}
	/**
	 * @category 关闭Socket连接
	 */
	public void closeSocket() {
		try {
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void getData() throws UnknownHostException {
//		sendMessage = msg;
		
		int i = 0;
		
		PrintWriter writer = null;
		BufferedReader reader = null; 
		try {
			writer = new PrintWriter(socket.getOutputStream());
			reader = new BufferedReader(new InputStreamReader(socket
					.getInputStream()));
			// 往服务器中发数据
			writer.println(sendMessage);
			writer.flush();
			char[] buffer = new char[1024];
			String msg = null;
			//读操作，从服务器中获取数据
			while (reader.read(buffer) != -1) {
				
				if(null != msg) {
					msg = msg + new String(buffer);
				} else {
					msg = new String(buffer);
				}	
				/**
				 * 数据量比较大的时候，会分包发送，当接受到的数据包含--结束符--的时候，表示这一帧数据接收完成，可以进行下一步的操作
				 * 如果接收到的数据包没有包含--结束符--，表示这一帧数据没有接收完成，继续接收
				 */
				if(msg.contains(";")) {
					i++;
					if(i%3 == 0) {
						sendMessage = "msgOne";
					} else if(i%3 == 1) {
						sendMessage = "msgTwo";
					} else {
						sendMessage = "msgThree";
					}
					/**
					 * 对接收的数据进行处理
					 */
					receiveMessage = OurFactory.getSocketMsg().updateReceiveMsg(msg.split(";")[0]);
					msg = null;
					writer.println(sendMessage);
					buffer = new char[1024];
					writer.flush();
				} 
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (writer != null) {
				writer.close();
			}
			if (socket != null) {
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
