package com.sist;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

public class WaitRoom extends JPanel{
	Image back;
	JTable table1,table2;
	DefaultTableModel model1,model2;
	
	JTextArea ta;	// 3�� ä�ý� ���
	JTextField tf;
	JComboBox box;
	JPanel movie;
	JButton b1,b2,b3,b4,b5,b6;
	
	public WaitRoom(){
		back=Toolkit.getDefaultToolkit().getImage("C:\\image\\back.jpg");
		String[] col1={"���̸�","����/�����","�ο�"};
		String[][] row1=new String[0][3];
		model1=new DefaultTableModel(row1, col1);
		table1=new JTable(model1);
		JScrollPane js1=new JScrollPane(table1);
		
		String[] col2={"ID","��ȭ��","����", "��ġ"};
		String[][] row2=new String[0][4];
		model2=new DefaultTableModel(row2, col2);
		table2=new JTable(model2);
		JScrollPane js2=new JScrollPane(table2);
		
		//ä��
		ta=new JTextArea();
		JScrollPane js3=new JScrollPane(ta);//�����Է��� �þ ��, ��ũ�ѹٰ� ����
		tf=new JTextField();				//���� �Է�
		box=new JComboBox();				//��Ʈ ���� ������ �ڽ�
		box.addItem("black");				//������ ����
		box.addItem("blue");
		box.addItem("pink");
		box.addItem("green");
		box.addItem("cyan");
		
		movie = new JPanel();				// ���� ����
		movie.setBackground(Color.black);	// ������ ȭ��
		
		b1=new JButton("�游���");
		b2=new JButton("�����");
		b3=new JButton("���ӽ�û");
		b4=new JButton("����������");
		b5=new JButton("��������");
		b6=new JButton("������");
		
		JPanel p=new JPanel();
		p.setLayout(new GridLayout(3,1, 5,5));
		p.add(b1);		p.add(b2);
		p.add(b3);		p.add(b4);
		p.add(b5);		p.add(b6);
		p.setOpaque(false);
		
		setLayout(null);
		js1.setBounds(10,15,500,320);
		js2.setBounds(10,340,500,220);
		js3.setBounds(515, 15, 265, 200);
		tf.setBounds(515,220,170,30);
		box.setBounds(695,220,85,30);
		movie.setBounds(515,255,265,180);
		p.setBounds(515, 440, 265, 120);
		
		add(js1);
		add(js2);
		add(js3);
		add(tf);
		add(box);
		add(movie);
		add(p);
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(back, 0, 0, getWidth(),getHeight(),this);
	}
}