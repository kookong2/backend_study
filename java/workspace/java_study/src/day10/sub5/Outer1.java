package day10.sub5;

public class Outer1 {
	
	int Outernum = 20;  // 인스턴스 생성 후 사용 가능

	// 인스턴스 내부 클래스 -> 인스턴스 변수,메서드
	class Inner{
		int Innernum = 10;
		void print() {
			staticPrint();
			System.out.println("내부 클래스!");
			System.out.println("numOuter =" + Outernum);
		}
		
		static void staticInnerPrint() { // jdk15 -> 오류, jdk16 -> 사용가능
			
		}
	}
	
	static void staticPrint() {
		System.out.println("출력!");
	}
}
