package day23;

import java.util.Random;

public class Ex07 {
	public static void main(String[] args) {
		
		ThreadEx07 th = new ThreadEx07();
		Thread thread1 = new Thread(th, "with-1");
		Thread thread2 = new Thread(th, "with-2");
		
		thread1.start();
		thread2.start();
	}
}

class ThreadEx07 implements Runnable{
	
	private static Account account = new Account();

	@Override
	public void run() {

		while(account.getBalance() > 0) {
			
			int money = (int)(Math.random() * 3 + 1)*100;
			
			account.withdraw(money);
			System.out.println(Thread.currentThread().getName() + ":" + account.getBalance());
		}
	}
	
}
