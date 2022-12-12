package day23;

import javax.swing.JOptionPane;

public class Ex01 {
	public static void main(String[] args) {
		
		Thread thread = new Thread(new ThreadEx01(),"쓰레드!");
		thread.start();
		
		
		
		System.out.println("작업 완료");
	}
}

class ThreadEx01 implements Runnable{

	@Override
	public void run() {

		String message = JOptionPane.showInputDialog("아무 메세지 입력!");
		System.out.println(message);
		
	}
	
}