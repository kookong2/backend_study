package models.member;

import org.mindrot.bcrypt.BCrypt;

public class MemberLoginValidator {
	private MemberDao memberDao;

	public MemberLoginValidator(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	public void check(Member member) {
		/**
		 * 유효성 검사 - doLogin-> 함수써서MemberLoginValidator 
		 * 1.필수 항목 체크(유효성 검사 -userId,
		 * userPw) 
		 * 2. userId로 회원이 있는지 체크
		 *  3. 회원이 있다면 비밀번호 검증
		 */

		// 1.필수항목 체크 S
		String userId = member.getUserId();
		String userPw = member.getUserPw();

		if (userId == null || userId.isBlank()) {
			throw new MemberValidationException("아이디를 입력하세요");
		}

		if (userPw == null || userPw.isBlank()) {
			throw new MemberValidationException("비밀번호를 입력하세요");
		}
		// 1.필수항목 체크 E

		// 2.userId로 회원이 있는지 체크 S
		Member IsMember = memberDao.get(userId);
		if (IsMember == null) {
			throw new LoginMemberNotFoundException();
		}
		// 2.userId로 회원이 있는지 체크 E

		// 3. 회원이 있다면 비밀번호 검증 S
		boolean match = BCrypt.checkpw(userPw, IsMember.getUserPw());
		if (!match) {
			throw new LoginMemberNotFoundException();
		}
		// 3. 회원이 있다면 비밀번호 검증 E
	}

}
