package commons.library;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import models.member.Member;

public class MemberLibrary {
	
	/**
	 * 서버 세션에 존재하고 있는 회원 정보를 가져옴 즉, 로그인하는 회원에 대한 정보를 가져오는 것 .
	 * @param request
	 * @return
	 */
	public static Member getLoginMember(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Member member=(Member)session.getAttribute("member");
		return member;
	}
	
	/**
	 * 로그인 상태를 체크
	 * @param request
	 * @return
	 */
	public static boolean isLogin(HttpServletRequest request) {
		Member member = getLoginMember(request);
		return member != null; // null이 아니면 로그인됨, null이면 정보 없음으로 실패
	}

}
