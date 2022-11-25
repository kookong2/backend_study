package day10.sub4;

public class SimpleCalculator implements Calculator, Calculator2 {
	public int add(int num1, int num2) {
		int result = num1 + num2;
		
		return result;
	}

//	@Override
//	public int minus(int num1, int num2) {
//		return Calculator.super.minus(num1, num2);
//	}
	
	@Override
	public int minus(int num1, int num2) {
		int result = num1 - num2;
		return result;
	}
}
