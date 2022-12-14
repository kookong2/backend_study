package day22.sub1;

public class Ex01 {
	public static void main(String[] args) {	// 호출스택 + main() -> 메인 쓰레드
		ThreadEx1_1 th1 = new ThreadEx1_1();
		Thread th2 = new Thread(new ThreadEx1_1());
		th1.start();	// 호출스택 + run()
		th2.run();		// 호출스택 + run()
		System.out.println("작업 끝!");
	}
	
	static class ThreadEx1_1 extends Thread{
		
		public void run() {
			for(int i = 1; i <= 10; i++) {
				System.out.println(i + "-" + getName());
			}
		}
	}
	
	class ThreadEx1_2 implements Runnable{
		public void run() {
			for(int i = 1; i < 10; i++) {
				Thread th = Thread.currentThread();
				System.out.println(i + "-" + th.getName());
			}
		}
	}
}
