package client;

import java.io.*;
import java.net.*;
import java.util.*;

import main.Main;
import server.ServerFileUploadThread;

public class Client {
	public Socket socket;
	public Map<String, Boolean> userSignInStatus;
	public Client(Socket socket, Map<String, Boolean> userSignInStatus) {
		this.socket = socket;
		this.userSignInStatus = userSignInStatus;
		receive();
	}
	public void fileUpload() {
		Thread fileUploadThread = new Thread(new ServerFileUploadThread(socket, userSignInStatus));
		Main.threadPool.submit(fileUploadThread);
	}
	//클라이언트로부터 메시지를 전달 받는 메소드
	public void receive() {
		//thread 생성	
		Runnable thread = new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					//연결한 클라의 메시지 정보를 받을 스트림 생성 
					InputStream in = socket.getInputStream();
					byte[] buffer = new byte[512];
					//버퍼에 엤는 메시지의 길이를 읽음
					int length = in.read(buffer);
					while(length == -1) throw new IOException();
					System.out.println("[메시지 수신 성공] "+socket.getRemoteSocketAddress()+": "+Thread.currentThread().getName());
					System.out.println(socket.getInetAddress());
					String message = new String(buffer, 0, length, "UTF-8");
					for(Client client : Main.clients) {
						//모든 클라이언트에게 메시지 전달함
						System.out.println("*");
						System.out.print(message);
						client.send(message);
					}
				} catch(Exception e) {
					try {
						System.out.println("[메시지 수신 오류] "+socket.getRemoteSocketAddress()+": "+Thread.currentThread().getName());
						e.printStackTrace();
					} catch(Exception e2) {
						e2.printStackTrace();
					}
				}
			}
		};
		Main.threadPool.submit(thread);
	}
	
	//클라이언트에게 메시지를 전송하는 메소드
	public void send(String message) {
		Runnable thread = new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					OutputStream out = socket.getOutputStream();
					byte[] buffer = message.getBytes("UTF-8");
					out.write(buffer);
					//끝까지 읽음
					out.flush();
					
				} catch(Exception e) {
					try {
						System.out.println(message);
						e.printStackTrace();
						System.out.println("[메시지 송신 오류] "+socket.getRemoteSocketAddress()+": "+Thread.currentThread().getName());
						Main.clients.remove(Client.this);
						socket.close();
					} catch(Exception e2) {
						e2.printStackTrace();
					}
				}
				
				
			}
		};
		Main.threadPool.submit(thread);
	}
}
