package day23;

public class Ex08 {
	public static void main(String[] args) {
		
		
	}
}

class ThreadEx08 implements Runnable{

	@Override
	public void run() {

		Thread thread = Thread.currentThread();
		
		while(!thread.isInterrupted()) {
			for(int i =0; i < 100; i++) {
				try {
					System.out.println(i);
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					Thread.interrupted();
				}
			}
		}
		
	}
	
	
}
