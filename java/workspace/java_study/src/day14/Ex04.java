package day14;

public class Ex04 {
	public static void main(String[] args) {
		
		//Integer num1 = new Integer(10);
		//Integer num2 = new Integer(10);
		
		Integer num1 = Integer.valueOf(10);
		Integer num2 = Integer.valueOf(10);
		Number num3 = num2;
		Number num4 = Long.valueOf(1L);
		Number num5 = Float.valueOf(10.123F);
		
		System.out.println(System.identityHashCode(num1));
		System.out.println(System.identityHashCode(num2));
	}
}
