package day20.sub1;

import java.util.List;

public class Jucier<T> {
	
	private T data;
	
	public static void make(Box<? extends Fruit>box,Box<? extends Fruit> box2) {	// 컴파일 되면 FruitBox<Fruit>

		System.out.println(box.get().toString() + "주스!");
		System.out.println(box2.get().toString() + "주스!");

	}
	
	public static <T extends Fruit,E extends Fruit> void make2(Box<T> box, Box<E> box2) {
		System.out.println(box.get().toString() + "주스!");
		System.out.println(box2.get().toString() + "주스!");
	}
}
