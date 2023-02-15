package models.member;

import javax.servlet.http.HttpServletRequest;
import org.mindrot.bcrypt.BCrypt;

public class MemberJoinService {

	private MemberDao memberDao;
	private MemberJoinValidator validator;
	
	public MemberJoinService(MemberDao memberDao) {
		this.memberDao=memberDao;
	}
	
	public void setValidator(MemberJoinValidator validator) {
		this.validator=validator;
	}
	
	public void doJoin(HttpServletRequest request) {
		/**
		 *  1. 데이터 검증 -유효성 검사 -> 따로 클래스 만들어서 (MemberJoinValidator
		 *  2.필수 항목= userId, userPw, userPwRe,userNm
		 *  3.아이디 자리수는 6~20자리 미만 , 비밀번호 8자리 이상
		 *  4.아이디 중복여부 검사
		 *  5.비밀번호 확인(userPw, userPwRe 일치)
		 * 
		
		 *  2.DB처리
		 *  
		 */
		
		Member member=new Member();
		member.setUserId(request.getParameter("userId"));
		member.setUserPw(request.getParameter("userPw"));
		member.setUserPwRe(request.getParameter("userPwRe"));
		member.setUserNm(request.getParameter("userNm"));
		member.setMobile(request.getParameter("mobile"));
		
		boolean agree = request.getParameter("agree") == null ? false : true;
		member.setAgree(agree);
		
		if(validator!=null) {
			validator.check(member);
		}
		
		// DB 처리
		
		// 비번 암호화 (BCrypt 해시)
		String hash = BCrypt.hashpw(member.getUserPw(), BCrypt.gensalt(12));
		member.setUserPw(hash);
		
		
		boolean result = memberDao.register(member);
		if(!result) {	//회원가입 실패
			throw new JoinFailException();
		}
	}
	
}
