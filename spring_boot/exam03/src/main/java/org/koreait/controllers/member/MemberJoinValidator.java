package org.koreait.controllers.member;


import com.querydsl.core.BooleanBuilder;
import org.koreait.entities.QMember;
import org.koreait.repositories.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class MemberJoinValidator implements Validator {

    @Autowired
    private MemberRepository repository;

    @Override
    public boolean supports(Class<?> clazz) {
        return MemberJoin.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        MemberJoin memberJoin = (MemberJoin)target;
        String userId = memberJoin.getUserId();
        String userPw = memberJoin.getUserPw();
        String userPwRe = memberJoin.getUserPwRe();
        String mobile = memberJoin.getMobile();

        /** 아이디 중복 여부 */
        if (userId != null && !userId.isBlank()) {
            BooleanBuilder builder = new BooleanBuilder();
            QMember member = QMember.member;
            builder.and(member.userId.eq(userId));
            long count = repository.count(builder);
            if (count > 0) {
                errors.rejectValue("userId", "DuplicateMember", "이미 가입된 회원입니다.");
            }
        }

        /** 비밀번호와 비밀번호 확인 */
        if (userPw != null && userPwRe != null && !userPw.isBlank() && !userPwRe.isBlank()
                    && !userPw.equals(userPwRe)) {
            errors.rejectValue("userPwRe", "PasswordIncorrect", "비밀번호가 일치하지 않습니다.");
        }

        /** 휴대전화번호가 있으면 검증 */
        if (mobile != null && !mobile.isBlank()) {
            // 1. 번호를 통일성 있게 변경 -> 숫자로만 만든다!
            // 2. 패턴 체크
            mobile = mobile.replaceAll("\\D", "");
            memberJoin.setMobile(mobile);

            String pattern = "^01[016]\\d{3,4}\\d{4}$";
            if (!mobile.matches(pattern)) {
                errors.rejectValue("mobile", "WrongMobileNum", "휴대전화번호 형식이 아닙니다.");
            }
        }

    }
}
