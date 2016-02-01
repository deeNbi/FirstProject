package com.sist;
import javax.swing.*;
import java.awt.*;

public class Registration extends JDialog{
	Image back;
	JLabel name_la,id_la,pw_la,brith_la;
	JTextField name,id,brith;
	JPasswordField pw;
	JButton confirm,cancel;
	
	public Registration(){
		back=Toolkit.getDefaultToolkit().getImage("C:\\Users\\sist\\Desktop\\image\\mainImage(ver.1).jpg");
		name_la=new JLabel("NICK NAME");
		id_la=new JLabel("ID");
		pw_la=new JLabel("PW");
		brith_la=new JLabel("BIRTH");
		
		name=new JTextField();
		id=new JTextField();
		pw=new JPasswordField("PW");
		brith=new JTextField();
		confirm=new JButton("SIGN UP");
		cancel=new JButton("CANCEL");
		
		setLayout(null);
		
		name_la.setBounds(500,350,300,250);
		name.setBounds(510,350,300,250);
//		id_la.setBounds(45,15,150,30);
//		id.setBounds(45,50,150,30);
//		pw_la.setBounds(10,50,30,30);
//		pw.setBounds(45,50,150,30);
//		brith_la.setBounds();
//		brith.setBounds(, y, width, height);
		
		JPanel p=new JPanel();		//FlowLayout(가운데정렬)
		p.add(confirm);
		p.add(cancel);
		p.setBounds(10,85,185,35);
		p.setOpaque(false);			//패널의 남는 테두리 투명도
		
		//추가
		add(name_la); add(name);
//		add(la2); add(pf);
		add(p);
	}
}
