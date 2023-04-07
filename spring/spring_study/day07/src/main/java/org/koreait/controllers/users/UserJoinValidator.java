package org.koreait.controllers.users;

import org.koreait.models.member.MemberDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserJoinValidator implements Validator {
	
	// Validator의 support() 메서드는 Validator가 검증할 수 있는 타입인지 검사
	// Validator의 validate() 메서드는 첫 번째 파라미터로 전달받은 객체를 검증하고
	//				오류 결과를 Errors에 담는 기능을 정의
	
	// 스프링 MVC에서 Validator를 사용하는 코드는 요정매핑 어노테이션 적용 메서드에
	// Errors타입 파라미터를 전달받고, 이 Errors 객체를 Validator의 validate() 메서드에
	// 두 번째 파라미터로 전달
	
	@Autowired
	private MemberDao memberDao;
	
	// 스프링 MVC가 자동으로 검증 기능을 수행하도록 설정하려면 support() 메서드를 구현해함
	@Override
	public boolean supports(Class<?> clazz) {

		return MemberJoin.class.isAssignableFrom(clazz);
	}

	// validate()
	//
	// validate() 메서드는 두 개의 파라미터를 갖는다.
	//		- target 파라미터는 검사 대상 객체
	//		- errors 파라미터는 검사 결과 에러 코드를 설정하기 위한 객체
	// validate() 메서드는 다음과 같이 구현
	//		- 검사 대상 객체의 특정 프로퍼티나 상태가 올바른지 검사
	//		- 올바르지 않다면 Errors의 rejectValue() 메서드를 이요해서 에러 코드 저장
	@Override
	public void validate(Object target, Errors errors) {
		//요청 매핑 어노테이션 적용 메서드의 커맨드 객체 파라미터 뒤에 Errors 타입
		// 파라미터가 위치하면, 스프링 MVC는 validate()메서드를 호출할 때 커맨드
		// 객체와 연결된 Errors객체를 생성해서 파라미터로 전달
		// Erros 타입 파라미터는 반드시 커맨드 객체를 위한 파라미터 다음에 위치해야함
		//		ex) public void validate(Errors errors, Object target) X
		//			-> 요청 처리를 올바르게 하지 않고 익셉션이 발생
		
		MemberJoin member = (MemberJoin)target;
		String userId = member.getUserId();
		String userPw = member.getUserPw();
		String userPwRe = member.getUserPwRe();
		String mobile = member.getMobile();
		/**
		 * 1. 아이디의 중복여부
		 * 2. 비밀번호, 비밀번호 확인이 일치
		 * 3. 휴대전화번호가 있으면 형식 체크
		 */
		// 1. 아이디의 중복여부
		if (userId != null && !userId.isBlank() && memberDao.isExists(userId)) {
			// 정규 표현식이 일치하지 않으면 "userId" 프로퍼티의 에러코드를 "dupUserId"로 추가
			// Errors의 rejectValue() 메서드는 첫 번째 파라미터로 프로퍼티의 이름을 전달받고,
			//		두 번째 파라미터로 에러코드를 전달 받는다.
			errors.rejectValue("userId", "dupUserId", "이미 등록된 아이디 입니다.");
		}
		
		// 2. 비밀번호, 비밀번호 확인이 일치
		if (userPw != null && !userPw.isBlank() && userPwRe != null && !userPw.equals(userPwRe)) {
			errors.rejectValue("userPw", "passwordIncorrect", "비밀번호가 일치하지 않습니다.");
		}
		
		// 3. 휴대전화번호가 있으면 형식 체크
		/**
		 * 010-0000-0000
		 * 010.0000.0000
		 * [^0-9]
		 * [^\d]
		 * \D
		 */
		if (mobile != null && !mobile.isBlank()) {
			 mobile = mobile.replaceAll("\\D", "");
			 String pattern = "^01[016]\\d{3,4}\\d{4}$";
			 if (!mobile.matches(pattern)) { // 휴대전화번호 형식 아닌 경우 
				 errors.rejectValue("mobile", "wrongCellPhoneNum", "휴대전화번호 형식이 아닙니다.");
			 }
		}
		
	}

}
