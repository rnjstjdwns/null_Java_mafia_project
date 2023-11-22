package server;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class MainServer {
	int port = 8000;
	ServerSocket server = null;
	Socket child = null;
	//PrintWriter : 문자 쓰는 문자 스트림
	HashMap<String, PrintWriter> hm;
	public MainServer() {
		//브로드 캐스팅을 하기위한 쓰레드 객체
		ChatServerThread sr;
		//쓰레드 만듦
		Thread t;
		
		try {
			//서버소캣 생성해 server 변수에 대입
			server = new ServerSocket(port);
			
			System.out.println("채팅 서버");
			System.out.println("클라이언트의 접속을 기다립니다.");
			//hashMap 객체를 생성해 hm 변수에 대입
			hm = new HashMap<String, PrintWriter>();
			
			while(true) {
				//ServerSocket의 변수인 server를 이용해 accept함수 호출을 하여
				//클라이언트 접속시까지 대기를 합니다
				//접속시에는 클라이언트와 연결 됩니다
				//클라이언트의 소켓을 연결받습니다
				child = server.accept();
				
				//Socket타입에 변수인 child가 null 값이 아니면 실행
				//child에는 클라이언트 소켓과 연결을 할 수 있는 소켓입니다
				if(child != null) {
					//ChatServerThread 객체를 Socket과 HashMap을 받아서 생성 후에
					//ChatServerThread의 변수인 sr에 대입
					sr = new ChatServerThread(child, hm);
					
					//Thread객체를 ChatServerThread을 받아서 생성 후
					//Thread의 변수인 t에 대입
					t = new Thread(sr);
					//쓰레드 시작
					t.start();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new MainServer();
	}
}
