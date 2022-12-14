package day15.sub2;

import java.time.*;

public class Ex02 {
	public static void main(String[] args) {
		
		LocalDate date = LocalDate.now();
		LocalTime time = LocalTime.now();
		
		LocalDateTime lt1 = date.atTime(time);
		
		LocalDateTime lt2 = time.atDate(date);
		
		LocalDateTime lt3 = LocalDateTime.of(date, time);
		
		ZonedDateTime zdt1 = lt3.atZone(ZoneId.of("Asia/Seoul"));
		OffsetDateTime odt = lt3.atOffset(ZoneOffset.of("+9"));
	}
}
