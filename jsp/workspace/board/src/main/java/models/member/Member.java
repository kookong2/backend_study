package models.member;

import java.time.LocalDateTime;

import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Member {
	private int userNo; // 회원번호
	
	@NotBlank(message="아이디를 입력하세요.")
	@Size(min=6, message="아이디는 최소 6자리 이상 입력하세요.")
	private String userId; // 회원아이디
	
	@NotBlank(message="비밀번호를 입력하세요.")
	@Size(min=8, max=16, message="비밀번호는 8자리부터 16자리 까지 입력하세요.")
	private String userPw; // 비밀번호 
	
	@NotBlank(message="비밀번호를 확인하세요.")
	private String userPwRe; // 비밀번호 확인
	
	@NotBlank(message="회원명을 입력하세요.")
	private String userNm; // 회원명
	
	@Email(message="이메일 형식이 아닙니다.")
	private String email; // 이메일 
	
	private MemberType userType = MemberType.MEMBER; // 일반회원(기본값)
	
	private LocalDateTime regDt; // 가입일시
	private LocalDateTime modDt; // 수정일시
	
	@AssertTrue(message="회원가입 약관에 동의하세요.")
	private boolean agree; // 회원가입 약관 동의 여부
	
	
	public int getUserNo() {
		return userNo;
	}
	
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	
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
	
	public String getUserPwRe() {
		return userPwRe;
	}
	
	public void setUserPwRe(String userPwRe) {
		this.userPwRe = userPwRe;
	}
	
	public String getUserNm() {
		return userNm;
	}
	
	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public MemberType getUserType() {
		return userType;
	}

	public void setUserType(MemberType userType) {
		this.userType = userType;
	}

	public LocalDateTime getRegDt() {
		return regDt;
	}
	
	public void setRegDt(LocalDateTime regDt) {
		this.regDt = regDt;
	}
	
	public LocalDateTime getModDt() {
		return modDt;
	}
	
	public void setModDt(LocalDateTime modDt) {
		this.modDt = modDt;
	}
	
	public boolean isAgree() {
		return agree;
	}

	public void setAgree(boolean agree) {
		this.agree = agree;
	}

	@Override
	public String toString() {
		return "Member [userNo=" + userNo + ", userId=" + userId + ", userPw=" + userPw + ", userPwRe=" + userPwRe
				+ ", userNm=" + userNm + ", email=" + email + ", regDt=" + regDt + ", modDt=" + modDt + "]";
	}
}
