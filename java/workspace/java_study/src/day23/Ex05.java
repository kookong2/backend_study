package day23;

public class Ex05 {
	public static void main(String[] args) throws InterruptedException {
		
		long startTime = System.nanoTime();	//EpochTime
		
		Thread thread1 = new Thread(new ThreadEx05_1());
		Thread thread2 = new Thread(new ThreadEx05_2());
		
		thread1.start();
		thread2.start();
		thread1.join();
		thread2.join();
		
		long endTime = System.nanoTime();
		
		System.out.println();
		System.out.println("걸린 시간 = " + (endTime - startTime));
		
		
	}
}

class ThreadEx05_1 implements Runnable{

	@Override
	public void run() {

		for(int i = 0; i < 300; i++) {
			System.out.print(new String("-"));
		}
	}
	
	
}

class ThreadEx05_2 implements Runnable{

	@Override
	public void run() {

		for(int i = 0; i < 300; i++) {
			System.out.print(new String("|"));
		}
		
	}
	
	
}