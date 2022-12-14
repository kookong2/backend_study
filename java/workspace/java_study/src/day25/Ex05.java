package day25;

import java.util.Random;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;

public class Ex05 {
	public static void main(String[] args) {
		
		Random random = new Random();
		IntStream stream = random.ints();	// 정수 범위의 난수를 무한대로
		
		stream.limit(10).forEach(System.out::println);
	}
}
