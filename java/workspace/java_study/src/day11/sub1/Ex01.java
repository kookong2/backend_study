package day11.sub1;

public class Ex01 {
	public static void main(String[] args) {
		
		Outer outer = new Outer();
		OrderProduct orderProduct = outer.method(10,20);	// 함수 실행 종료, int num1,int num2 -> 제거
		
		orderProduct.order();
	}
}
