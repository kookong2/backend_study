package models.member;

public class MemberValidationException  extends RuntimeException{
	
	private static String message="잘못된 데이터 입니다.";
	
	public MemberValidationException() {
		super(message);
	}
	
	public MemberValidationException(String message) {
		super(message);
	}

}
