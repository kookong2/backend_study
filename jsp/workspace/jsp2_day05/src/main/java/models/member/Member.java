package models.member;

import java.time.LocalDateTime;

public class Member {
	private int userNo;
	private String userId;
	private String userPw;
	private String userNm;
	private String mobile;
	private LocalDateTime regDt;
	private LocalDateTime modDt;
	
	
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
	public String getUserNm() {
		return userNm;
	}
	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
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
	
	@Override
	public String toString() {
		return "Member [userNo=" + userNo + ", userId=" + userId + ", userPw=" + userPw + ", userNm=" + userNm
				+ ", mobile=" + mobile + ", regDt=" + regDt + ", modDt=" + modDt + "]";
	}
	
	
	
}
