package day10.sub1;

public interface Calculator {
	int num = 10; // public static final
	
	int add(int num1,int num2); // 컴파일러가 자동으로 public abstract
	
	default int minus(int num1, int num2) {
		int result = num1 - num2;
		
		return result;
	}
	
	public static int times(int num1, int num2) {
		int result = num1 * num2;
		return result;
	}
	
//	public void print() {
//		System.out.println("출력!");
//	}
}
