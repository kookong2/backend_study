package day13.sub2;

public class Ex03 {
	public static void main(String[] args) {
		
		String str1 = "I Love";
		
		System.out.println(System.identityHashCode(str1));
		
		str1 += " JAVA";
		System.out.println(System.identityHashCode(str1));
		
		str1 += " A ";
		
		System.out.println(System.identityHashCode(str1));
		System.out.println(str1);
		
		
		
	}
}
