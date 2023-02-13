package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import commons.Library;
import models.member.Member;
import models.member.MemberType;

@Component
public class AdminOnlyInterceptor implements HandlerInterceptor {
	
	@Autowired
	private Library library;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		Member member = library.getMember();
		// 비회원이거나 회원 userType이 관리자가 아닐때 
		if (!library.isLogin() || member.getUserType() != MemberType.ADMIN) {
			String url = request.getContextPath() + "/member/login";
			response.sendRedirect(url);
			return false;
		}
		
		return true;
	}
	
}
