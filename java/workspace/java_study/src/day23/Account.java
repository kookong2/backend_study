package day23;

public class Account {
	private static int balance = 1000;

	public int getBalance() {

		return balance;
	}

	/*
	public synchronized void withdraw(int money) {

		if(getBalance() - money >= 0) {
			try {
				Thread.sleep(1000);
				balance -= money;
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
	}
	 */

	public void withdraw(int money) {
		synchronized (this) {
			
			if(getBalance() - money >= 0) {
				try {
					Thread.sleep(1000);
					balance -= money;
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			}
		}
	}
}
