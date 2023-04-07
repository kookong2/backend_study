package org.koreait.controllers.members;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member/join")
public class MemberJoinController {
    @GetMapping
    public String join(Model model){
        MemberJoin memberJoin = new MemberJoin();
        model.addAttribute("memberJoin",memberJoin);
        return "member/join";
        
    }

    @PostMapping
    public String joinPs(@Valid MemberJoin memberJoin, Errors errors){

        if(errors.hasErrors()){
            return "member/join";
        }

        return "redirect:/member/login";
    }

}
