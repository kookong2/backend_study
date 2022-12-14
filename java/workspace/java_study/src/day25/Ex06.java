package day25;

import java.util.Arrays;
import java.util.stream.Stream;

public class Ex06 {
	public static void main(String[] args) {
		
		Student[] students = {
				new Student("홍길동", 1, 300),	
				new Student("고길동", 2, 150),	
				new Student("이길동", 3, 350),	
				new Student("삼길동", 1, 310),	
				new Student("동길동", 5, 270),	
				new Student("구길동", 4, 190),	
				new Student("김길동", 3, 160),	
				new Student("하길동", 5, 390),	
				new Student("최길동", 4, 110),	
				new Student("박길동", 2, 200)	
			};
		
		
		double avg = Arrays.stream(students).mapToInt(Student::getTotalScore)
											.peek(System.out::println)
											.average().getAsDouble();
		System.out.println("평균은 ? " + avg);
		
		
		
	}
}
