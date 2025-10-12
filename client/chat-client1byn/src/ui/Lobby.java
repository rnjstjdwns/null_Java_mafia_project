package ui;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;

import client.Client;
import javafx.application.Platform;

import javax.swing.*;
import javax.swing.event.*;

import system.UserInfo;
//..님이 방애 접속하였습니다
//서버 없으면 서버 점검으로 접속 실패되게 하기
//브금, 버튼 눌렀을때 나오는 효과음
//게임
//앱으로 만들기 보류
public class Lobby extends JFrame{
	JTextArea textArea;
	JPanel lobbyPanel;
	JPanel userInfoPanel, msgPanel;
	JTextField msgTextField; 
	JButton exitButton, sendButton;
	TextSendListener textSendHandler = new TextSendListener();
	JLabel nicknameLabel, idLabel, passwordLabel;
	
	Font titleFont = new Font("나눔 고딕", Font.BOLD, 150);
	Font normalFont = new Font("나눔 고딕", Font.PLAIN, 30);
	Font inputFont = new Font("나눔 고딕", Font.BOLD,70);
	Socket socket = null;
	
//	Map<String, new ImageIcon(new URL)>
	
	String ip = "127.0.0.1";
	int port = 9876;
	
	String nickname;
	public void startClient(String ip, int port) {
		Thread thread = new Thread() {
			public void run() {
				try {
					socket = new Socket(ip, port);
					receive(textArea);
				} catch(Exception e) {
					if(!socket.isClosed()) {
						stopClient();
						System.out.println("[서버 접속 실패]");
					}
				}
			}
		};
		thread.start();
	}
	
	//서버로부터 메시지를 전달받는 메소드
	public void receive(JTextArea textArea) {
		while(true) {
			try {
				//바이트 스트림
				InputStream in = socket.getInputStream();
				byte[] buffer = new byte[512];
				int length = in.read(buffer);

				if(length == -1) {
					throw new IOException();
				}
				String message = new String(buffer, 0, length, "UTF-8");
				System.out.println("전달받은 메세지" + message);
				textArea.append(message);

			} catch(Exception e) {
				stopClient();
				break;
			}
		}
	}
	
	public void stopClient() {
		try {
			if(socket != null && !socket.isClosed()) {
				socket.close();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	//서버로 메시지를 전송하는 메소드
	public void send(String message) {
		Thread thread = new Thread() {
			public void run() {
				try {
					System.out.println("*");
					OutputStream out = socket.getOutputStream();
					byte[] buffer = message.getBytes("UTF-8");
					out.write(buffer);
					out.flush();
				} catch(Exception e) {
					stopClient();
				}
			}
		};
		thread.start();
	}
	
	public Lobby(Container con, UserInfo userInfo) {
		
		
		nickname = userInfo.getNickname();
		lobbyPanel = new JPanel();
		lobbyPanel.setBounds(400,100,2000,1500);
		lobbyPanel.setLayout(new BorderLayout(20,20));
		
		lobbyPanel.setBackground(Color.white);
		con.add(lobbyPanel);
		
		userInfoPanel = new JPanel();
		userInfoPanel.setLayout(new FlowLayout(FlowLayout.LEFT,10,0));
		
		idLabel = new JLabel("id : "+userInfo.getId());
		idLabel.setForeground(Color.black);
		idLabel.setFont(normalFont);
		
		passwordLabel = new JLabel("pwd : "+userInfo.getPassword());
		passwordLabel.setForeground(Color.black);
		passwordLabel.setFont(normalFont);
		
		nicknameLabel = new JLabel("nick : "+userInfo.getNickname());
		nicknameLabel.setForeground(Color.black);
		nicknameLabel.setFont(normalFont);
		
		userInfoPanel.add(idLabel);
		userInfoPanel.add(passwordLabel);
		userInfoPanel.add(nicknameLabel);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setFont(normalFont);
		lobbyPanel.add(new JScrollPane(textArea), BorderLayout.CENTER);
		lobbyPanel.add(userInfoPanel, BorderLayout.NORTH);
		msgPanel = new JPanel();
		lobbyPanel.add(msgPanel, BorderLayout.SOUTH);
		
		msgPanel.setLayout(new FlowLayout(FlowLayout.LEFT,10,0));
		msgTextField = new JTextField(10);
		msgTextField.setFont(inputFont);
		msgTextField.requestFocus();
		msgTextField.addActionListener(textSendHandler);
		exitButton = new JButton("종료하기");
		exitButton.setFont(normalFont);
		exitButton.setPreferredSize(new Dimension(300, 170));
		exitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				stopClient();
				textArea.append("[ 채팅방 퇴장 ]\n");

			}
		});
		
		sendButton = new JButton("보내기");
		sendButton.addActionListener(textSendHandler);
		sendButton.setFont(normalFont);
		sendButton.setPreferredSize(new Dimension(300, 170));
		
		
		msgPanel.add(exitButton);
		msgPanel.add(msgTextField);
		msgPanel.add(sendButton);
		
		lobbyPanel.setVisible(true);
		System.out.println("채팅 시작");
		textArea.append("[ 채팅방 접속 ]\n");
		startClient(ip, port);

	}
	public class TextSendListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(!msgTextField.getText().equals("")) {
				send(nickname+": "+msgTextField.getText()+"\n");
				msgTextField.setText("");
				msgTextField.requestFocus();
			}
		}
	}
}
//접속하면 ~~가 접속하였습니다 라고 떠야함
