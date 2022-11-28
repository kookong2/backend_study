package day13.sub1;

public class Ex06 {
	public static void main(String[] args) {
		fruits("사과","배","바나나","멜론","망고");
		
	}
	
	public static void fruits(String...fruits) {
		System.out.println(java.util.Arrays.toString(fruits));
	}
}
