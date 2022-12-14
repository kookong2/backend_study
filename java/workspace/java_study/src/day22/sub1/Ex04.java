package day22.sub1;

public class Ex04 {
	public static void main(String[] args) {
		
		//ThreadGroup main = Thread.currentThread();
		ThreadGroup grp1 = new ThreadGroup("group1");
		ThreadGroup grp2 = new ThreadGroup("group2");
		ThreadGroup subGrp3 = new ThreadGroup(grp2,"subgroup3");
		
		Thread th1 = new Thread(grp1, "th1");
		Thread th2 = new Thread(grp2, "th2");
		Thread th3 = new Thread(subGrp3,"th3");
		
		th1.start();
		th2.start();
		th3.start();
		
		subGrp3.list();
		System.out.println(subGrp3.activeCount()); // 현재 활성화 된 쓰레드 수
		
	}
}
