package commons;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import models.member.Member;

@Component
public class Library {
	
	@Autowired
	private HttpSession session;
	
	public boolean isLogin() {
		Member member = getMember();
		return member != null;
	}
	
	/**
	 * 로그인한 회원 정보 
	 * @return
	 */
	public Member getMember() {
		Member member = (Member)session.getAttribute("member");
		return member;
	}
}
