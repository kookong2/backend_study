package day16;

import java.time.LocalDateTime;

// 이렇게 하면 ChronoField.TEAR 이런 식으로 안해도 됨
import static java.time.temporal.ChronoField.*;
import static java.time.temporal.ChronoUnit.*;

import java.time.DayOfWeek;

public class Ex04 {
	public static void main(String[] args) {
		
		LocalDateTime ldt = LocalDateTime.now();
		//int year = ldt.get(YEAR);
		int year = ldt.getYear();
		
		//int month = ldt.get(MONTH_OF_YEAR);
		int month = ldt.getMonthValue();
		
		//int day = ldt.get(DAY_OF_MONTH);
		int day = ldt.getDayOfMonth();
		
		//int hour = ldt.get(HOUR_OF_DAY);
		int hour = ldt.getHour();
		
		//int min = ldt.get(MINUTE_OF_HOUR);
		int min = ldt.getMinute();
		
		//int sec = ldt.get(SECOND_OF_MINUTE);
		int sec = ldt.getSecond();
		
		System.out.println(year + "-" + month + "-" + day + " " + hour + ":" + min + ":" + sec);
		
		DayOfWeek dow = ldt.getDayOfWeek();
		int yoil = dow.getValue();
		System.out.println("요일 : " + yoil);
		
	}
}
