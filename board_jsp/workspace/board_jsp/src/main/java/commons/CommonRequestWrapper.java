package commons;

import javax.servlet.http.HttpServletRequest;
import commons.library.*;
import javax.servlet.http.HttpServletRequestWrapper;

public class CommonRequestWrapper extends HttpServletRequestWrapper{

	public CommonRequestWrapper(HttpServletRequest request) {
		super(request);
		

		String method = request.getMethod().toUpperCase();
		if (method.equals("POST")) {
			try {
				// POST일 때 한글깨짐 방지 처리                                                                                                                                                                                                                     
				request.setCharacterEncoding("UTF-8");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		//로그인 상태
		request.setAttribute("isLogin",MemberLibrary.isLogin(request));
		
		
	}

}
