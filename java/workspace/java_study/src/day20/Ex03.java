package day20;

import java.util.List;

public class Ex03 {
	public static void main(String[] args) {
		
		Box<Apple> appleBox = new FruitBox<Apple>();	// Fruit -> Apple
		appleBox.add(new Apple());
		appleBox.add(new Apple());	
		
		//appleBox.add(new Melon());	// 다른 것은 못 담음
		
		
		List<Apple> apples = appleBox.getContents();
		System.out.println(apples);
		
		Box<Melon> melonBox = new FruitBox<Melon>();
		melonBox.add(new Melon());
		List<Melon> melons = melonBox.getContents();
		System.out.println(melons);
		/*
		melonBox.add(new Melon());
		melonBox.add(new Melon());
		
		List<Melon> melons = melonBox.getContents();
		*/
		
		
	}
}
