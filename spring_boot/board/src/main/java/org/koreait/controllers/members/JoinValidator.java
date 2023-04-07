package org.koreait.controllers.members;

import lombok.RequiredArgsConstructor;
import org.koreait.commons.validators.MobileValidator;
import org.koreait.repositories.MemberRepository;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
@RequiredArgsConstructor
public class JoinValidator implements Validator, MobileValidator {

    private final MemberRepository repository;

    @Override
    public boolean supports(Class<?> clazz) {
        return Join.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Join join = (Join)target;
        String userId = join.getUserId();
        String userPw = join.getUserPw();
        String userPwRe = join.getUserPwRe();
        String mobile = join.getMobile();

        // 1. 아이디 중복 여부
        if (userId != null && !userId.isBlank() && repository.isExists(userId)) {
            errors.rejectValue("userId", "Validation.join.dupUserId");
        }

        // 2. 비밀번호확인 일치 여부
        if (userPw != null && !userPw.isBlank() && userPwRe != null
                && !userPwRe.isBlank() && !userPw.equals(userPwRe)) {

            errors.rejectValue("userPwRe", "Validation.join.passwordIncorrect");
        }

        // 3. 휴대전화번호 형식
        if (mobile != null && !mobile.isBlank() && !checkMobile(mobile)) {
            errors.rejectValue("mobile", "Validation.mobile");
        }

        mobile = mobile.replaceAll("\\D", "");
        join.setMobile(mobile);
    }
}
