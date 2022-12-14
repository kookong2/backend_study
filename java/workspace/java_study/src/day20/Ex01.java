package day20;

import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Ex01 extends JFrame{
	
	private JButton btn1;
	
	public Ex01() {
		super("연습01");
		setVisible(true);
		setSize(500,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setLayout(new FlowLayout());
		
		btn1 = new JButton("버튼!");
		add(btn1);
		
		btn1.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				int xpos = e.getX();
				int ypos = e.getY();
				
				System.out.println("xpos = " + xpos + ", ypos = " + ypos);
			}
			
			
			
		});
	}
	
	public static void main(String[] args) {
		new Ex01();
		
	}
	
}
