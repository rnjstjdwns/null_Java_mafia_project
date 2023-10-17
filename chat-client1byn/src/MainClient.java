import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class MainClient {
	String ipAddress;
	static final int port = 8001;
	Socket client = null;
	BufferedReader read;
	PrintWriter oos;
	BufferedReader ois;
	String sendData;
	String receiveData;
	
	String user_id;
	ReceiveDataThread rt;
	
	boolean endflag = false;
	
	public MainClient(String id, String ip) {
		user_id = id;
		ipAddress = ip;
		try {
			System.out.println("*****클라이언트*****");
			client = new Socket(ipAddress, port);
			
			read = new BufferedReader(new InputStreamReader(System.in));
			
			ois = new BufferedReader(new InputStreamReader(client.getInputStream()));
			
			oos = new PrintWriter(client.getOutputStream());
			
			oos.println(user_id);
			
			oos.flush();
			
			rt = new ReceiveDataThread(client, ois);
			
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
				client.close();
				
				System.exit(0);
			} catch(IOException e2) {
				e2.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("아이디를 입력하세요 : ");
		String id = sc.next();
		
		new MainClient(id, "127.0.0.1");
	}
}
