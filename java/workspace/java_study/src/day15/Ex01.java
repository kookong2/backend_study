package day15;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Ex01 {
	public static void main(String[] args) throws ParseException {
		
		Date date = new Date();
		System.out.println(date);
		
		String pattern = "yy년-MM월-dd일 HH시 mm분 ss초";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		String dateStr = sdf.format(date);
		System.out.println(dateStr);
		
		//parse
		String pattern2 = "yyyy-MM-dd HH:mm:ss";
		String dateStr2 = "2022-10-15 12:00:30";
		SimpleDateFormat sdf2 = new SimpleDateFormat(pattern2);
		Date date2 = sdf2.parse(dateStr2);
		System.out.println(date2);
		
	}
}
