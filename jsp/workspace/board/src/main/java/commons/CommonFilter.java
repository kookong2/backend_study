package commons;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;

public class CommonFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		CommonRequestWrapper _request=new CommonRequestWrapper((HttpServletRequest)request);
		CommonResponseWrapper _response = new CommonResponseWrapper((HttpServletResponse)response);
		chain.doFilter(_request,_response);
	}
}
		
		

	


