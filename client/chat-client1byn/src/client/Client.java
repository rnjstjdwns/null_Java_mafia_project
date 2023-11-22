package client;
import java.io.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
import java.util.*;

import javax.swing.JTextArea;

import javafx.application.Platform;
import ui.UI;

public class Client {
	String ipAddress;
//	static final int port = 9003;
	Socket socket = null;
	BufferedReader read;
	PrintWriter oos;
	BufferedReader ois;
	String sendData;
	String receiveData;
	JTextArea textArea;
	String user_id;
	ReceiveDataThread rt;
	
	boolean endflag = false;
	
	


	
	
	public Client(String ip, int port) {
		
		
		ipAddress = ip;
		try {
			System.out.println("*****클라이언트*****");
			socket = new Socket(ipAddress, port);
			
			read = new BufferedReader(new InputStreamReader(System.in));
			
			ois = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			oos = new PrintWriter(socket.getOutputStream());
			
			oos.println(user_id);
			
			oos.flush();
			
			rt = new ReceiveDataThread(socket, ois);
			
			Thread t = new Thread(rt);
			
			t.start();
			
			while(true) {
				sendData = read.readLine();
				
				oos.println(sendData);
				
				oos.flush();
				
				if(sendData.equals("/quit")) {
					endflag = true;
					break;
				}
			}
			System.out.println("클라이언트의 접속을 종료합니다.");
			System.exit(0);
					
					
		} catch(Exception e) {
			if(!endflag) e.printStackTrace();
		} 
		finally {
			try {
				ois.close();
				oos.close();
				socket.close();
				
				System.exit(0);
			} catch(IOException e2) {
				e2.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new Client("127.0.0.1", 8000);
	}
}
