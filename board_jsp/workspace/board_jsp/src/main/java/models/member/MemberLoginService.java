package models.member;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class MemberLoginService {
	private MemberDao memberDao;
	private MemberLoginValidator validator;
	
	public MemberLoginService(MemberDao memberDao) {
		this.memberDao=memberDao;
	}
	
	public MemberLoginService(MemberDao memberDao, MemberLoginValidator validator) {
		this.memberDao=memberDao;
		this.validator=validator;
	}
 
	public void dologin(HttpServletRequest request, HttpServletResponse response) {
		/**
		 * 로그인 기능 
		 * 
		 * 유효성 검사 - doLogin-> 함수써서MemberLoginValidator
		 * 1.필수 항목 체크(유효성 검사 -userId, userPw)
		 * 2. userId로 회원이 있는지 체크
		 * 3. 회원이 있다면 비밀번호 검증
		 * 
		 * 로그인 처리- 여기 doLogin
		 * 4. 비밀번호가 검증 완료된 경우 로그인 처리(HttpSession)
		 * 5. 아이디 저장이 있거나 없는 경우 처리
		 * 	- 아이디 저장이 있는 경우 쿠키에 등록(365일	- 만료시간)
		 *  - 아이디 저장이 없는 경우 쿠키 삭제
		 */
	
		//1. 필수 항목 체크
		Member member = new Member();
		member.setUserId(request.getParameter("userId"));
		member.setUserPw(request.getParameter("userPw"));
		
		// 유효성 검사 S
		if(validator !=null) {
			validator.check(member);
		}
		//유효성 검사 E
		
		// 4. 비밀번호가 검증 완료된 경우 로그인 처리(HttpSession) S
		Member member2 = memberDao.get(member.getUserId());
		HttpSession session = request.getSession();
		session.setAttribute("member", member2);
		// 4. 로그인 처리(HttpSession) E
		
		// 5. 아이디 저장이 있거나 없는 경우 처리
		// Cookie에 넣어서 서버에 저장
		Cookie saveId = new Cookie("saveId",member.getUserId());
		// 아이디 저장이 클릭되었으면
		if(request.getParameter("saveId")!= null) {
			saveId.setMaxAge(60*60*24*365);
		}else {
			//저장이 안되어있으면
			saveId.setMaxAge(0);
		}
	
		response.addCookie(saveId);
	}
}
