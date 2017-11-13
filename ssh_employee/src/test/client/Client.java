package test.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class Client {

    private Socket client;
 
    public Client() {
        try {
            System.out.println("正在连接服务器......");
 
            client = new Socket("127.0.0.1", 8080);    //阻塞
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintStream out = new PrintStream(client.getOutputStream());;
            boolean flag = true;
 
            System.out.println("成功连接到主机，开始通讯！！");
 
            while (flag) {
                System.out.printf("请输入信息：");
                out.println(input.readLine());  //阻塞
                //判断是否与主机断开
                if (isConnected()) {
                    System.out.println("发生成功！！");
                    System.out.println("主机：" + in.readLine());
                } else {
                    System.out.println("发生失败！！");
                    System.out.println("与服务器断开连接！！");
                    client.close();
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
 
    //判断服务器是否断开的方法，
    //通过OutputStream发送一段测试数据，如果发送失败就表示远端已经断开连接
    //但会与正常的传送干扰，所以用sendUrgenData
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
	      //为了简单起见，所有的异常都直接往外抛  
	     String host = "127.0.0.1";  //要连接的服务端IP地址  
	     int port = 8899;   //要连接的服务端对应的监听端口  
	     //与服务端建立连接  
	     Socket client = new Socket(host, port);  
	      //建立连接后就可以往服务端写数据了  
	     Writer writer = new OutputStreamWriter(client.getOutputStream(), "GBK");  
	      writer.write("你好，服务端。");  
	      writer.write("eof\n");  
	      writer.flush();  
	      //写完以后进行读操作  
	     BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream(), "UTF-8"));  
	      //设置超时间为10秒  
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
	         System.out.println("数据读取超时。");  
	      }  
	      System.out.println("服务端: " + sb);  
	      writer.close();  
	      br.close();  
	      client.close();  
	   }  
}
*/