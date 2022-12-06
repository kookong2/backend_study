package day19;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Ex02 extends JFrame{
	
	public Ex02() {
		super("연습02");
		setVisible(true);	// 창 보이기
		setSize(300,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// FlowLayout -> 흐르듯이 배치
		// setLayout
		
//		FlowLayout layout = new FlowLayout(FlowLayout.RIGHT);
//		setLayout(layout);
		
		// and(Component c)
//		for(int i = 0; i < 6; i++) {
//			add(new JButton("버튼" + i));
//		}
		
		
		//BorderLayout - 동서남북, 가운데
		/*
		BorderLayout layout = new BorderLayout();
		setLayout(layout);
		
		add("North", new JButton("북"));
		add("South", new JButton("남"));
		add("West", new JButton("서"));
		add("East", new JButton("동"));
		add("Center", new JButton("가운데"));
		*/
		
		// GridLayout, 행,열
		GridLayout layout = new GridLayout(3,3);
		setLayout(layout);
		
		for(int i = 1; i <= 9; i++) {
			add(new JButton(String.valueOf(i)));
		}
		
		
	}
	
	public static void main(String[] args) {
		new Ex02();
		
	}
}
