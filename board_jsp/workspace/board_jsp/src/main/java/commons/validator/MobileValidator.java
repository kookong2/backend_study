package commons.validator;

import models.member.MemberValidationException;

public interface MobileValidator {

	
	 default boolean checkMobile(String mobile) {
		String pattern=null;
		if(mobile!=null || !mobile.isBlank()) {
		mobile=mobile.replaceAll("\\D", "");
			
		 pattern = "01[016]\\d{3,4}\\d{4}";
		}			
		return mobile.matches(pattern);
		
	}
}
