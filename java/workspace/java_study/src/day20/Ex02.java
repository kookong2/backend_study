package day20;

import java.util.ArrayList;

public class Ex02 {
	public static void main(String[] args) {
		
		ArrayList<String> fruits = new ArrayList<String>();
		fruits.add("사과");
		fruits.add("오렌지");
		fruits.add("포도");
		fruits.add("멜론");
		
		for(String fruit : fruits) {
			System.out.println(fruit);
		}
	}
}
