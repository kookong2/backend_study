package day18.sub1;

import java.awt.Button;
import java.awt.FlowLayout;

import javax.swing.JFrame;

public class Ex01 extends JFrame {
	
	public Ex01() {
		super("연습01");
		// 창을 보이게 해야 함
		setVisible(true);
		// 창의 크기
		setSize(300,400);
		// 창을 닫았을 때 콘솔 실행도 같이 끔
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// 배치 관리자를 지정
		setLayout(new FlowLayout());
		// 추가
		for(int i = 0; i < 5; i++) {
			add(new Button("버튼" + i));
		}
	}

	public static void main(String[] args) {
		
		Ex01 ex01 = new Ex01();
		
		

		
		
	}
}
