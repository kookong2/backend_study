package models.member;

import javax.servlet.http.HttpServletRequest;

/**
 * 로그인 기능
 * @author LG
 *
 */
public class MemberLoginService {
	private MemberDao memberDao;
	private MemberLoginValidator validator;
	
	public MemberLoginService(MemberDao memberDao, MemberLoginValidator validator) {
		this.memberDao = memberDao;
		this.validator = validator;
	}
	
	/**
	 *  로그인 기능 
	 * 
	 * 	유효성 검사
	 *  1. 필수 항목 체크(유효성 검사 - userId, userPw)
	 *  2. userId로 회원이 있는지 체크
	 *  3. 회원이 있다면 비밀번호 검증
	 *  
	 *  로그인 처리
	 *  4. 비밀번호가 검증 완료된 경우 로그인 처리(HttpSession)
	 *  5. 아이디 저장이 있거나 없는 경우 처리
	 *  	- 아이디 저장이 있는 경우 -> 쿠키에 등록(365일 - 만료시간)
	 *  	- 아이디 저장이 없는 경우 -> 쿠키 삭제
	 */
	
	public void doLogin(HttpServletRequest request) {
		// 유효성 검사
		Member member = new Member();
		member.setUserId(request.getParameter("userId"));
		member.setUserPw(request.getParameter("userPw"));
		
		if(validator != null) {
			validator.check(member);
		}
	}

}
