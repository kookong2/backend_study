package controllers.members;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import models.member.MemberLoginService;

@Controller   // /member/login  - get : 양식, post : 로그인 처리 
@RequestMapping("/member/login")
public class MemberLoginController {
	
	@Autowired
	private MemberLoginService service;
	
	@GetMapping
	public String login(Model model) {
		
		LoginCommand loginCommand = new LoginCommand();
		model.addAttribute("loginCommand", loginCommand);
		model.addAttribute("siteTitle", "로그인");
		
		return "member/login";
	}
	
	@PostMapping
	public String loginPs(@Valid LoginCommand loginCommand, Errors errors, Model model) {
		model.addAttribute("siteTitle", "로그인");
		
		if (errors.hasErrors()) {
			return "member/login";
		}
		
		try {
			service.process(loginCommand);
			
		} catch (RuntimeException e) {
			e.printStackTrace();
			
			errors.reject("loginFail", e.getMessage());
			
			return "member/login";
		}
		
		return "redirect:/"; // 로그인 완료 후 메인페이지 이동...
	}
}