package day09.sub1;

public class Human extends Animal{
	@Override
	public void move() {
		// this, super 
		// this.move(); // Human move()
		//super.move(); // Animal move()
		System.out.println("두발로 직립 보행!");
	}
}
