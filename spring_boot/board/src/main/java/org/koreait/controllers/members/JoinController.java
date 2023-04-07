package org.koreait.controllers.members;

import jakarta.validation.Valid;
import org.koreait.models.member.MemberJoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("memberJoinController")
@RequestMapping("/member/join")
public class JoinController {

    @Autowired
    private JoinValidator validator;

    @Autowired
    private MemberJoinService service;

    @GetMapping
    public String join(Model model) {
        Join join = new Join();
        model.addAttribute("join", join);

        return "member/join";
    }

    @PostMapping
    public String joinPs(@Valid Join join, Errors errors) {
        validator.validate(join, errors);

        if (errors.hasErrors()) {
            return "member/join";
        }

        service.join(join);

        return "redirect:/member/login"; // 회원가입 성공시 -> 로그인 페이지 이동
    }
}
