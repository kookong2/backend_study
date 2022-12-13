package day24;

import java.util.function.*;


public class Ex02 {
	public static void main(String[] args) {
		
		// Consumer
		printString(s -> System.out.println(s), "hello");
		
		// Supplier
		int num = getNumber(() -> (int)(Math.random()*10));
		System.out.println(num);
		
		// BiFunction
		int num2 = add((x,y) ->  x + y, 20, 30);
		System.out.println(num2);
		
	}
	
	public static void printString(Consumer<String> consumer, String s) {
		
		consumer.accept(s);
	}
	
	public static Integer getNumber(Supplier<Integer> supplier) {
		
		return supplier.get();
	}
	
	public static Integer add(BiFunction<Integer, Integer,Integer> function, Integer num1, Integer num2) {
		
		return function.apply(num1, num2);
	}
	
	// 매개 변수, 반환값이 같은 자료형일 경우	//박싱, 언박싱도 필요 없이 (IntBinaryOperator 사용)	//(많이 쓰임)
	public static int add2(IntBinaryOperator function, int num1, int num2 ) {
		
		return function.applyAsInt(num1, num2);
	}
}
