package day09.sub2;

public class Ex01 {

	public static void main(String[] args) {
		//Calculater cal = new Calculater() {
		
		SimpleCalculator cal = new SimpleCalculator();
		int result = cal.add(10, 30);
		System.out.println(result);

		int result2 = cal.minus(30, 20);
		System.out.println(result2);
	}

}
