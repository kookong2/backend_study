package commons;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class CommonRequestWrapper extends HttpServletRequestWrapper{

	public CommonRequestWrapper(HttpServletRequest request) {
		super(request);
		
		String method = request.getMethod().toUpperCase();
		if(method.equals("POST")) {
			// POST일 때 한글 깨짐 방지 처리
			try {
				request.setCharacterEncoding("UTF-8");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public String getParameter(String name) {
		
		String value = super.getParameter(name);
		
		return value.toUpperCase();
	}
	
}
