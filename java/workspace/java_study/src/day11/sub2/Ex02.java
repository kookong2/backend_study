package day11.sub2;

public class Ex02 {
	public static void main(String[] args) {
		
		int num1 = 10;
		int num2 = 0;
		
		try {
			int result = num1 / num2;
			
		} catch (ArithmeticException e) {

			System.out.println(e.getMessage());
		}finally {
			System.out.println("무조건 실행!");
		}
	}
}
