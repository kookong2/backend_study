package day10;

import javax.sql.rowset.JoinRowSet;

public class Ex01 {
	public static void main(String[] args) {
		SimpleCalculator cal = new SimpleCalculator();
		
		cal.num = 20;
		System.out.println(cal.num);
		
		int result = cal.add(10, 20);
		System.out.println(result);
		
		int result2 = cal.minus(30,10);
		System.out.println(result2);
		
		cal.print();
	}
}
