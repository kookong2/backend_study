package controllers.members;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import models.member.Member;
import models.member.MemberJoinService;

// /member/join - get - 양식, post - 회원가입 
@Controller
@RequestMapping("/member/join")
public class MemberJoinController {
	
	@Autowired
	private MemberJoinValidator validator;
	
	@Autowired
	private MemberJoinService service;
	
	@GetMapping
	public String join(Model model) {
		
		Member member = new Member();
		model.addAttribute("member", member);
		model.addAttribute("siteTitle", "회원가입");
		
		return "member/join";
	}
	
	@PostMapping
	public String joinPs(@Valid Member member , Errors errors, Model model) {
		
		model.addAttribute("siteTitle", "회원가입");
		
		try {
			service.process(member, errors);
		} catch (RuntimeException e) {
			e.printStackTrace();
			String message = e.getMessage();
			// Bean Validation, Validator에서 발생한 예외가 아닐때
			if (!message.equals("common")) { 
				 errors.reject("memberJoinFail", message);
			}
		}
		
		if (errors.hasErrors()) { // 에러 있을 경우는 가입 양식에 오류 메세지 출력 
			return "member/join";
		}
		
		// 회원 가입 성공
		return "redirect:/member/login";
	}
}
