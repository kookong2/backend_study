package day23;

public class Ex06 {
	public static void main(String[] args) throws InterruptedException{
		
		ThreadEx06 th1 = new ThreadEx06("*");
		ThreadEx06 th2 = new ThreadEx06("**");
		ThreadEx06 th3 = new ThreadEx06("***");
		
		th1.start();
		th2.start();
		th3.start();
		
		Thread.sleep(2000);
		
		th2.suspend();
		
		Thread.sleep(2000);
		
		th2.resume();
		th3.suspend();
		
		Thread.sleep(3000);
		th3.resume();
		
		Thread.sleep(2000);
		th2.stop();
		th3.stop();
		
		Thread.sleep(2000);
		th1.stop();
	}
}

class ThreadEx06 implements Runnable{
	
	private volatile boolean stopped = false;	// 정지 상태 여부
	private volatile boolean suspended = false;	// 일시 정지 상태 여부
	
	private Thread thread;
	
	public ThreadEx06(String name) {
		
		thread = new Thread(this, name);
	}

	@Override
	public void run() {

		while(!stopped) { //정지 상태가 아니면 반복
			
			if(!suspended) {	// 일시 정지가 아닌 상태
				String name = thread.getName();
				System.out.println(name);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {}
			}
		}
		
	}
	
	public void start() {	// 시작
		thread.start();
	}
	
	public void suspend() {	// 일시 정지
		
		suspended = true;
		System.out.println(thread.getName() + " - 일시정지");
	}
	
	public void stop() {	// 정지
		
		stopped = true;
		System.out.println(thread.getName() + " - 정지");
	}
	
	public void resume() {	// 재시작
		
		suspended = false;
		System.out.println(thread.getName() + " - 재시작");
	}
	
	
}