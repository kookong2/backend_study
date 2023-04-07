package org.koreait.controllers.member;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.koreait.entities.Member;
import org.koreait.models.member.MemberJoinService;
import org.koreait.repositories.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member/join")
@RequiredArgsConstructor
public class MemberJoinController {

    private final MemberJoinValidator validator;

    private final MemberJoinService service;

    @GetMapping
    public String join(Model model) {

        MemberJoin memberJoin = new MemberJoin();
        model.addAttribute("memberJoin", memberJoin);
        return "member/join";
    }

    @PostMapping
    public String joinPs(@Valid MemberJoin memberJoin, Errors errors) {

        validator.validate(memberJoin, errors);

        if (errors.hasErrors()) {
            return "member/join";
        }

        service.join(memberJoin);

        return "redirect:/member/login";
    }
}
