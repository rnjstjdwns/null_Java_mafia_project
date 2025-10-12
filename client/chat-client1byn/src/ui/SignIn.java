package ui;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.awt.image.*;
import java.io.*;
import java.net.Socket;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.*;

import system.DBConnection;
import system.DBUserInsert;
// To do
/*
 * 1. DB 연결
 * 2. 사진 업로드
 * */
public class SignIn extends JFrame{
	JPanel siginPanel, bgPanel;
	JLabel siginLabel, idLabel, passwordLabel, nicknameLabel, bgLabel;
	JLabel siginStateLabel;
	JTextField idTextField, nicknameTextField;
	JPasswordField passTextField;
	ImgPanel imgPanel;
	JLabel imgLabel;
	File imgFile = new File("");
	BufferedImage bufferedImg = null;
	JButton siginButton, backButton;
	DBConnection dbconnect = new DBConnection();
	
	Font titleFont = new Font("나눔 고딕", Font.BOLD, 150);
	Font normalFont = new Font("나눔 고딕", Font.PLAIN, 30);
	Font inputFont = new Font("나눔 고딕", Font.BOLD,70);
	Font stateFont = new Font("나눔 고딕",Font.BOLD,25);
	ImageIcon bgImg = new ImageIcon(
			UI.class.getResource("../image/signin (1).jpg")
	);
	
	String path = "C:\\coupUserImage";
	File folder;
	
	DataOutputStream dos;
	Socket socket;
	
	
	//이미지 패널
	class ImgPanel extends JPanel {
		//이미지
		BufferedImage image;
		
