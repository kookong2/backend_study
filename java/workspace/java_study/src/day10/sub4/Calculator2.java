package day10.sub4;

public interface Calculator2 {
	int add(int num1, int num2);
	
	default int minus(int num1, int num2) {
		int result = num1 - num2;
		return result;
	}
}
