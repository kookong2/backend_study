package day23;

public class Ex04 {
	public static void main(String[] args) {
		
		Thread thread = new Thread(new ThreadEx04());
		
		thread.setDaemon(true);
		
		thread.start();
		
		for(int i = 1; i <= 10; i++) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (Exception e) {}
		}
		
	}
}

class ThreadEx04 implements Runnable{

	@Override
	public void run() {

		while(true) {
			
			try {
				Thread.sleep(3000);
				saved();
			} catch (InterruptedException e) {}			
		}
	}
	
	private void saved() {
		System.out.println("저장되었습니다.");
	}
	
}