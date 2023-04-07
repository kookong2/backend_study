package org.koreait.controllers.members;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class MemberJoin {
    @NotBlank(message = "아이디를 입력하세요.")
    @Size(min=6, message="아이디는 6자리 이상 입력하세요.")
    private String userId;
    @NotBlank(message = "비밀번호를 입력하세요.")
    @Size(min=8, message="비밀번호는 8자리 이상 입력하세요.")
    private String userPw;
    @NotBlank(message = "비밀번호를 입력하세요.")
    private String userPwRe;
    @NotBlank(message = "회원명을 입력하세요.")
    private String userNm;
    @Email(message = "이메일 형식이 아닙니다.")
    private String email;
    @NotBlank(message = "전화번호를 입력해 주세요")
    private String mobile;

    @AssertTrue(message = "약관에 동의하세요.")
    private String agree;



}
