package day09.sub1;

public class Ex02 {

	public static void main(String[] args) {
		Animal[] animals = {new Human(), new Human(),new Tiger(), new Tiger()};
		
		//Animal[0]... = new Human()
		//Animal[2]... = new Tiger();
		//Tiger[] tigers = {new Tiger(), new Tiger()};
		
		for(Animal animal : animals) {
			System.out.println(System.identityHashCode(animal));
			animal.move();
		}
		
		/**
		for(Human human : humans) {
			human.move();
		}
		for(Tiger tiger : tigers) {
			tiger.move();
		}
		
		Animal a = new Human();
		Animal b = new Tiger();
		
		/**
		Human human = new Human();
		human.move();
		
		Tiger tiger = new Tiger();
		tiger.move();
		**/
		

	}

}
