package day10;

public abstract class Calculator {
	
	int num = 10;
	
	// 하위 클래스가 반드시 구현 할 메서드
	public abstract int add(int num1, int num2);
	public abstract int minus(int num1, int num2);
	
	public void print() {
		System.out.println("출력!");
	}
}
