package day11;

public class Ex04 {
	public static void main(String[] args) {
		
		Animal animal = new Animal() {
			
			@Override
			public void move() {

				System.out.println("움직임!");
			}
		};
		
		animal.move();
		
		A a = new A() {
			public void method() {
				System.out.println("메서드(변경)");
			}
		};
		
		a.method();
		
	}
}
