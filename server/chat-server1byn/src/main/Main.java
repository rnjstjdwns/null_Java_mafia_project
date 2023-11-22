package main;

import java.net.*;
import java.util.*;
import java.util.concurrent.*;


import client.Client;
import javafx.application.Platform;

public class Main {
	//근데 왜 여기 굳이 static으로?
	public static ExecutorService threadPool;
	public static Vector<Client> clients = new Vector<Client>();
	Map<String, Boolean> userSignInStatus = new HashMap<>();
	ServerSocket serverSocket;
	
	//서버를 구동시켜서 클라이언트의 연결을 기다리는 메소드
	public void startServer(String IP, int port) {
		try {
			serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress(IP, port));
		} catch(Exception e) {
			e.printStackTrace();
			if(!serverSocket.isClosed()) {
				stopServer();
			}
			return;
		}
		
		//클라이언트가 접속할 때까지 계속 기다리는 쓰레드
		Runnable thread = new Runnable() {
			@Override
			public void run() {
				
				// TODO Auto-generated method stub
				while(true) {
					try {
						//클라이언트 접속시까지 대기
						Socket socket = serverSocket.accept();
						if(socket != null) {
							clients.add(new Client(socket, userSignInStatus));
							System.out.println("[클라인언트 접속]"+socket.getRemoteSocketAddress()+": "+Thread.currentThread().getName());
						}
					} catch (Exception e) {
						if(!serverSocket.isClosed()) {
							stopServer();
						}
						return;
					}
				}
			}
		};
		//
		threadPool = Executors.newCachedThreadPool();
		threadPool.submit(thread);
	}
	
	//서버의 작동을 중지시키는 메소드
	public void stopServer() {
		try {
			//현재 작동 중인 모든 소캣 닫기
			Iterator<Client> iterator = clients.iterator();
			while(iterator.hasNext()) {
				Client client = iterator.next();
				client.socket.close();
				iterator.remove();
			}
			//서버 소캣 닫기
			if(serverSocket != null && !serverSocket.isClosed()) {
				serverSocket.close();
			}
			//쓰레드 풀 종료
			if(threadPool != null && !threadPool.isShutdown()) {
				threadPool.shutdown();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		Main mi = new Main();
		String IP = "127.0.0.1";
		int port = 9876;
		//스레드 실행
		mi.startServer(IP, port);
		
		String message = String.format("[서버시작]\n", IP , port);
		System.out.println(message);
		
	}
}
