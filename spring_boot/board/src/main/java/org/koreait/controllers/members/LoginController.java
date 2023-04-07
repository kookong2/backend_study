package org.koreait.controllers.members;

import org.koreait.models.member.MemberDetails;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/member/login")
public class LoginController {
    @GetMapping
    public String login(String success, Model model,@AuthenticationPrincipal MemberDetails memberDetails){

        //로그인한 회원정보

        /* 1)첫번쨰 방법
        // interface Principal -> 구현체 userDetails (우리는 MemberDetails )
        // 형변환을 해서 사용
        if(principal != null){
            MemberDetails memberDetails = (MemberDetails) principal;
            System.out.println(memberDetails);
        }
        */
        /*  2) @AuthenticationPrincipal 애노테이션 사용
                -> 애노테이션 사용해서 memberDetail에 바로 대입
        */
        /* 3) 요청 메서드에서 주입을 할 수 없는 경우
            : AuditorAwareImpl 클래스에서 구현함
            Object SecurityContectHolder -> MemberDetail로 형변환 해서 사용
         */

        System.out.println(memberDetails);

        model.addAttribute("success", success);

        return "member/login";
    }



}
