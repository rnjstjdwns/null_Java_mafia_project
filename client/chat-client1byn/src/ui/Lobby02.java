package ui;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

import java.net.*;
import java.util.*;
import java.util.concurrent.*;

import client.Client;
import javafx.application.*;

import javax.swing.*;
import javax.swing.event.*;

import system.UserInfo;

public class Lobby02 extends JFrame{
	JPanel userInfoPanel;
	JPanel buttonPanel;
	JPanel lobbyPanel;
	JList userList, roomList;
	JButton createRoomButton;
	JLabel nicknameLabel, idLabel, winLabel, loseLabel, scoreLabel;
	ImageIcon userImage = new ImageIcon(
			UI.class.getResource("")
	);
	String ip = "127.0.0.1";
	int port = 9876;
	
	ImageIcon[] otherImage;
	
	public Lobby02(Container con, UserInfo userInfo) {
		// TODO Auto-generated constructor stub
		lobbyPanel = new JPanel();
		
	}
}
