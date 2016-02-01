package com.mafia;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class WaitRoom extends JPanel implements Runnable,ActionListener{
	
	Image				back, logo, up,down,copy;
	
	JScrollPane			jsInfo,jsConver,jsWaitRoom;
	JTable				table1, table2;
	DefaultTableModel 	model1, model2;
	
	// 채팅
	JTextArea			ta;
	JTextField			tf;
	
	// 버튼
	JPanel 				panelBtn;
	JButton				btnCreate, btnHelp, btnExit;
	
	Main				main;
	GameRoom			gameroom;
	
	
	int 				x=0, y=0;
	boolean				check = false;
	
	
	public WaitRoom(Main m) {
		main = m;
		
		back = Toolkit.getDefaultToolkit().getImage("c:\\image\\basic\\wait.jpg");
		logo = Toolkit.getDefaultToolkit().getImage("c:\\image\\basic\\logo.jpg");
		up = Toolkit.getDefaultToolkit().getImage("c:\\image\\basic\\11.png");
		down = Toolkit.getDefaultToolkit().getImage("c:\\image\\basic\\22.jpg");
		copy = Toolkit.getDefaultToolkit().getImage("c:\\image\\basic\\waitcopy.png");
		
		setLayout(null);
		setBounds(0,0,1280,985);
		
		// 3개 버튼을 패널에 묶음
		panelBtn = new JPanel();
		panelBtn.setLayout(new GridLayout(1, 3, 5, 5));
		panelBtn.setBounds(20, 10, 800, 100);
		add(panelBtn);
		
		btnHelp = new JButton("도움말");
		panelBtn.add(btnHelp);	
		btnCreate = new JButton("방만들기");
		panelBtn.add(btnCreate);
		btnExit = new JButton("나가기");
		panelBtn.add(btnExit);
		
		
		// 방
		String[] col1 = {"방이름","공개/비공개","인원"};
		String[][] row1 = new String[0][3];
		model1 = new DefaultTableModel(row1, col1);
		table1 = new JTable(model1);
		jsWaitRoom = new JScrollPane(table1);
		jsWaitRoom.setBounds(20,120,800,400);
		add(jsWaitRoom);
		
		
		
		// 채팅 및 입력창
		ta = new JTextArea();
		jsConver = new JScrollPane(ta);
		jsConver.setBounds(20,525,800,380);
		add(jsConver);

		tf = new JTextField();
		tf.setBounds(20,910,500,30);
		add(tf);
		
		
		
		// 사용자 정보
		String[] col2 = {"닉네임","ID","성별","위치"};
		String[][] row2 = new String[0][4];
		model2 = new DefaultTableModel(row2, col2);
		table2 = new JTable(model2);
		jsInfo = new JScrollPane(table2);
		jsInfo.setBounds(825,530,420,400);
		add(jsInfo);
		
		
		panelBtn.setVisible(false);
		jsInfo.setVisible(false);
		tf.setVisible(false);
		jsConver.setVisible(false);
		jsWaitRoom.setVisible(false);
		
		
		
		
		btnCreate.addActionListener(this);
		btnExit.addActionListener(this);
		tf.addActionListener(this);
		
		
		
		Thread th = new Thread(this);
		th.start();
		
	}
	
	

	@Override
	public void paintComponent(Graphics g) {
		//super.paintComponent(g);
		
		if(check) {
			g.drawImage(back, 0, 0, getWidth(), getHeight(), this);
		
			g.drawImage(logo, 825, 10, 420, 520, this);
		}
		if(!check){
			g.drawImage(copy, 0, 0, getWidth(), getHeight(), this);
			g.drawImage(down, 0, getHeight()/2-10+y, getWidth(), getHeight()/2, this);
			g.drawImage(up, 0, x, getWidth(), getHeight(), this);
			
		}
		
		
	}



	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			int k = 5; // 50
			while(true) {
				Thread.sleep(k);
				y+=2;
				x-=2;
				if(x < -800 || y > 800) {
					break;
				}
				
				// 진짜게임시작할때만
				/*if(x < -100) k = 10;
				else if(x < -200) k = 5;*/
				
				repaint();
			}
			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		check = true;
		repaint();
		
		
		
		// 효과 때문에....
		panelBtn.setVisible(true);
		jsInfo.setVisible(true);
		tf.setVisible(true);
		jsConver.setVisible(true);
		jsWaitRoom.setVisible(true);
			
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == btnCreate) {
			gameroom = new GameRoom(main);
			main.add("Room",gameroom);
			main.card.show(main.getContentPane(), "Room");
			
		}
		else if(e.getSource() == btnExit) {
			main.card.show(main.getContentPane(), "View");
		}
		
		else if(e.getSource() == tf) {
			String str = tf.getText();
			ta.append(str+"\n");
			tf.setText("");
		}
	}





}
