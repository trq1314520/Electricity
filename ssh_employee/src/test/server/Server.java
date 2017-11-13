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
	            server = new ServerSocket(8080);    //�˿�
	            System.out.println("���������ڵȵ��ͻ�������......");
	            while (flag) {
	                client = server.accept();   //����
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
	            System.out.println("������ͻ��˳ɹ��������ӣ���ʼͨѶ����");
	        }
	 
	        public void run() {
	            try {
	                /*
	                 * ��ʱ�жϣ����ó�ʱʱ��300�룬�ж����ӻ���300���ڿͻ����޻�Ӧ��Ϣ����Ϊ�ж�
	                 * ȱ����Ǳ���ѳ�ʱʱ�����úܳ�������ͻ��˴���Ҳ��Ϊ��ʱ�����޷��ж��Ƿ�˿�
	                 */
	                clientThread.setSoTimeout(300000);
	                out = new PrintStream(client.getOutputStream());
	                in = new BufferedReader(new InputStreamReader(client.getInputStream()));
	                while (flag) {
	                    String str = in.readLine(); //����
	                    System.out.println("�ͻ��ˣ�" + str);
	                    out.println("�����ɹ����յ�������Ϣ����");
	                }
	                client.close();
	            } catch (Exception e) {
	                //����쳣�������쳣����������ӶϿ�
	                if (e.getMessage() == "Connection reset") {
	                    System.out.println("�ͻ����ѶϿ����ӣ���");
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
//		      //Ϊ�˼���������е��쳣��Ϣ��������  
//		      int port = 8899;  
//		      //����һ��ServerSocket�����ڶ˿�8899��  
//		      ServerSocket server = new ServerSocket(port);  
//		      while (true) {  
//		         //server���Խ�������Socket����������server��accept����������ʽ��  
//		         Socket socket = server.accept();  
//		         //ÿ���յ�һ��Socket�ͽ���һ���µ��߳���������  
//		         new Thread(new Task(socket)).start();  
//		      }  
//		   }  
//		     
//		   /** 
//		    * ��������Socket����� 
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
//		       * ���ͻ���Socket����ͨ�� 
//		      * @throws Exception 
//		       */  
//		      private void handleSocket() throws Exception {  
//		         BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "GBK"));  
//		         StringBuilder sb = new StringBuilder();  
//		         String temp;  
//		         int index;  
//		         while ((temp=br.readLine()) != null) {  
//		            System.out.println(temp);  
//		            if ((index = temp.indexOf("eof")) != -1) {//����eofʱ�ͽ�������  
//		             sb.append(temp.substring(0, index));  
//		                break;  
//		            }  
//		            sb.append(temp);  
//		         }  
//		         System.out.println("�ͻ���: " + sb);  
//		         //�����дһ��  
//		       Writer writer = new OutputStreamWriter(socket.getOutputStream(), "UTF-8");  
//		         writer.write("��ã��ͻ��ˡ�");  
//		         writer.write("eof\n");  
//		         writer.flush();  
//		         writer.close();  
//		         br.close();  
//		         socket.close();  
//		      }  
//		   }  
//}
