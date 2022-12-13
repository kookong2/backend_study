package day23;

public class Account {
	private int money = 10000;
	
	public void withdraw() {
		
		while(money > 0) {
			
			int amount = (int)(Math.random()*3 + 1)*100;	// 100 ~ 300
			
			if(money - amount >= 0) {
				money -= amount;
			}
			
			System.out.println("잔고 = " + money);
		}
	}
}