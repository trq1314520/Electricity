package test.server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	   private ServerSocket server;
	    private Socket client;
	 
	    public Server() {
	        boolean flag = true;
	        try {
	            server = new ServerSocket(8080);    //端口
	            System.out.println("服务器正在等到客户端连接......");
	            while (flag) {
	                client = server.accept();   //阻塞
	                new ServerThread(client).start();
	            }
	            server.close();
	        } catch (Exception e) {
	        }
	    }
	 
	    public static void main(String[] args) {
	        new Server();
	    }
	 
	    private class ServerThread extends Thread {
	 
	        private Socket clientThread;
	        private PrintStream out;
	        private BufferedReader in;
	        private boolean flag = true;
	 
	        public ServerThread(Socket client) {
	            this.clientThread = client;
	            System.out.println("主机与客户端成功建立连接，开始通讯！！");
	        }
	 
	        public void run() {
	            try {
	                /*
	                 * 超时判断：设置超时时间300秒，中断连接或者300秒内客户端无回应信息则认为中断
	                 * 缺点便是必须把超时时间设置很长，否则客户端待机也认为超时处理，无法判断是否端口
	                 */
	                clientThread.setSoTimeout(300000);
	                out = new PrintStream(client.getOutputStream());
	                in = new BufferedReader(new InputStreamReader(client.getInputStream()));
	                while (flag) {
	                    String str = in.readLine(); //阻塞
	                    System.out.println("客户端：" + str);
	                    out.println("主机成功接收到您的信息！！");
	                }
	                client.close();
	            } catch (Exception e) {
	                //如果异常是连接异常，则输出连接断开
	                if (e.getMessage() == "Connection reset") {
	                    System.out.println("客户端已断开连接！！");
	                }
	            }
	        }
	    }
	}
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.OutputStreamWriter;
//import java.io.Writer;
//import java.net.ServerSocket;
//import java.net.Socket;
//
//
//
//public class Server {
//	   public static void main(String args[]) throws IOException {  
//		      //为了简单起见，所有的异常信息都往外抛  
//		      int port = 8899;  
//		      //定义一个ServerSocket监听在端口8899上  
//		      ServerSocket server = new ServerSocket(port);  
//		      while (true) {  
//		         //server尝试接收其他Socket的连接请求，server的accept方法是阻塞式的  
//		         Socket socket = server.accept();  
//		         //每接收到一个Socket就建立一个新的线程来处理它  
//		         new Thread(new Task(socket)).start();  
//		      }  
//		   }  
//		     
//		   /** 
//		    * 用来处理Socket请求的 
//		    */  
//		   static class Task implements Runnable {  
//		   
//		      private Socket socket;  
//		        
//		      public Task(Socket socket) {  
//		         this.socket = socket;  
//		      }  
//		        
//		      public void run() {  
//		         try {  
//		            handleSocket();  
//		         } catch (Exception e) {  
//		            e.printStackTrace();  
//		         }  
//		      }  
//		        
//		      /** 
//		       * 跟客户端Socket进行通信 
//		      * @throws Exception 
//		       */  
//		      private void handleSocket() throws Exception {  
//		         BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "GBK"));  
//		         StringBuilder sb = new StringBuilder();  
//		         String temp;  
//		         int index;  
//		         while ((temp=br.readLine()) != null) {  
//		            System.out.println(temp);  
//		            if ((index = temp.indexOf("eof")) != -1) {//遇到eof时就结束接收  
//		             sb.append(temp.substring(0, index));  
//		                break;  
//		            }  
//		            sb.append(temp);  
//		         }  
//		         System.out.println("客户端: " + sb);  
//		         //读完后写一句  
//		       Writer writer = new OutputStreamWriter(socket.getOutputStream(), "UTF-8");  
//		         writer.write("你好，客户端。");  
//		         writer.write("eof\n");  
//		         writer.flush();  
//		         writer.close();  
//		         br.close();  
//		         socket.close();  
//		      }  
//		   }  
//}
