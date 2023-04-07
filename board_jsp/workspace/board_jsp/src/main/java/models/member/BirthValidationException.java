package models.member;

public class BirthValidationException extends RuntimeException {

	public BirthValidationException() {
		super("생년월일이 올바르지 않습니다.");
	}
	public BirthValidationException(String message) {
		super(message);
	}
}
