package day20.sub1;

public class Ex01 {
	
	public static void main(String[] args) {
		
		Apple apple = new Apple();
		Box<Apple> box1 = new Box<Apple>();
		box1.add(apple);
		
		Melon melon = new Melon();
		Box<Melon> box2 = new Box<Melon>();
		box2.add(melon);
		
		Jucier<Apple> juicer = new Jucier();
		
		juicer.make(box2, box1);
		
		juicer.make2(box2, box1);
		
		//FruitBox<Melon> melonBox = new FruitBox<Melon>();
		//melonBox.add(new Melon());
		//melonBox.add(new Melon());
		
	}
	
}
