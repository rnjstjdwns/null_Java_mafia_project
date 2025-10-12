package server;

import java.awt.image.*;
import java.io.*;
import java.net.*;
import java.util.*;

import javax.imageio.*;	

public class ServerFileUploadThread implements Runnable{
	Socket socket;
	InputStream in;
	FileOutputStream fout;
	DataInputStream dis;
	public Map<String, Boolean> userSignInStatus;
	public ServerFileUploadThread(Socket s,Map<String, Boolean> userSignInStatus) {
		socket = s;
		this.userSignInStatus = userSignInStatus;
		
		File saveDir = new File("C:\\coup\\userImage\\");
		
		//저장할 폴더가 없으면 만들어줌
		if(!saveDir.exists()) {
			saveDir.mkdir();
		}
		try {
			
			
			//헤당 링크에 이미지 저장
			
			fout = new FileOutputStream("\\upload.png");
			ImageIO.write(bimg, "png", fout);
			fout.close();
		} catch(IOException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			in = socket.getInputStream();
			//파일 이름을 String으로 받기 위해 사용
			dis = new DataInputStream(in);
			//사용자 ID 받기
			String userId = dis.readUTF();
			
			if()
			//파일 이름 받기
			String fileName = dis.readUTF();
			
			//파일 내용 받기 및 저장
			fout = new FileOutputStream("C:\\coup\\userImage\\"+fileName);
			byte[] buffer = new byte[4096];
			int bytesRead;
			
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
