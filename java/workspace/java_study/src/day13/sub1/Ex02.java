package day13.sub1;

public class Ex02 {
	public static void main(String[] args) {
		
		Person p1 = new Person(30, "이름");	// p1 - 객체 참조 주소
		Person p2 = new Person(20, "이름2");	// p2 - 객체 참조 주소
		Person p3 = p1;	// p1 - 객체 참조 주소
		
		
		boolean isSame = p1.equals(p2);
		System.out.println(isSame);
		
		boolean isSame2 = p1.equals(p3);
		System.out.println(isSame2);
		
		
	}
}
