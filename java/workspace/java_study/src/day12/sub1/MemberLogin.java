package day12.sub1;

public class MemberLogin {
	public void login(String userId, String userPass){
		if(!userId.equals("user01")) {
			throw new MemberNotFoundException("등록되지 않은 회원입니다.");
		}
		
		if(!userPass.equals("1234")) {
			throw new PasswordIncorrectException("비밀 번호가 다릅니다.");
		}
		
		System.out.println("로그인 성공!");
	}
}