		public void displayImage(File file) {
			try {
				//실제 이미지 파일 읽어들임
				Image originalImage = ImageIO.read(file);
				//실제 이미지를 알맞은 크기로 축소 시킴
				Image scaledImage = originalImage.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
				//축소 시킨 이미지 만듦
				image = createCircularImage(scaledImage);
				repaint();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		BufferedImage createCircularImage(Image originalImage) {
			int diameter = Math.min(originalImage.getWidth(null), originalImage.getHeight(null));
	        BufferedImage circularImage = new BufferedImage(diameter, diameter, BufferedImage.TYPE_INT_ARGB);
	        Graphics2D g2 = circularImage.createGraphics();
	        g2.setClip(new Ellipse2D.Float(0, 0, diameter, diameter));
	        g2.drawImage(originalImage, 0, 0, null);
	        g2.dispose();

	        return circularImage;
		}
 		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			int diameter = Math.min(getWidth(), getHeight());
	        g.setColor(Color.white);
	        g.drawOval((getWidth() - diameter) / 2, (getHeight() - diameter) / 2, diameter, diameter);

	        if (image != null) {
	            // Draw the image inside the circular background
	            int x = (getWidth() - image.getWidth()) / 2;
	            int y = (getHeight() - image.getHeight()) / 2;
	            g.drawImage(image, x, y, this);
	        }
		}
	}
	
	
	public SignIn(Container con, Font normalFont, JPanel[] mainPagePanel) {
		bgLabel = new JLabel(bgImg);
		bgPanel = new JPanel();
		bgPanel.setBounds(0, 0, 2800, 1700);
		
		siginPanel = new JPanel();
		siginPanel.setLayout(null);
		siginPanel.setBackground(new Color(0,0,0,100));
		siginPanel.setBounds(500,100,1800,1500);
		
		imgPanel = new ImgPanel();
		imgPanel.setOpaque(true);
		imgPanel.setBackground(Color.gray);
		imgPanel.setBounds(750,300,300,300);
		imgPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				uploadImage();
			}
		});
		
		
		siginPanel.add(imgPanel);
		siginLabel = new JLabel("SignIn");
		siginLabel.setBounds(700,100,800,200);
		siginLabel.setFont(titleFont);
		siginLabel.setForeground(Color.black);
		siginPanel.add(siginLabel);
		
		
		
		idLabel = new JLabel("id");
		idLabel.setBounds(100,700,100,100);
		idLabel.setForeground(Color.black);
		idLabel.setFont(normalFont);
		
		siginPanel.add(idLabel);
		
		idTextField = new JTextField(10);
		idTextField.setBounds(230,700,1200,100);
		idTextField.setFont(normalFont);
		siginPanel.add(idTextField);
		
		passwordLabel = new JLabel("비밀번호");
		passwordLabel.setBounds(100,850,500,100);
		passwordLabel.setForeground(Color.black);
		passwordLabel.setFont(normalFont);
		
		siginPanel.add(passwordLabel);
		
		passTextField = new JPasswordField();
		passTextField.setBounds(500,850,900,100);
		passTextField.setFont(normalFont);
		siginPanel.add(passTextField);
		
		nicknameLabel = new JLabel("닉네임");
		nicknameLabel.setBounds(100,1000,500,100);
		nicknameLabel.setForeground(Color.black);
		nicknameLabel.setFont(normalFont);
		
		nicknameTextField = new JTextField(10);
		nicknameTextField.setBounds(500,1000,1000,100);
		nicknameTextField.setFont(normalFont);
		siginPanel.add(nicknameTextField);
		
		siginButton = new JButton("SIGNIN");
		siginButton.setBounds(100, 1200, 500, 100);
		siginButton.setFont(normalFont);
		siginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = idTextField.getText();
				String pw = new String(passTextField.getPassword());
				String nickname = nicknameTextField.getText();
				
				DBConnection dbconnect = new DBConnection();
				if(!id.equals("") && !pw.equals("") && !nickname.equals("")) {
					new DBUserInsert(dbconnect, id, pw, nickname);
					path = path+"\\"+id;
					folder = new File(path);
					if(!folder.exists()) {
						try {
							folder.mkdir();
							System.out.println("폴더가 생성되었습니다.");
						} catch(Exception ex) {
							ex.getStackTrace();
						}
					} else {
						System.out.println("이미 폴더가 생성되어 있습니다");
					}
					try {
						bufferedImg = ImageIO.read(imgFile);
						ImageIcon imgIcon = new ImageIcon(bufferedImg);
						imgLabel.setIcon(imgIcon);
						
						uploadImg(imgLabel,id,path,folder);
						
						
					} catch(Exception ex) {
						ex.printStackTrace();
					}
					
					siginStateLabel.setText("회원가입을 완료하였습니다");
					
					idTextField.setText("");
					passTextField.setText("");
					nicknameTextField.setText("");

				} else {
					siginStateLabel.setText("회원가입을 다시시도해주세요");
				} 					
				dbconnect.connection_close();
			}
		});
		backButton = new JButton("취소");
		backButton.setBounds(1000,1200,500,100);
		backButton.setFont(normalFont);
		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				siginPanel.setVisible(false);
				bgPanel.setVisible(false);
				for(int i=0;i<mainPagePanel.length;i++) {
					mainPagePanel[i].setVisible(true);
				}
			}
		});
		siginStateLabel = new JLabel();
		siginStateLabel.setBounds(100,1350,1000,50);
		siginStateLabel.setForeground(Color.RED);
		siginStateLabel.setBackground(Color.GRAY);
		siginStateLabel.setOpaque(true);
		siginStateLabel.setFont(stateFont);
		
		con.add(siginPanel);
		siginPanel.add(nicknameLabel);
		siginPanel.add(backButton);
		siginPanel.add(siginButton);
		siginPanel.add(siginStateLabel);

		
		con.add(bgPanel);
		bgPanel.add(bgLabel);

		
	}
	void uploadImage() {
		JFileChooser fileChooser = new JFileChooser();
		int result = fileChooser.showOpenDialog(this);
		//?
		if(result == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile();
			imgPanel.displayImage(selectedFile);
		}
	}
	
	void uploadImg(JLabel imgLabel, String id, String path, File file) {
		try {
			socket = new Socket("localhost", 12345);
			dos = new DataOutputStream(socket.getOutputStream());
			//이미지 파일 이름 전송
			dos.writeUTF(id);
			
			//이미지 파일 내용 전송
			FileInputStream fis = new FileInputStream(imgFile);
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		
	}
}
