package com.mafia;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class Loading extends JPanel implements Runnable{
	
	Image 			back;
	JProgressBar 	bar;
	
	
	WaitRoom		wait;
	Main			main;
	
	public Loading(Main m) {
		main = m;
		
		back = Toolkit.getDefaultToolkit().getImage("c:\\image\\basic\\loading.jpg");
		System.out.println("loading...");
		setLayout(null);
		setBounds(0,0,1280,985);
		
		bar = new JProgressBar(0,100);
		bar.setBounds(100,900,1050,60);
		
		Border border = BorderFactory.createTitledBorder("데이터 읽는중...");
		bar.setBorder(border);
		bar.setStringPainted(true);
		//bar.setOpaque(false);
		add(bar);
		
		Thread th = new Thread(this);
		th.start();		
		

		
	}
	
	public void paintComponent(Graphics g) {
		g.drawImage(back, 0, 0, getWidth(), getHeight(), this);	
		
	}

	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		for(int i=0; i<=100; i++) {
			
			repaint();
			try {
				/*if(i<40)
					Thread.sleep(30);
				else if(i<50)
					Thread.sleep(100);
				else if(i<53)
					Thread.sleep(500);
				else if(i<80)
					Thread.sleep(50);
				else if(i<83)
					Thread.sleep(500);
				else if(i<92)
					Thread.sleep(80);*/
				Thread.sleep(10);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			bar.setValue(i);
			bar.setString("로딩중"+(int)(bar.getPercentComplete()*100)+"%");
			
		} // for
		
		wait = new WaitRoom(main);
		main.add("Wait",wait);
		main.card.show(main.getContentPane(), "Wait");
		
		
		
	} // run
	
}
