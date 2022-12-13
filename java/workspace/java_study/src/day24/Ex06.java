package day24;

import java.util.function.*;

public class Ex06 {
	public static void main(String[] args) {
		
		Consumer<String> f1 = System.out::println;
		f1.accept("hello");
		
		BiPredicate<String, String> f2 = String::equals;
		boolean check = f2.test("Hello", "Hello");
		System.out.println(check);
		
		Supplier<Person> f3 = Person::new;
		System.out.println(f3.get());
		
		Function<Integer, int[]> f4 = x -> new int[x];
		Function<Integer, int[]> f5 = int[]::new;
		int[] nums = f5.apply(5);
		System.out.println(nums.length);
	}
}
