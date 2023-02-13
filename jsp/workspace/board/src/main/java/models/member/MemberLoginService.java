package models.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

import org.mindrot.bcrypt.BCrypt;

import controllers.members.LoginCommand;

@Service
public class MemberLoginService {
	
	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	private HttpSession session;
	
	public void process(LoginCommand loginCommand) {
		String userId = loginCommand.getUserId();
		String userPw = loginCommand.getUserPw();
		String message = "아이디 또는 비밀번호가 일치하지 않습니다.";
		
		/** 1. 아이디로 검색되는 회원이 있는지? */
		Member member = memberDao.get(userId);
		if (member == null) {
			throw new RuntimeException(message);
		}
		
		/** 2. 회원이 있다면? 비밀번호가 일치하는 지 체크 */
		boolean matched = BCrypt.checkpw(userPw, member.getUserPw());
		if (!matched) {
			throw new RuntimeException(message);
		}
		
		/** 3. 비밀번호가 일치하면? 세션에 회원정보 저장 */
		session.setAttribute("member", member);
	}
}
