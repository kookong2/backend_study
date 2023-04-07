package org.koreait.commons.validators;

public interface MobileValidator {
    default boolean checkMobile(String mobile) {
        /**
         * 1. 번호 형식을 통일화 -> 숫자
         * 2. 패턴 만들고 체크
         */
        mobile = mobile.replaceAll("\\D", "");

        String pattern = "^01[016]\\d{3,4}\\d{4}$";

        return mobile.matches(pattern);
    }
}
