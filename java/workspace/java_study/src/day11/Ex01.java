package day11;

public class Ex01 {
	public static void main(String[] args) {
		
		Outer1 outer1 = new Outer1();
		
		Outer1.Inner inner = outer1.new Inner();
		
		inner.print();
	}
}
