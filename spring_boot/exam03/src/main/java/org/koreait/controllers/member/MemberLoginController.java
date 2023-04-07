package org.koreait.controllers.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberLoginController {
    @GetMapping("/member/login")
    public String login() {

        return "member/login";

    }
}
