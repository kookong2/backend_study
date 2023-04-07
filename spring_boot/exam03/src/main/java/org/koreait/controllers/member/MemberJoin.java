package org.koreait.controllers.member;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.koreait.entities.Member;
import org.modelmapper.ModelMapper;

@Data @Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberJoin {
    @Size(min=6, message="아이디는 6자리 이상 입력하세요.")
    @NotBlank(message="아이디를 입력하세요.")
    private String userId;

    @Size(min=8, message="비밀번호는 8자리 이상 입력하세요.")
    @NotBlank(message="비밀번호를 입력하세요.")
    private String userPw;

    @NotBlank(message="비밀번호를 확인하세요.")
    private String userPwRe;

    @NotBlank(message="회원명을 입력하세요.")
    private String userNm;

    @Email(message="이메일 형식이 아닙니다.")
    private String email;

    private String mobile;

    @AssertTrue(message="가입 약관에 동의하세요.")
    private boolean agree;

    public static Member of(MemberJoin memberJoin) {
        ModelMapper mapper = new ModelMapper();

        return mapper.map(memberJoin, Member.class);
    }
}
