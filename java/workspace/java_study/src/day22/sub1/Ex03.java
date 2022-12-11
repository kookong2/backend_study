package day22.sub1;

public class Ex03 {
	public static void main(String[] args) {
		
		Thread th1 = new Thread(new ThreadEx3_1());
		Thread th2 = new Thread(new ThreadEx3_2());
		
		System.out.println("th1그룹?" + th1.getThreadGroup());
		System.out.println("th2그룹?" + th1.getThreadGroup());
		
		th1.setPriority(10);
		th2.setPriority(1);
		
		th1.start();
		th2.start();
	}
}

class ThreadEx3_1 implements Runnable{
	public void run() {
		for(int i = 0; i < 300; i++) {
			System.out.print(new String("-"));
			
			for(long j = 0; j < 200000000000000L; j++);
		}
	}
}

class ThreadEx3_2 implements Runnable{
	public void run() {
		for(int i = 0; i < 300; i++) {
			System.out.print(new String("|"));
			
			for(long j = 0; j < 200000000000000L; j++);
		}
	}
}
