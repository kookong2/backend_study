package commons;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;


public class FilterEx1 implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		//필터의 요청 공통기능 
		FilterRequestWrapper requestWrapper = new FilterRequestWrapper((HttpServletRequest)request);
		
		System.out.println("필터 Ex01");
		
		//doFilter => chain을 걸어줘야 출력이 됨. chain을 작성하지 않으면 아예 출력x
		// 그러나, 작성해서 넘어가는 필터가 있으면 넘기고 없으면 서블릿으로 넘겨서 출력시킴. 
		chain.doFilter(requestWrapper, response);
		
		System.out.println("필터 Ex01--");
	}
	
}