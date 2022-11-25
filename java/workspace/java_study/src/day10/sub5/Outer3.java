package day10.sub5;

public class Outer3 {
	void method() {
		Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
				System.out.println("구현!");
				
			}
		};
		
		runnable.run();
	}
}
