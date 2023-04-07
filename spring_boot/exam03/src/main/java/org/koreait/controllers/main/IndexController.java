package org.koreait.controllers.main;

import org.koreait.entities.BoardData;
import org.koreait.models.member.MemberDetails;
import org.koreait.repositories.BoardDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {
    @Autowired
    private BoardDataRepository repository;

    @GetMapping("/")
    public String index(@AuthenticationPrincipal MemberDetails memberDetails, Model model) {
        model.addAttribute("member", memberDetails);

        return "main/index";
    }

    @ResponseBody
    @GetMapping("/exam/ex01")
    public void exam01() {
        BoardData data = BoardData.builder()
                .subject("제목!")
                .content("내용!")
                .build();

        repository.save(data);
    }

    @ResponseBody
    @GetMapping("/exam/ex02")
    public void exam02() {
        BoardData data = repository.findById(102L).orElse(null);
        data.setSubject("제목(수정)");
        repository.save(data);
    }
}
