package models.member;

import commons.validator.BirthValidator;
import commons.validator.MobileValidator;
import commons.validator.PasswordValidator;
import commons.validator.RequiredValidator;


public class MemberJoinValidator implements RequiredValidator ,MobileValidator, PasswordValidator,BirthValidator{
	
	private MemberDao memberDao;
	
	public MemberJoinValidator(MemberDao memberDao) {
		this.memberDao=memberDao;
	}
	
	/**
	 *  기능구현 -> 유효성 검사 
	 * 	1) 필수 항목 작성 체크 - userId , userNm, userPw,usePwRe, mobile,gender,birth
	 * 	2) 아이디(useId)는 6~20자리 이하
	 * 	3) 아이디 중복 체크 ( userId로 조회하면 가능)
	 * 	4) 비밀번호는 8자리 이상
	 * 	5) 비밀번호 확인(userPwRe) 
	 * 	6) 휴대전화 형식 체크(휴대전화 입력은 선택)
	 *     7) 성별 선택 체크
	 */
	
	public void check(Member member) {
		
		//	1) 필수 항목 작성 체크 S - userId , userNm, userPw,usePwRe, mobile,gender,birth		/
		String userId = member.getUserId();
		String userNm = member.getUserNm();
		String userPw= member.getUserPw();
		String userPwRe= member.getUserPwRe();
		String mobile=member.getMobile();
		String gender = member.getGender();
		String birthYY =member.getBirthYY();
		String birthMM =member.getBirthMM();
		String birthDD =member.getBirthDD();
	
		
		checkedrequired(userId,new MemberValidationException("아이디를 입력해주세요.") );
		checkedrequired(userPw,new MemberValidationException("비밀번호를 입력해주세요"));
		checkedrequired(userNm,new MemberValidationException("이름을 입력해주세요"));
		// 1) 필수 항목 작성 체크 E
		
		// 2) 아이디는 6~20 자리 이하 S
		if(userId.length()<6 || userId.length()>20 ) {
			throw new MemberValidationException("아이디를 6~20자리 이하로 입력해주세요.");
		}
		// 2) 아이디는 6~20 자리 이하 E
		
		// 3) 아이디 중복 체크 S ( db 접근해서 userId로 조회 가능 => dao.isExist 함수 구현) 
		if(memberDao.isExists(userId)) {
			throw new MemberValidationException("아이디가 중복됩니다. 다시 입력해주세요.");
		}
		// 3) 아이디 중복 체크 E
		
		// 4 비밀번호 8자리~20자리
		// 대문자 하나 이상, 소문자 하나, 숫자 하나 및 특수 문자 하나 이상 포함 여부 체크
	      if (userPw != null || userPw.isBlank()) {
	          boolean checkPw = passwordCheck(userPwRe);
	          if (!checkPw) {
	             throw new MemberValidationException("비밀번호는 영문, 숫자, 특수기호(!@#$%^*)조합으로 8-20자리 이상으로 입력하세요.");
	          }

	       }
		// 4) 비밀번호는 8자리 이상 E
	
		//  5) 비밀번호 확인(userPwRe) S
		if(!userPwRe.equals(userPw)){
			throw new MemberValidationException("비밀번호가 일치하지 않습니다.");
		}
		//  5) 비밀번호 확인(userPwRe) E 
		 
		// 6) 휴대전화 형식 체크 S (전화번호는 선택사항 즉, null 이어도 무방)
		if (mobile != null || !mobile.isBlank()) {
			mobile=mobile.replace("\\D","" ); // 010- 를 010 으로 바꿈
			boolean check = checkMobile(mobile);
			if(!check) {
				throw new MemberValidationException("전화번호 형식이 올바르지 않습니다.");
			}
		}
		// 6) 휴대전화 형식 체크 E
		
		// 7) 생년월일선택 체크 S
		/**
		 * 1. 년도가 4자리가 맞는지 체크 
		 * 				-> 4자리 아니면 예외처리 
		 * 2. 일자가 1일보다 크고, 31일보다 작은지 체크
		 * 				-> 범위를 넘어선다면 예외 처리
		 * 3. 2월에는 28일까지만 존재하는지 체크  
		 * 				-> 28일보다 크게 적었다면 28일로 저장
		 */
		if(birthYY !=null) {
			birthYY=checkBirthYY(birthYY);
			if(Integer.parseInt(birthYY)<1900) {
				throw new BirthValidationException("정말인가요?");
			}
		}
		if(birthDD !=null) {
			birthDD=checkBirthDD(birthMM,birthDD);
		}
  
		// 7) 생년월일  선택 체크 E
		
		
		
	}

}
