package controllers.members;

import java.io.IOException;
import static commons.MessageLibrary.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.member.MemberJoinService;
import models.member.MemberServiceManager;

@WebServlet("/member/join")
public class MemberJoinController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[] addCss= {"testcss1","test/testcss2"};
		req.setAttribute("addCss", addCss);
		
		String[] addScript = {"testjs1","test/testjs2"};
		req.setAttribute("addScript", addScript);
		
		RequestDispatcher rd=req.getRequestDispatcher("/member/join.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			MemberServiceManager serviceManager = MemberServiceManager.getInstance();
			MemberJoinService service = serviceManager.getMemberJoinService();
			service.doJoin(req);
			
			// 성공 -> 로그인 페이지로 이동 req.getContextPath() -> /board
			String url = req.getContextPath() + "/member/login";
			go(resp, url,"parent");
			
			
		}catch(RuntimeException e) {
			
			e.printStackTrace();
			
			// 회원가입 실패, 오류 -> 자바스크립트 alert 메세지로 출력
			alertError(resp, e);
			
			
		}
	}
	
	
}
