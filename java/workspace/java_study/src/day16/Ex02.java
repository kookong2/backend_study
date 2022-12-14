package day16;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

public class Ex02 {
	public static void main(String[] args) {
		
		LocalDateTime ldt = LocalDateTime.now();
		ZoneId zoneId = ZoneId.of("Asia/Seoul");
		ZonedDateTime zdt = ldt.atZone(zoneId);
		System.out.println(zdt);
		
		ZoneOffset offset = ZoneOffset.of("+9");
		OffsetDateTime odt = ldt.atOffset(offset);
		System.out.println(odt);
	}
}
