package commons.validator;

public interface PasswordValidator {
	  /**
	    * 비밀번호 유효성 검사 
	    */
	      
	      default boolean passwordCheck(String userPw){
	          //  1. 영문, 숫자, 특수기호 조합으로 8~20자리 비밀번호 패턴 만들기 
	          //  2.체크
	    	  // 대소문자 1개 이상 // 특수문자(!@#$%^*)// 숫자 0-9 // 8~20자 이상
	      
	         String pattern = "^(?=.*[a-zA-Z])(?=.*[!@#$%^*])(?=.*[0-9]).{8,20}$";
	        return userPw.matches(pattern);
	          //return true;
	         
	      }
}
