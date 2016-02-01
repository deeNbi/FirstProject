package com.sist;
import javax.swing.*;
import java.awt.*;
public class Login extends JPanel{
	//스킨입히기 
	//Source -> overriding/... -> JCcomponent -> paintComponent
	Image back;
	JLabel la1,la2;
	JTextField tf;
	JPasswordField pf;
	JButton b1,b2;
	//저장 (초기화)
	/*
	 * JPenel => 로딩
	 * 			1) 생성자 호출
	 * 			2) update() => clearRect() 		//전체를 한번 지운다.
	 * 				paint() => paintComponent()
	 * 			==> 화면 변경
	 */
	public Login(){
		back=Toolkit.getDefaultToolkit().getImage("C:\\Users\\sist\\Desktop\\image\\mainImage(ver.2).jpg");
		
		la1=new JLabel("ID");
		la1.setForeground(Color.WHITE);
		
		la2=new JLabel("PW");
		la2.setForeground(Color.WHITE);
		
		tf=new JTextField();
		pf=new JPasswordField();
		b1=new JButton("로그인");
		b2=new JButton("취소");
		
		//배치
				
		setLayout(null);
		JPanel j=new JPanel();
		j.setBounds(500,700, 300, 250);
		j.setLayout(null);
		la1.setBounds(70,15,30,30);
		tf.setBounds(100,15,150,30);
		la2.setBounds(70,50,30,30);
		pf.setBounds(100,50,150,30);
		b1.setBounds(65,100,85,30);
		b2.setBounds(165,100,85,30);
		
		j.setOpaque(false);			//패널의 남는 테두리 투명도
	
		//추가
		j.add(la1); j.add(tf);
		j.add(la2); j.add(pf);
		j.add(b1);	j.add(b2);
		
		add(j);
	}
	
	//paint를 쓰게되면 위에 올라가지 않음 => paintComponent (스킨)사용
	//paintComponent 자동호출 => 호출x.
	//로딩했을 때, 크기를 조정할 때... 자동호출시킨다.
	@Override
//	public void paint(Graphics g) {	//접근지정자 확대 가능, paint를 쓰면 back에 가려 위에 떠야하는 요소가 안보인다.
	protected void paintComponent(Graphics g) {
		g.drawImage(back, 0, 0, getWidth(),getHeight(),this);
	}
	
	
}
