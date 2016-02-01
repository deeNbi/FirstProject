package com.mafia;

import javax.swing.*;
import java.awt.*;

public class GameView extends JPanel {

	Image				back, bsbs;
	
	JPanel				loginPanel;
	JLabel				lblID, lblPW;
	JTextField			tfID;
	JPasswordField		pfPW;
	
	JButton				btnStart, btnRegister;
	
	
	public GameView() {
		
		back = Toolkit.getDefaultToolkit().getImage("c:\\image\\basic\\background.jpg");
		//bsbs = Toolkit.getDefaultToolkit().getImage("c:\\image\\bs.gif");
		setLayout(null);
		
		loginPanel = new JPanel();
		loginPanel.setLayout(null);
		loginPanel.setBounds(500, 750, 300, 250);
		//loginPanel.setBackground(Color.cyan);
		loginPanel.setOpaque(false);
		add(loginPanel);
		
		lblID = new JLabel("I D :");
		lblID.setBounds(30,30,70,30);
		lblID.setFont(new Font("Verdana",Font.BOLD,20));
		lblID.setForeground(Color.black);
		loginPanel.add(lblID);
		
		lblPW = new JLabel("PW :");
		lblPW.setBounds(30,90,70,30);
		lblPW.setFont(new Font("Verdana",Font.BOLD,20));
		lblPW.setForeground(Color.black);
		loginPanel.add(lblPW);
		
		tfID = new JTextField();
		tfID.setBounds(120,30,150,30);
		loginPanel.add(tfID);
		
		pfPW = new JPasswordField();
		pfPW.setBounds(120,90,150,30);
		loginPanel.add(pfPW);
			
		btnStart = new JButton("로그인");
		btnStart.setBounds(40,150,100,50);
		loginPanel.add(btnStart);
		
		btnRegister = new JButton("회원가입");
		btnRegister.setBounds(160,150,100,50);
		loginPanel.add(btnRegister);
		
	}



	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(back, 0, 0, getWidth(), getHeight(), this);
		//g.drawImage(bsbs, 430, 50, this);
	}

	
	
	
}
