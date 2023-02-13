package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import commons.Library;

@Component
public class MemberOnlyInterceptor implements HandlerInterceptor {

	@Autowired
	private Library library;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		// 회원전용 페이지를 접근했을때 미로그인 상태일때 
		// HttpServletResponse : sendRedirect -> 페이지 이동 
		// HttpServletRequest : getContextPath() 
		if (!library.isLogin()) {
			// 로그인 페이지로 이동 
			String url = request.getContextPath() + "/member/login";
			response.sendRedirect(url);
			return false;
		}
		
		return true;
	}
	
}
