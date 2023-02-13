package controllers.members;

import javax.validation.constraints.NotBlank;

public class LoginCommand {
	
	@NotBlank(message="아이디를 입력하세요.")
	private String userId;
	
	@NotBlank(message="비밀번호를 입력하세요.")
	private String userPw;
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getUserPw() {
		return userPw;
	}
	
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	
	@Override
	public String toString() {
		return "LoginCommand [userId=" + userId + ", userPw=" + userPw + "]";
	}
}
