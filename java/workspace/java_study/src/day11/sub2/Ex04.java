package day11.sub2;

public class Ex04 {
	public static void main(String[] args) {
		
		try {
			int result = add(10, 0);
			
			System.out.println(result);
		} catch (ArithmeticException e) {
			e.printStackTrace();
		}
		
		System.out.println("실행!");
	}
	
	public static int add(int num1, int num2) {
		
	
			int result = num1 / num2;
		
			return result;
	
		
	}
}
