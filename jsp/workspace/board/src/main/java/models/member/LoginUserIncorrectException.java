package models.member;

public class LoginUserIncorrectException extends RuntimeException{
	public LoginUserIncorrectException() {
		super("아이디 또는 비번이 맞지 않습니다.");
	}

}
