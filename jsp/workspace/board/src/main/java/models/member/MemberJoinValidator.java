package models.member;

import javax.servlet.http.HttpServletRequest;

import commons.validator.MobileValidator;

public class MemberJoinValidator implements MobileValidator{
	
	private MemberDao memberDao;
	
	public MemberJoinValidator(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public void check(Member member) {
		
	/**
	 *  1. 데이터 검증 -유효성 검사 -> 따로 클래스 만들어서 (MemberJoinValidator
	 *  2. 필수 항목= userId, userPw, userPwRe,userNm
	 *  3. 아이디 자리수는 6~20자리 미만 , 비밀번호 8자리 이상
	 *  4. 아이디 중복여부 검사
	 *  5. 비밀번호 확인(userPw, userPwRe 일치)
	 *  6. 휴대전화번호 있으면 형식 체크
	 */
		//1. 필수항목체크
		String userId=member.getUserId();
		String userPw=member.getUserPw();
		String userPwRe=member.getUserPwRe();
		String userNm=member.getUserNm();
		String mobile=member.getMobile();
		mobile = mobile == null ? null : mobile.replaceAll("\\D", "");
		member.setMobile(mobile);
		
		checkRequired(userId, new MemberValidationException("아이디를 입력하세요"));
		checkRequired(userPw, new MemberValidationException("비밀번호를 입력하세요"));
		checkRequired(userPwRe, new MemberValidationException("비밀번호를 확인하세요"));
		checkRequired(userNm, new MemberValidationException("회원명을 입력하세요"));
		
		
		// 2. 아이디 자리수는 6~20자리 미만 , 비밀번호 8자리 이상
		if(userId.length() < 6 || userId.length() > 20) {
			throw new MemberValidationException("아이디는 6자리 이상 20자리 이하 입력하세요");
		}
		
		if(userPw.length() < 8) {
			throw new MemberValidationException("비밀번호는 8자리 이상 입력하세요");
		}
		
		// 3. 아이디 중복
		if(memberDao.isExists(userId)) {
			throw new DuplicateMemberException();
		}
		
		// 4. 비밀번호 확인(userPw, userPwRe 일치)
		if(!userPw.equals(userPw)) {
			throw new MemberValidationException("비밀번호가 일치하지 않습니다.");
		}
		
		// 5. 휴대전화번호 있으면 형식 체크(선택)
		if(mobile != null && !mobile.isBlank()) {
			boolean check = mobileCheck(mobile);
			if(!check) {
				throw new MemberValidationException("휴대전화번호 형식이 다릅니다.");
			}
		}
		
		// 6. 약관 동의 여부 체크
		if(!member.isAgree()) {
			throw new MemberValidationException("회원가입 약관에 동의 하세요.");
		}
}
	
	private void checkRequired(String data, RuntimeException e) {
		if(data ==null || data.isBlank()) {
			throw e;
		}
	}
}
