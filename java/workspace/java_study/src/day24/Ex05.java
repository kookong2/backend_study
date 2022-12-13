package day24;

import java.util.function.Function;

public class Ex05 {
	public static void main(String[] args) {
		
		Function<String, String> f1 = Function.identity(); 	// s -> s
		String s = f1.apply("hello");
		System.out.println(s);
	}
	
	
}
