package day11.sub1;

public class Ex02 {
	public static void main(String[] args) {
		
		Animal animal = new Animal() {
			
			@Override
			public void move() {

				System.out.println("움직인당");
			}
		};
		
		animal.move();
		
		
		A a = new A() {
			public void method() {
				System.out.println("수정한당!");
			}
		};
		
		a.method();
	}
}
