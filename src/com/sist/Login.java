package com.sist;
import javax.swing.*;
import java.awt.*;
public class Login extends JPanel{
	//��Ų������ 
	//Source -> overriding/... -> JCcomponent -> paintComponent
	Image back;
	JLabel la1,la2;
	JTextField tf;
	JPasswordField pf;
	JButton b1,b2;
	//���� (�ʱ�ȭ)
	/*
	 * JPenel => �ε�
	 * 			1) ������ ȣ��
	 * 			2) update() => clearRect() 		//��ü�� �ѹ� �����.
	 * 				paint() => paintComponent()
	 * 			==> ȭ�� ����
	 */
	public Login(){
		back=Toolkit.getDefaultToolkit().getImage("C:\\Users\\sist\\Desktop\\image\\mainImage(ver.2).jpg");
		
		la1=new JLabel("ID");
		la1.setForeground(Color.WHITE);
		
		la2=new JLabel("PW");
		la2.setForeground(Color.WHITE);
		
		tf=new JTextField();
		pf=new JPasswordField();
		b1=new JButton("�α���");
		b2=new JButton("���");
		
		//��ġ
				
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
		
		j.setOpaque(false);			//�г��� ���� �׵θ� ����
	
		//�߰�
		j.add(la1); j.add(tf);
		j.add(la2); j.add(pf);
		j.add(b1);	j.add(b2);
		
		add(j);
	}
	
	//paint�� ���ԵǸ� ���� �ö��� ���� => paintComponent (��Ų)���
	//paintComponent �ڵ�ȣ�� => ȣ��x.
	//�ε����� ��, ũ�⸦ ������ ��... �ڵ�ȣ���Ų��.
	@Override
//	public void paint(Graphics g) {	//���������� Ȯ�� ����, paint�� ���� back�� ���� ���� �����ϴ� ��Ұ� �Ⱥ��δ�.
	protected void paintComponent(Graphics g) {
		g.drawImage(back, 0, 0, getWidth(),getHeight(),this);
	}
	
	
}
