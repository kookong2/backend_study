package day23;

public class Ex02 {

	public static void main(String[] args) {
		
		Thread thread = Thread.currentThread();	// main thread
		
		ThreadGroup mainGroup = thread.getThreadGroup();
		
		ThreadGroup grp2 = new ThreadGroup("group2");
		Thread thread2 = new Thread(grp2, "쓰레드!");
		thread2.start();
		
		mainGroup.list();
		System.out.println(mainGroup.activeCount());
		
	}
}
