package com.es.socket;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class SocketMsg {
	//socket接收消息处理函数
		public String updateReceiveMsg(String receiveMsg) {
			System.out.println(receiveMsg);
			WriteStringToTXTFile(receiveMsg);
			return receiveMsg;
		}
		public void WriteStringToTXTFile(String str) {
			try {
				FileWriter fw = new FileWriter("E://opcData.txt",true);
				BufferedWriter bw = new BufferedWriter(fw);
				bw.append(str);
				bw.write(";\r\n");
				bw.close();
				fw.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
}
