package day20;

import java.util.List;

public class jucier {
	public static void make(Box<? super Fruit>fruitBox) {	// 컴파일 되면 FruitBox<Fruit>
		
		List<?> fruits = fruitBox.getContents();
		System.out.println(fruits.get(0).toString()+ " " + fruits.size() + "개로 주스 만듦!");
		
		
	}
}
