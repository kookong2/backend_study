package day12.sub1;

public class MemberNotFoundException extends RuntimeException{
	public MemberNotFoundException(String message) {
		// super() -> 상위 클래스의 기본 생성자 super() 자동 추가
		// 그래서 추가 안 해주면 기본으로 자동 추가 됨 -> 그래서 추가 해 주어야 함
		super(message);
		
		
	}
}
