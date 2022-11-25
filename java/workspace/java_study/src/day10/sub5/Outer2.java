package day10.sub5;

public class Outer2 {
	
	int numOuter = 20;
	
	static class Inner{
		int numInner = 10;
		
		void print() {
			
			System.out.println("내부 클래스!");
		}
	}
}
