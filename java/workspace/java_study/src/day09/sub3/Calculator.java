package day09.sub3;

public abstract class Calculator {
	
	public int num = 10;
	
	// 가이드 라인, 따라야 할 표준
	public abstract int add(int num1, int num2);
	public abstract int minus(int num1, int num2);
	
	public void print() {
		System.out.println("출력!");
	}
}
