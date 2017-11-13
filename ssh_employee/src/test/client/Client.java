package test.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class Client {

    private Socket client;
 
    public Client() {
        try {
            System.out.println("�������ӷ�����......");
 
            client = new Socket("127.0.0.1", 8080);    //����
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintStream out = new PrintStream(client.getOutputStream());;
            boolean flag = true;
 
            System.out.println("�ɹ����ӵ���������ʼͨѶ����");
 
            while (flag) {
                System.out.printf("��������Ϣ��");
                out.println(input.readLine());  //����
                //�ж��Ƿ��������Ͽ�
                if (isConnected()) {
                    System.out.println("�����ɹ�����");
                    System.out.println("������" + in.readLine());
                } else {
                    System.out.println("����ʧ�ܣ���");
                    System.out.println("��������Ͽ����ӣ���");
                    client.close();
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
 
    //�жϷ������Ƿ�Ͽ��ķ�����
    //ͨ��OutputStream����һ�β������ݣ��������ʧ�ܾͱ�ʾԶ���Ѿ��Ͽ�����
    //�����������Ĵ��͸��ţ�������sendUrgenData
    public boolean isConnected() {
        try {
            client.sendUrgentData(0xFF);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
 
    public static void main(String[] args) {
        new Client();
    }
}

/*import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class Client {
	 public static void main(String args[]) throws Exception {  
	      //Ϊ�˼���������е��쳣��ֱ��������  
	     String host = "127.0.0.1";  //Ҫ���ӵķ����IP��ַ  
	     int port = 8899;   //Ҫ���ӵķ���˶�Ӧ�ļ����˿�  
	     //�����˽�������  
	     Socket client = new Socket(host, port);  
	      //�������Ӻ�Ϳ����������д������  
	     Writer writer = new OutputStreamWriter(client.getOutputStream(), "GBK");  
	      writer.write("��ã�����ˡ�");  
	      writer.write("eof\n");  
	      writer.flush();  
	      //д���Ժ���ж�����  
	     BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream(), "UTF-8"));  
	      //���ó�ʱ��Ϊ10��  
	     client.setSoTimeout(10*1000);  
	      StringBuffer sb = new StringBuffer();  
	      String temp;  
	      int index;  
	      try {  
	         while ((temp=br.readLine()) != null) {  
	            if ((index = temp.indexOf("eof")) != -1) {  
	                sb.append(temp.substring(0, index));  
	                break;  
	            }  
	            sb.append(temp);  
	         }  
	      } catch (SocketTimeoutException e) {  
	         System.out.println("���ݶ�ȡ��ʱ��");  
	      }  
	      System.out.println("�����: " + sb);  
	      writer.close();  
	      br.close();  
	      client.close();  
	   }  
}
*/