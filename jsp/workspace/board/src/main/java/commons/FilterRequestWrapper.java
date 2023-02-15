package commons;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class FilterRequestWrapper  extends HttpServletRequestWrapper{

	public FilterRequestWrapper(HttpServletRequest request) {
		super(request);
		
		//POST메서드-> 인코드 UTF-8
		String method= request.getMethod().toUpperCase();
		if(method.equals("POST")) {
			try {
				request.setCharacterEncoding("UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public String getParameter(String name) {
		String value = super.getParameter(name);
		value=value.toUpperCase();
		return value;
		
	}

}
