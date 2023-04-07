package models.member;

import java.time.LocalDateTime;

public class Member {
	
	private int userNo;
	private String userId;
	private String userNm;
	private String userPw;
	private String userPwRe;
	private String mobile;
	private String gender;
	private String birthYY;
	private String birthMM;
	private String birthDD;
	private boolean agree;
	private String userType;
	private LocalDateTime regDt;
	private LocalDateTime modDt;
	
	

	@Override
	public String toString() {
		return "Member [userNo=" + userNo + ", userId=" + userId + ", userNm=" + userNm + ", userPw=" + userPw
				+ ", userPwRe=" + userPwRe + ", mobile=" + mobile + ", gender=" + gender + ", birthYY=" + birthYY
				+ ", birthMM=" + birthMM + ", birthDD=" + birthDD + ", agree=" + agree + ", userType=" + userType
				+ ", regDt=" + regDt + ", modDt=" + modDt + "]";
	}

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
	
	public String getUserNm() {
		return userNm;
	}
	
	public void setUserNm(String userNm) {
		this.userNm = userNm;
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
	
	public String getMobile() {
		return mobile;
	}
	
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getBirthYY() {
		return birthYY;
	}

	public void setBirthYY(String birthYY) {
		this.birthYY = birthYY;
	}

	public String getBirthMM() {
		return birthMM;
	}

	public void setBirthMM(String birthMM) {
		this.birthMM = birthMM;
	}

	public String getBirthDD() {
		return birthDD;
	}

	public void setBirthDD(String birthDD) {
		this.birthDD = birthDD;
	}

	public boolean isAgree() {
		return agree;
	}
	
	public void setAgree(boolean agree) {
		this.agree = agree;
	}
	
	public String getUserType() {
		return userType;
	}
	
	public void setUserType(String userType) {
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

}
