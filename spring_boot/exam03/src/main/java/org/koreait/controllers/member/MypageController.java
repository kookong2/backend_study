package org.koreait.controllers.member;

import org.koreait.entities.Member;
import org.koreait.models.member.MemberDetails;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/mypage")
public class MypageController {
    @GetMapping
    public String index(Principal principal) {
        MemberDetails member = (MemberDetails)principal;

         Object pr = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
         MemberDetails member2 = (MemberDetails)pr;

        return "member/index";
    }
    /**
    public String index(@AuthenticationPrincipal MemberDetails member) {
        System.out.println(member);
        return "member/index";
    }
     */
}
