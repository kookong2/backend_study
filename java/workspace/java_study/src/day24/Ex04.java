package day24;

import java.util.function.*;

public class Ex04 {
	public static void main(String[] args) {
		
		Function<String, Integer> f1 = s -> Integer.parseInt(s,16);
		Function<Integer, String> f2 = i -> Integer.toBinaryString(i);		
		Function<String, String> f3 = f1.andThen(f2);
		
		// f1
		int num = f1.apply("FF");
		System.out.println(num);
		
		// f2
		String bNum = f2.apply(num);
		System.out.println(bNum);
		
		// f1, f2 결합
		String bNum2 = f3.apply("F2");
		System.out.println(bNum2);
	}
}
