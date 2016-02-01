package com.mafia;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameRoom extends JPanel implements ActionListener,Runnable{

	Image				back, game, logo,mafialogo;
	
	JPanel				gamePanel, btnPanel;
	
	JLabel				lblHint;
	JButton				btnReady, btnExit, btnHelp, btnSumHint;

	JTextArea			ta;
	JTextField			tf;
	JScrollPane			jsConver;
	
	
	
	
	Main				main;
	Thread 				ee;
	
	int 				x=420,y=85;
	boolean				bStart;
	boolean				bGifEnd;
	
	public GameRoom(Main m) {
		main = m;
		
		back = Toolkit.getDefaultToolkit().getImage("c:\\image\\basic\\gameroom.jpg");
		game = Toolkit.getDefaultToolkit().getImage("c:\\image\\basic\\ggg.png");
		logo = Toolkit.getDefaultToolkit().getImage("c:\\image\\basic\\position.gif");
		mafialogo = Toolkit.getDefaultToolkit().getImage("c:\\image\\basic\\mafialogo.png");
		
		bStart = false;
		bGifEnd = false;		
		
		setLayout(null);
		setBounds(0,0,1280,985);
		
		// 게임 패널
		gamePanel = new JPanel();
		gamePanel.setLayout(null);
		gamePanel.setBounds(0, 0, 1000, 985);
		gamePanel.setOpaque(false);
		add(gamePanel);
		
		lblHint = new JLabel("범인은 문 가까이에 있습니다.");
		lblHint.setBounds(50,30,900,50);
		lblHint.setForeground(Color.pink);
		lblHint.setHorizontalAlignment(SwingConstants.CENTER);
		gamePanel.add(lblHint);
		
		
		
		
		
		// 채팅 및 입력창
		ta = new JTextArea();
		jsConver = new JScrollPane(ta);
		jsConver.setBounds(10,730,900,200);
		add(jsConver);

		tf = new JTextField();
		tf.setBounds(10,940,500,30);
		add(tf);
		
		
		
		
		
		
		
		
		
		
		
		
		
		// 버튼 패널
		btnPanel = new JPanel();
		btnPanel.setLayout(null);
		btnPanel.setBounds(950, 760, 285, 225);
		btnPanel.setOpaque(false);
		//btnPanel.setBackground(Color.red);
		add(btnPanel);
		
		btnReady = new JButton("Ready");
		btnReady.setBounds(25,30, 100, 50);
		btnPanel.add(btnReady);
		
		btnHelp = new JButton("Help");
		btnHelp.setBounds(150,30, 100, 50);
		btnPanel.add(btnHelp);
		
		btnSumHint = new JButton("Hint");
		btnSumHint.setBounds(25,110, 100, 50);
		btnPanel.add(btnSumHint);
		
		btnExit = new JButton("Exit");
		btnExit.setBounds(150,110, 100, 50);
		btnPanel.add(btnExit);
		
		
		btnExit.addActionListener(this);
		tf.addActionListener(this);
		btnReady.addActionListener(this);
	}


	@Override
	protected void paintComponent(Graphics g) {
		
		g.drawImage(back, 0, 0, getWidth(), getHeight(), this);
		g.drawImage(game, 10, 25, 900, 685, this);
		g.drawImage(mafialogo, 925, 25, 340, 150, this);
		//g.drawImage(logo, 420, 25, 340, 500, this);
		
		if(bStart && !bGifEnd) {
			g.drawImage(logo, 420, 85,340,500,this);
		}
		if(bStart && bGifEnd) {
			g.drawImage(logo, x, y, 340, 500, this);
		}
		
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == btnExit) {
			main.card.show(main.getContentPane(), "Wait");
		}
		else if(e.getSource() == tf) {
			String str = tf.getText();
			ta.append(str+"\n");
			tf.setText("");
		}
		else if(e.getSource() == btnReady) {
			repaint();
			ee = new Thread(this);
			bStart = true;
			ee.start();
		}
		
		
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		int count = 0;
		
		try {
			Thread.sleep(5500);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		bGifEnd = true;
		
		while(true) {
			repaint();
			try {
				Thread.sleep(2);
				
				if(x==925) x = 925;
				else {
					x++;
					count++;
				}
				
				if(y==200) y = 200;
				else if(count==5){
					y++;
					count = 0;
				}
				
				if(x==925 && (y>=180 && y<=200)) {
					break;
				}
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} // while
		
	}

	
}
