package com.mafia;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;

public class Main extends JFrame implements ActionListener{

	CardLayout card = new CardLayout();
	
	GameView	view = new GameView();
	Loading		load ;
	Register 	register;
	
	public Main() {
		
		setLayout(card);
		setSize(1280,985);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
			
		// 패널순서
		add("View",view);		
		
		// 이벤트처리
		view.btnStart.addActionListener(this);
		view.btnRegister.addActionListener(this);
		
		// 전체화면
		GraphicsEnvironment.getLocalGraphicsEnvironment().
        getDefaultScreenDevice().setFullScreenWindow(this);
		
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			//UIManager.setLookAndFeel("com.jtattoo.plaf.noire.NoireLookAndFeel");
			UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		Main project = new Main();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == view.btnStart) {				
			load = new Loading(this);
			add("Load",load);
			
			card.show(getContentPane(), "Load");
			
		}
		else if(e.getSource() == view.btnRegister) {
			
			register = new Register();
			add("Register",register);
			register.btnExit.addActionListener(this);
			register.btnRegister.addActionListener(this);
			
			card.show(getContentPane(), "Register");
			
		}
		else if(e.getSource() == register.btnExit) {
			card.show(getContentPane(), "View");
		}
		
		else if(e.getSource() == register.btnRegister) {
			card.show(getContentPane(), "View");
			JOptionPane.showMessageDialog(this, "정보가 등록되었습니다.");
			view.requestFocus();
		}
		/*else if(e.getSource() == wait.btnCreate) {
			card.show(getContentPane(), "Room");
		}
		else if(e.getSource() == wait.tf) {
			String str = wait.tf.getText();
			wait.ta.append(str+"\n");
			wait.tf.setText("");
		}
		}*/
		
	} // action

	

}
