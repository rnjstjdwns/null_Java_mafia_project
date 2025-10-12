package client;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.Socket;
//Data를 받는 쓰레드
public class ReceiveDataThread implements Runnable{
	Socket client;
	BufferedReader ois;
	String receiveData;

	public ReceiveDataThread(Socket s, BufferedReader ois) {
		client = s;
		
		this.ois = ois;
	}
	@Override
	public void run() {
		try {
			//receiveData를 받아 null이 아닐 경우 출력함
				while((receiveData = ois.readLine())!= null ) {
					System.out.println(receiveData);
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			finally {
				try {
					ois.close();
					client.close();
				} catch(IOException e2) {
					e2.printStackTrace();
				}
			}
		}
}

