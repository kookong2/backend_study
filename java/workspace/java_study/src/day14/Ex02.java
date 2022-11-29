package day14;

public class Ex02 {
	public static void main(String[] args) {
		
		String str1 = "abc"; // 문자열 상수
		String str2 = "abc";
		
		System.out.println(System.identityHashCode(str1));
		System.out.println(System.identityHashCode(str2));
		
		System.out.println(str1 == str2);
		System.out.println(str1.equals(str2));
		
		int num = 10; //리터럴 상수
		
		checkString(new String("abc"));
	}
	
	public static void checkString(String str) {
		System.out.println(str.equals("abc"));
	}
}
