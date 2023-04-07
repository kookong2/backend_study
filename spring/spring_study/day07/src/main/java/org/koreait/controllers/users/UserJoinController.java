package org.koreait.controllers.users;

import javax.validation.Valid;

import org.koreait.models.member.Member;
import org.koreait.models.member.UserJoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user/join")
public class UserJoinController {
	
	private UserJoinValidator validator;
	private UserJoinService service;
	
	public UserJoinController(UserJoinService service) {
		this.service = service;
	}
	
	// HTML 폼 코드를 보면 전송 방식을 POST로 지정, 주로 폼을 전송할 때
	// POST 방식을 사용하는데, 스프링 MVC는 별도 설정이 없으면 GET과 POST
	// 방식에 상관없이 @RequestMapping 에 지정한 경로와 일치하는 요청을 처리
	// 		-> POST 방식 요청만 처리하고 싶다면 @PostMapping 어노테이션을 사용
	
	
	@GetMapping
	public String join(Model model) {
		
		MemberJoin memberJoin = new MemberJoin();
		model.addAttribute("title", "abc");
		model.addAttribute("memberJoin", memberJoin);
		
		return "user/join";
	}
	
	// <form:form> 태그를 사용하려면 커맨드 객체가 존재해야한다.
	// join.jsp에서 <form:form> 태그를 사용하기 떄문에 
	@PostMapping
	public String joinPs(@Valid MemberJoin memberJoin, Errors errors) {
		validator.validate(memberJoin, errors);
		if (errors.hasErrors()) {
			return "user/join";
		}
		
		try {
			Member member = new Member();
			member.setUserId(memberJoin.getUserId());
			member.setUserPw(memberJoin.getUserPw());
			member.setUserNm(memberJoin.getUserNm());
			member.setEmail(memberJoin.getEmail());
			member.setMobile(memberJoin.getMobile());
			
			
			service.join(member);
			
		}catch(RuntimeException e) {
			errors.reject("joinError", e.getMessage());
			return "user/join";
		}
		
		// 회원가입 성공
		// "redirect:" 뒤의 문자열이 "/'로 시작하면 웹 어플리케이션을 기준으로
		// 이동 경로를 생성
		return "redirect:/user/login";
	}
	
	
	@Autowired
	public void setValidator(UserJoinValidator validator) {
		this.validator = validator;
	}
}
