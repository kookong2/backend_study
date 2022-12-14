package day16;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Ex01 {
	public static void main(String[] args) {
		
		LocalDate ld = LocalDate.now();
		LocalTime lt = LocalTime.now();
		//System.out.println(ld);
		//System.out.println(lt);
		
		LocalDateTime ldt = LocalDateTime.of(2022, 11,10,12,30,20);
		System.out.println(ldt);
		LocalDateTime ldt2 = LocalDateTime.of(ld,lt);
		System.out.println(ldt2);
	}
}
