/*package com.trq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;

import com.es.websocket.OurFactory;



public class Server {

	   public static void main(String args[]) throws IOException {  
		      //为了简单起见，所有的异常信息都往外抛  
		      int port = 8080;  
		      //定义一个ServerSocket监听在端口8899上  
		      ServerSocket server = new ServerSocket(port);  
		      while (true) {  
		         //server尝试接收其他Socket的连接请求，server的accept方法是阻塞式的  
		         Socket socket = server.accept();  
		         //每接收到一个Socket就建立一个新的线程来处理它  
		         new Thread(new Task(socket)).start();  
		      }  
		   }  
		     
		   *//** 
		    * 用来处理Socket请求的 
		    *//*  
		   static class Task implements Runnable {  
		   
		      private Socket socket;  
		        
		      public Task(Socket socket) {  
		         this.socket = socket;  
		      }  
		        
		      public void run() {  
		         try {  
		            handleSocket();  
		         } catch (Exception e) {  
		            e.printStackTrace();  
		         }  
		      }  
		        
		      *//** 
		       * 跟客户端Socket进行通信 
		      * @throws Exception 
		       *//*  
		      private void handleSocket() throws Exception {  
		         BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "GBK"));  
		         StringBuilder sb = new StringBuilder();  
		         char[] buffer = new char[1024];
					String msg = null;
					//读操作，从服务器中获取数据
					while (br.read(buffer) != -1) {
						
						if(null != msg) {
							msg = msg + new String(buffer);
						} else {
							msg = new String(buffer);
						}	
						*//**
						 * 数据量比较大的时候，会分包发送，当接受到的数据包含--结束符--的时候，表示这一帧数据接收完成，可以进行下一步的操作
						 * 如果接收到的数据包没有包含--结束符--，表示这一帧数据没有接收完成，继续接收
						 *//*
						if(msg.contains(";")) {
							*//**
							 * 对接收的数据进行处理
							 *//*
							String receiveMessage = OurFactory.getSocketMsg().updateReceiveMsg(msg.split(";")[0]);

						} 
						
					}
		       Writer writer = new OutputStreamWriter(socket.getOutputStream(), "UTF-8");  
		         writer.write("你好，客户端。");  
		         writer.write(";\n");  
		         writer.flush();  
		         writer.close();  
		         br.close();  
		         socket.close();  
		      }  
		   } 
		   
		 
		}

*/