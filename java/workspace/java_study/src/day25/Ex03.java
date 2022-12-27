package day25;

import java.util.*;
import java.util.stream.*;

public class Ex03 {
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
		
		Arrays.stream(students).filter(s -> s.getTotalScore() >= 250)	// - 중간 연산 - 지연된 연산
								.map(Student::getName)					// - 중간 연산 - 지연된 연산
								.forEach(System.out::println);			//- 최종 연산, 스트림 소비 완료
	}
}