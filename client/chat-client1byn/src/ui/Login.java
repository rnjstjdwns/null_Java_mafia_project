package ui;

import java.awt.*;
import java.awt.event.*;
import java.net.Socket;

import javax.swing.*;
import javax.swing.event.*;

//import client.Client;
import system.DBConnection;
import system.DBLinkUserInfo;
import system.UserInfo;
import system.UserLoginConfirm;

//로그인 / 로그아웃 / 회원 정보 수정 / 방 시스템 구축
//다른 누군가가 접속하고 있다면 접속 안되게 끔 해야함

public class Login extends JFrame{
	
	JLabel loginLabel, idLabel, passLabel, bgLabel;
	JLabel loginStateLabel;
	JPanel  loginPanel, bgPanel;
	JButton loginButton, backButton;
	JTextField idTextField;
	JPasswordField passwordTextField;
	Font titleFont = new Font("나눔 고딕", Font.BOLD, 150);
	Font normalFont = new Font("나눔 고딕", Font.PLAIN, 100);
	Font stateFont = new Font("나눔 고딕",Font.BOLD,25);
	ImageIcon bgImg = new ImageIcon(
		UI.class.getResource("../image/Login (1).jpeg")
	);
	UserInfo userInfo;
	
	String ip;
	int port;
	Socket socket;
//	LoginHandler TSigninHandler = new LoginHandler();
	public Login(Container con, Font normalFont, JPanel[] mainPagePanel) {
		bgLabel = new JLabel(bgImg);
		bgPanel = new JPanel();
		bgPanel.setBounds(0,0,2800,1700);
		loginPanel = new JPanel();
		loginPanel.setBackground(new Color(0,0,0,100));
		con.add(loginPanel);
		con.add(bgPanel);
		bgPanel.add(bgLabel);
		loginPanel.setBounds(500,300,1800,1100);
		loginPanel.setLayout(null);
		
		loginLabel = new JLabel("Login");
		loginLabel.setBounds(700, 100, 800, 200);
		loginLabel.setForeground(Color.white);
		loginLabel.setFont(titleFont);
		
		loginPanel.add(loginLabel);
		
		//오른쪽 공백 너비 x2 + 폭 = 전체 창 화면
		//container안에 있는 컴포넌트를 setBounds 하면 Panel 안에서의 좌표값으로 설정해야함
		idLabel = new JLabel("id");
		idLabel.setBounds(100,400,100,100);
		idLabel.setForeground(Color.white);
		idLabel.setFont(normalFont);
		
		loginPanel.add(idLabel);
		
		idTextField = new JTextField(10);
		idTextField.setBounds(230,400,1200,100);
		idTextField.setFont(normalFont);
		loginPanel.add(idTextField);
		
		passLabel = new JLabel("비밀번호");
		passLabel.setBounds(100,550,500,100);
		passLabel.setForeground(Color.white);
		passLabel.setFont(normalFont);
		
		loginPanel.add(passLabel);
		
		passwordTextField = new JPasswordField();
		passwordTextField.setBounds(500,550,900,100);
		passwordTextField.setFont(normalFont);
		loginPanel.add(passwordTextField);
		
		loginButton = new JButton("로그인");
		loginButton.setBounds(100, 700, 500, 100);
		loginButton.setFont(normalFont);
		loginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DBConnection connection = new DBConnection();
				userInfo = new UserInfo();
				UserLoginConfirm usLC = new UserLoginConfirm(connection, idTextField.getText(), userInfo);
				
				String pw = new String(passwordTextField.getPassword());
				//로그인 성공
				if(idTextField.getText().equals("") && pw.equals("")) {
					loginStateLabel.setText("아이디와 비밀번호를 입력해주세요!");
				}
				else if(idTextField.getText().equals("")) {
					loginStateLabel.setText("아이디를 입력해주세요!");
				} else if(pw.equals("")) {
					loginStateLabel.setText("비밀번호를 입력해주세요!");
				}
				else {
					if(usLC.userLoginCon(pw)) {
						loginSuccess(con);
					} 
					//로그인 실패
					else {
						loginStateLabel.setText("로그인을 다시시도해주세요");
					}
				}
			}
		});
		loginPanel.add(loginButton);
		
		backButton = new JButton("취소");
		backButton.setBounds(1000, 700, 500, 100);
		backButton.setFont(normalFont);
		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				loginPanel.setVisible(false);
				bgPanel.setVisible(false);
				for(int i=0;i<mainPagePanel.length;i++) {
					mainPagePanel[i].setVisible(true);
				}
			}
		});
		loginPanel.add(backButton);
		
		loginStateLabel = new JLabel();
		loginStateLabel.setBounds(100,850,700,50);
		loginStateLabel.setForeground(Color.RED);
		loginStateLabel.setBackground(Color.GRAY);
		loginStateLabel.setOpaque(true);
		loginStateLabel.setFont(stateFont);
		loginPanel.add(loginStateLabel);
	}
	
	
	
	
	
	public void loginSuccess(Container con) {
//		new MainClient(id, ip, port);
		loginPanel.setVisible(false);
		bgPanel.setVisible(false);
		DBConnection connection = new DBConnection();
		new DBLinkUserInfo(connection,idTextField.getText(),userInfo);
		
		new Lobby(con, userInfo);
	}
	
//	public class LoginHandler implements ActionListener{
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			loginTextPanel.setVisible(false);
//			loginPanel.setVisible(false);
//
//		}
//	}
}




