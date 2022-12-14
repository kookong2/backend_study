package day16;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Ex03 {
	public static void main(String[] args) {
		
		ZonedDateTime korTime = ZonedDateTime.now();
		System.out.println("한국 시간 : " + korTime);
		
		ZoneId newYorkId = ZoneId.of("America/New_York");
		ZonedDateTime nyTime = korTime.withZoneSameInstant(newYorkId);
		System.out.println("뉴욕 시간 : " + nyTime);
	}
}
