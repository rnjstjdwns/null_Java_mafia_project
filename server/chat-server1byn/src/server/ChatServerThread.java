package server;
import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServerThread implements Runnable{
	Socket child;
	//문자 출력 문자 스트림
	BufferedReader ois;
	//문자 입력 문자 스트림
	PrintWriter oos;
	
	String user_id;
	String user_password;
	String user_name;
	//유저 ID, 유저들 PrintWriter //접속자 관리
	HashMap<String, PrintWriter> hm;
	InetAddress ip;
	String msg;
	
	
	public ChatServerThread(Socket s, HashMap<String, PrintWriter> h) {
		//인자로 받은 변수 s를 child에 대입(Socket)
		child = s;
		//인자로 받은 변수 h를 hm에 대입(HashMap)
		hm = h;
		
		try {
			//BufferedReader 객체 생성시 InputStreamReader 객체로 인자를 받음
			ois = new BufferedReader(new InputStreamReader(child.getInputStream()));
			
			oos = new PrintWriter(child.getOutputStream());
			
			user_id = ois.readLine();
			
			ip = child.getInetAddress();
			
			System.out.println(ip+"로부터 "+user_id+"님이 접속하였습니다.");
			
			broadcast(user_id+"님이 접속하였습니다.");
			
			synchronized (hm) {
				hm.put(user_id, oos);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void run() {
		String receiveData;
		try {
			while((receiveData = ois.readLine()) != null) {
				
				if(receiveData.equals("/quit")) {
					synchronized (hm) {
						hm.remove(user_id);
					}
					
					break;
				}
				//귓속말
				else if(receiveData.indexOf("/to") >= 0) {
					sendMsg(receiveData);
				}
				//전체 메세지 보내기
				else {
					System.out.println(user_id+" >> "+receiveData);
					broadcast(user_id+" >> "+receiveData);
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			synchronized (hm) {
				hm.remove(user_id);
			}
			
			broadcast(user_id + "님이 퇴장했습니다.");
			System.out.println(user_id+"님이 퇴장했습니다.");
			
			try {
				if(child != null) {
					ois.close();
					oos.close();
					child.close();
				}
			} catch(Exception e) {
				
			}
			
		}
	}
	public void broadcast(String message) {
		synchronized (hm) {
			try {
				for(PrintWriter oos : hm.values()) {
					oos.println(message);
					oos.flush();
				} 
			} catch(Exception e) {
				
			}
		}
	}
	public void sendMsg(String message) {
		System.out.println("*");
		int begin = message.indexOf(" ")+1;
		int end = message.indexOf(" ", begin);
		System.out.println(begin+" "+end);
		if(end != -1) {
			String id = message.substring(begin, end);
			
			String msg = message.substring(end+1);
			
			PrintWriter oos = hm.get(id);
			try {
				if(oos != null) {
					oos.println(user_id+"님이 다음과 같은 귓속말을 보내셨습니다. : "+msg);
					oos.flush();
				}
			} catch(Exception e) {
				
			}
		}
	}
}
