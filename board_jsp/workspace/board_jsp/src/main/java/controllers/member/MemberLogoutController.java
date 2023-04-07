package controllers.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import commons.library.UrlLibrary;

@WebServlet("/member/logout")
public class MemberLogoutController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 세션에 있는 값 삭제 
		
		
		// 세션 값 가져오기
		HttpSession session = req.getSession();
		session.invalidate(); //세션 삭제
		
		// 로그아웃 후 -> 메인페이지 (임시 로그인) 
		resp.sendRedirect(UrlLibrary.getURL(req,"/member/login"));
	}
}
