package day22.sub1;

public class Ex02 {
	public static void main(String[] args) {
		
		ThreadEx2_1 th3 = new ThreadEx2_1();
		//th3.start();
		th3.run();
	}
	
	static class ThreadEx2_1 extends Thread{
		public void run() {
			try {
				throwException();				
			}catch (RuntimeException e) {
				e.printStackTrace();
			}
		}
		
		private void throwException() {
			throw new RuntimeException();
		}
	}
}
