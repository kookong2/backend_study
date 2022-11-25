package day10.sub5;

public class Ex01 {
	public static void main(String[] args) {
		Outer1 out = new Outer1();
		Outer1.Inner in = out.new Inner();
		in.print();
	}
}
