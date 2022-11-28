package day13;

public class Ex02 {
	public static void main(String[] args) {
		Student st = new MiddleSchoolStudent(); // Object가 상위 클래스
		
		String name = "학생"; 	// 전부 Object가 상위 클래스
		
		Object[] data = new Object[2];
		data[0] = st;
		data[1] = name;
	}
}
