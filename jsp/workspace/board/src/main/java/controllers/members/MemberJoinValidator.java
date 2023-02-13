package controllers.members;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import models.member.Member;
import models.member.MemberDao;

@Component
public class MemberJoinValidator implements Validator {
	
	@Autowired
	private MemberDao memberDao;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Member.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Member member = (Member)target;
		
		/** 1. 회원아이디 중복 여부 체크 */
		Member member2 = memberDao.get(member.getUserId());
		if (member2 != null) { // 회원이 이미 있으면 X
			errors.reject("duplicateMember", "이미 가입된 아이디 입니다.");
		}
		
		/** 2. 비밀번호와 비밀번호 확인 일치 여부 체크 */
		String userPw = member.getUserPw();
		String userPwRe = member.getUserPwRe();
		if (!userPw.equals(userPwRe)) {
			errors.reject("incorrectPassword", "비밀번호가 일치하지 않습니다.");
		}
	}
}
