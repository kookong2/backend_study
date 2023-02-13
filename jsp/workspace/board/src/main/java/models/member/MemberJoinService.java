package models.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

import controllers.members.MemberJoinValidator;

@Service
public class MemberJoinService {
	
	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	private MemberJoinValidator validator;
	
	public void process(Member member, Errors errors) {
		if (errors.hasErrors()) {
			throw new RuntimeException("common");
		}
		
		validator.validate(member, errors);
		if (errors.hasErrors()) {
			throw new RuntimeException("common");
		}
		
		boolean result = memberDao.register(member);
		if (!result) {
				throw new RuntimeException("회원가입에 실패하였습니다.");
		}
	}
}
