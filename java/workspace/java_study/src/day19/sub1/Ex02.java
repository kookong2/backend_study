package day19.sub1;

import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class Ex02 extends JFrame implements KeyListener {
	
	private JTextField tf;
	
	public Ex02() {
		super("연습02");
		setVisible(true);
		setSize(300,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setLayout(new FlowLayout());
		
		tf = new JTextField(30);
		add(tf);
		
		tf.addKeyListener(this);
		
		
	}
	
	public static void main(String[] args) {
		new Ex02();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		System.out.println("KeyTyped");
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("KeyPressed");
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println("KeyReleased");
		
	}
}
