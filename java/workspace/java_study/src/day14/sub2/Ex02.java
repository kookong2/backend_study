package day14.sub2;

import java.util.Random;

public class Ex02 {
	public static void main(String[] args) {
		
		double num = Math.random() * 10;
		
		System.out.println((int)num);
		
		// java.util.Random()
		Random random = new Random();
		System.out.println(random.nextInt());
	}
	
}
