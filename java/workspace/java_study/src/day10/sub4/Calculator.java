package day10.sub4;

public interface Calculator {
	int add(int num1, int num2); //public abstract
	
	default int minus(int num1, int num2) {
		print2();
		int result = num1 - num2;
		return result;
	}
	
	public static void print() {
		System.out.println("출력!");
	}
	
	private void print2() {
		System.out.println("출력!");
	}
}
