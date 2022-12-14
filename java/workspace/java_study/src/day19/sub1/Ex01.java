package day19.sub1;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Ex01 extends JFrame implements ActionListener{
	
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JTextField tf1;
	
	public Ex01() {
		super("예제01");
		setVisible(true);
		setSize(300,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setLayout(new FlowLayout());
		
		btn1 = new JButton("버튼1");
		btn2 = new JButton("버튼2");
		btn3 = new JButton("버튼3");
		
		tf1 = new JTextField(30);
		
		add(btn1);
		add(btn2);
		add(btn3);
		add(tf1);
		
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		
	}
	
	public static void main(String[] args) {
		new Ex01();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		JButton btn = (JButton)e.getSource();
		String btnNm = btn.getText();
		System.out.println(btnNm);
		
		if(btn == btn1) {		// 버튼 1 클릭
			JOptionPane.showMessageDialog(this, "메세지!");
		}else if(btn == btn2){	// 버튼 2 클릭
			String text = tf1.getText();
			String inputText = JOptionPane.showInputDialog(this, "아무 메세지 입력 하세요", text);
			System.out.println(inputText);
		}else if(btn == btn3){	// 버튼 3 클릭
			int selected = JOptionPane.showConfirmDialog(this, "정말 진행 할까요?");
			System.out.println(selected);
		}
		
	}
}
