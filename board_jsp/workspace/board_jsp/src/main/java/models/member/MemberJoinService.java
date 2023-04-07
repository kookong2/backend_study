package models.member;

import javax.servlet.http.HttpServletRequest;

import org.mindrot.bcrypt.*;

public class MemberJoinService  {
	private MemberDao memberdao;
	private MemberJoinValidator validator;
	
	public MemberJoinService (MemberDao memberdao) {
		this.memberdao=memberdao;
	}
	
	public void setJoinValidator(MemberJoinValidator validator) {
		this.validator= validator;
	}
	
	/**
	 * 회원가입 진행(웹브라우저)- > DB처리 
	 * @param request
	 */
	public void doJoin(HttpServletRequest request) {
		/**
		 * 1. set을 회원가입 넣기 
		 * 
		 * 2. 기능구현 -> 유효성 검사 
		 * 	1) 필수 항목 작성 체크 - userId , userNm, userPw,usePwRe, mobile,gender,birth
		 * 	2) 아이디(useId)는 6~20자리 이하
		 * 	3) 아이디 중복 체크 ( userId로 조회하면 가능)
		 * 	4) 비밀번호는 8자리 이상
		 * 	5) 비밀번호 확인(userPwRe) 
		 * 	6) 휴대전화 형식 체크
		 *
		 * 3. DB 처리
		 */
		
		//1. set으로 브라우저에서 member객체에 넣어놓기
		Member member=new Member();
		
		member.setUserId(request.getParameter("userId"));
		member.setUserNm(request.getParameter("userNm"));
		member.setUserPw(request.getParameter("userPw"));
		member.setUserPwRe(request.getParameter("userPwRe"));
		member.setMobile(request.getParameter("mobile"));
		member.setGender(request.getParameter("gender"));
		member.setBirthYY(request.getParameter("birthYY"));
		member.setBirthMM(request.getParameter("birthMM"));
		member.setBirthDD(request.getParameter("birthDD"));
		
		//2. 넣은 걸로 유효성 검사 진행 
		if(validator!=null) {
			validator.check(member);
		}
		
		// 비밀번호 암호화
		String hash = BCrypt.hashpw(member.getUserPw(),BCrypt.gensalt(12));
		member.setUserPw(hash);
		
		//3. DB 처리
		boolean result =memberdao.register(member);
		if(!result) {
			throw new JoinFailException();
		}
	}

}
