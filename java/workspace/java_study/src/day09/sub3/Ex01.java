package day09.sub3;

public class Ex01 {

	public static void main(String[] args) {
		SimpleCalculator cal = new SimpleCalculator();
		
		SimpleCalculator cal2 = (SimpleCalculator)cal;

		int result = cal.add(10, 20);
		System.out.println(result);
		int result2 = cal.minus(30, 20);
		System.out.println(result2);
		cal.num = 20;
		System.out.println(cal.num);
		
		cal.print();
	}

}
