package day17;

import java.util.ArrayList;

public class Ex07 {
	public static void main(String[] args) {
		
		ArrayList<String> fruits = new ArrayList<>();
		
		fruits.add("사과");
		fruits.add("귤");
		fruits.add("바나나");
		fruits.add("배");
		fruits.add("사과");
		
		System.out.println(fruits);
		
		System.out.println("사과는 어디에? " + fruits.indexOf("사과"));
		System.out.println("배는 어디에? " + fruits.indexOf("배2"));
		System.out.println("사과(역순) 어디에?" + fruits.lastIndexOf("사과"));
		
		String fruits2 = "사과,귤,배,바나나,사과";
		System.out.println("사과는 어디에? " + fruits2.indexOf("사과"));
		System.out.println("배는 어디에? " + fruits2.indexOf("배"));
		System.out.println("사과(역순) 어디에?" + fruits2.lastIndexOf("사과"));
	}
}
