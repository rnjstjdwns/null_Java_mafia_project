package ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;


//Times New Roman
//나눔 고딕

public class UI extends JFrame{
	Container con;
	JPanel titleNamePanel, userButtonPanel, bgPanel;
	JLabel titleNameLabel, backgroundLabel, bgLabel;
	JScrollPane bgPane;
	JPanel[] mainPagePanel = new JPanel[3];
	ImageIcon bgImg = new ImageIcon(
		UI.class.getResource("../image/bgImg (1).jpg")
	);
	
	//폰트 사이즈 설정
	Font titleFont = new Font("나눔 고딕", Font.PLAIN, 250);
	Font normalFont = new Font("나눔 고딕", Font.PLAIN, 100);
	
	JButton loginButton;
	JButton signinButton;
	
	public UI() {		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(2800,1700);
		//창의 크기 변경 X
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(null);
		
		con = getContentPane();
		bgLabel = new JLabel(bgImg);
		bgPanel = new JPanel();
		bgPanel.setBounds(0, 0, 2800, 1700);

		//titleName Panel 설정
		titleNamePanel = new JPanel();
		titleNamePanel.setBounds(400, 200, 2000, 300);
		titleNamePanel.setBackground(Color.BLACK);
		
		titleNameLabel = new JLabel("COUP");
		titleNameLabel.setForeground(Color.white);
		titleNameLabel.setFont(titleFont);
		
		userButtonPanel = new JPanel();
		userButtonPanel.setBounds(1100, 800, 600, 300);
		userButtonPanel.setBackground(Color.black);

		loginButton = new JButton("LOGIN");
		loginButton.setBackground(Color.black);
		loginButton.setForeground(Color.white);
		loginButton.setFont(normalFont);
		loginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				bgPanel.setVisible(false);
				titleNamePanel.setVisible(false);
				userButtonPanel.setVisible(false);
				Login login = new Login(con, normalFont, mainPagePanel);
			}
		});
		//타이틀 추가
		signinButton = new JButton("SIGNIN");
		signinButton.setBackground(Color.black);
		signinButton.setForeground(Color.white);
		signinButton.setFont(normalFont);
		signinButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				bgPanel.setVisible(false);
				titleNamePanel.setVisible(false);
				userButtonPanel.setVisible(false);
				SignIn signin = new SignIn(con, normalFont, mainPagePanel);
			}
		});
		
		bgPanel.add(bgLabel);
		titleNamePanel.add(titleNameLabel);
		userButtonPanel.add(loginButton);
		userButtonPanel.add(signinButton);
		
		mainPagePanel[0] = titleNamePanel;
		mainPagePanel[1] = userButtonPanel;
		mainPagePanel[2] = bgPanel;
		con.add(titleNamePanel);
		con.add(userButtonPanel);
		con.add(bgPanel);
		setVisible(true);
	}
}
