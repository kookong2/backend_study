package models.member;

/**
 * 로그인 유효성 검사
 * 
 *
 */
public class MemberLoginValidator {
	
	private MemberDao memberDao;
	
	public MemberLoginValidator(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	/**
	 *	유효성 검사
	 *  1. 필수 항목 체크(유효성 검사 - userId, userPw)
	 *  2. userId로 회원이 있는지 체크
	 *  3. 회원이 있다면 비밀번호 검증
	*/
	public void check(Member member) {
		
		// 1. 필수 항목 체크(userId, userPw)
		String userId = member.getUserId();
		String userPw = member.getUserPw();
		
		if(userId == null || !userId.isBlank()) {
			throw new MemberValidationException("아이디를 입력하세요.");
		}
		
		if(userPw == null || !userPw.isBlank()) {
			throw new MemberValidationException("비밀번호를 입력하세요.");
		}
		
		
		// 2. userId로 회원이 있는지 체크
		Member member2 = memberDao.get(userId);
		if(member2 == null) {
			throw new LoginUserIncorrectException();
		}
	}
}
