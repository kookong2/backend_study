package day24;

import java.util.function.Predicate;

public class Ex03 {
	public static void main(String[] args) {
		
		// x >= 100 && x <= 200
		Predicate<Integer> over100 = x -> x >=100;
		Predicate<Integer> below200 = x -> x <= 200;
		Predicate<Integer> check = over100.and(below200);
		boolean result2 = checkNumber(check, 105);
		boolean result3 = checkNumber(check, 98);
		boolean result4 = checkNumber(check, 203);
		System.out.println(result2);
		System.out.println(result3);
		System.out.println(result4);
		
		System.out.println();
		
		// x >= 100
		boolean result = checkNumber(x -> x >= 100, 105);
		System.out.println(result);
	}
	
	public static boolean checkNumber(Predicate<Integer> predicate, Integer num) {
		
		return predicate.test(num);
	}
}
