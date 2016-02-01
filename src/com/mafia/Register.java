package com.mafia;

import javax.swing.*;
import java.awt.*;

public class Register extends JPanel{
	
	Image				back,register;
	JButton				btnRegister, btnExit, btnIdCheck;
	JLabel				lblNickName, lblID, lblPW, lblTitle;
	JTextField			tfNickName, tfID, tfPW;
	
	
	public Register() {
		
		back = Toolkit.getDefaultToolkit().getImage("c:\\image\\basic\\background.jpg");
		register = Toolkit.getDefaultToolkit().getImage("c:\\image\\basic\\register.jpg");
		
		setLayout(null);
		
		JPanel pn = new JPanel();
		pn.setLayout(null);
		pn.setBounds(400, 230, 600	, 400);
		pn.setOpaque(false);
		add(pn);
		
		lblTitle = new JLabel("회 원 가 입");
		lblTitle.setBounds(200,20,100,30);
		lblTitle.setForeground(Color.white);		//단비: gray->white
		
		lblNickName = new JLabel("닉네임");
		lblNickName.setBounds(50,100,70,30);
		
		tfNickName =new JTextField();
		tfNickName.setBounds(120,100,150,30);
		
		lblID = new JLabel("아이디");
		lblID.setBounds(50,150,70,30);
		lblID.setForeground(Color.white);
		
		tfID = new JTextField();
		tfID.setBounds(120,150,150,30);
		
		btnIdCheck = new JButton("중복확인");
		btnIdCheck.setBounds(300,150,80,30);
		
		lblPW = new JLabel("비밀번호");
		lblPW.setBounds(50,200,70,30);
		lblPW.setForeground(Color.white);
		
		tfPW = new JTextField();
		tfPW.setBounds(120,200,150,30);
		
		
		pn.add(lblTitle);
		pn.add(lblNickName);
		pn.add(tfNickName);
		pn.add(lblID);
		pn.add(tfID);
		pn.add(btnIdCheck);
		pn.add(lblPW);
		pn.add(tfPW);
		
		btnRegister = new JButton("등록");
		btnRegister.setBounds(50,250,80,50);
		
		btnExit = new JButton("취소");
		btnExit.setBounds(150,250,80,50);
		
		pn.add(btnRegister);
		pn.add(btnExit);
		
	
		
	}
	
	public void paintComponent(Graphics g) {
		g.drawImage(back, 0, 0, getWidth(), getHeight(), this);
		g.drawImage(register, 320, 200, 600, 400, this);
	}
	
	
}
