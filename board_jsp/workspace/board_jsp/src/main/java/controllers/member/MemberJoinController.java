package controllers.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import commons.library.UrlLibrary;
import models.member.MemberJoinService;
import models.member.MemberServiceManager;

import static commons.library.MessageLibrary.*;

@WebServlet("/member/join")
public class MemberJoinController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//jsp
		RequestDispatcher rd = req.getRequestDispatcher("/member/join.jsp");
		rd.forward(req, resp);
	
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
		MemberServiceManager manager= MemberServiceManager.getInstance();
		MemberJoinService service =manager.getMemberJoinService();
		
		//회원가입 성공
		service.doJoin(req);
		
		//페이지 이동 : 성공시 -> 로그인페이지로 이동 req.getContextPath() => board
		// // String url = req.getContextPath()+"/member/login"; => 자주사용 class로 따로 뺴서 만듦
		go(resp,UrlLibrary.getURL(req, "/member/login"),"parent");
		
		}catch(RuntimeException e) {
			e.printStackTrace();
		
			alertError(resp,e);
			
		}
	
	}

}
