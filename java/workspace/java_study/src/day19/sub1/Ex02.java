package day19.sub1;

import java.awt.FlowLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class Ex02 extends JFrame{
	
	private JTextField tf;
	
	public Ex02() {
		super("연습02");
		setVisible(true);
		setSize(300,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setLayout(new FlowLayout());
		
		tf = new JTextField(30);
		add(tf);
		
		tf.addKeyListener(new KeyEventHanle());
		
		
	}
	
	public static void main(String[] args) {
		new Ex02();
	}

	
	class KeyEventHanle extends KeyAdapter{
		@Override
		public void keyPressed(KeyEvent e) {
			int code = e.getKeyCode();
			String key = KeyEvent.getKeyText(code);
			System.out.println("code = " + code + ", key = " + key);
			
		}
	}
}
