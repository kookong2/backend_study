package models.member;

public class LoginMemberNotFoundException extends RuntimeException {
	public LoginMemberNotFoundException() {
		super("아이디 또는 비밀번호가 존재하지 않습니다.");
	}

}
