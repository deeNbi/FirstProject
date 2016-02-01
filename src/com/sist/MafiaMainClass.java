package com.sist;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MafiaMainClass extends JFrame implements MouseListener{
		
		CardLayout card=new CardLayout();
		Login login = new Login();
		WaitRoom wr=new WaitRoom();
		Registration re=new Registration();
		JPanel movie=new JPanel();

		public MafiaMainClass(){
			setLayout(card);		//BorderLayout
			
			//add("WR",wr);
			add("LOG",login);		//windowâ ���� penal�� �ø���
			setTitle("MAFIA GAME - LOGIN");
			setSize(1280,985);		//window ũ��	
			
/*			// â�� �߾ӿ� ����.
			Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
			Dimension ex_size = this.getSize();
			
			int xpos=(int)(screen.getWidth()/2 - this.getWidth()/2);
			int ypos=(int)(screen.getHeight()/2 - this.getHeight()/2);

			this.setLocation(xpos,ypos);
*/			
			//��üȭ��
			GraphicsEnvironment ge=GraphicsEnvironment.getLocalGraphicsEnvironment();
			GraphicsDevice gd = ge.getDefaultScreenDevice();
			setUndecorated(true);
			gd.setFullScreenWindow(this);
			
			setVisible(true);		//window ���̱�
			setResizable(false);	//ȭ��ũ�� ����
			
			addMouseListener(this);	//mouse������
		}
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			//������
			try{
				//ui ����
				//jtattoo.jar => login image click (address copy paste)
				UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");		
			}catch(Exception ex){}
			MafiaMainClass cm=new MafiaMainClass();
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==login.b1){	// double click event
				card.show(getContentPane(), "WR");
			}
			else if(e.getSource()==login.b2){
				card.show(getContentPane(), "");
			}
		}
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

	}
