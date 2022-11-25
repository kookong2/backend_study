package day09.sub1;

public class Ex04 {

	public static void main(String[] args) {
		
		Animal[] animals = {new Human(), new Tiger(), new Fish()};
		
		for(Animal animal : animals) {
			animal.move();
		}

	}

}
