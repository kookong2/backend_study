package commons;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

/**
 * 공통 메세지(자바스크립트) 관련
 * 
 *
 */
public class MessageLibrary {
	
	/**
	 * 에러 전용 alert
	 * 
	 * @param {Exception} e
	 * @param e
	 */
	public static void alertError(HttpServletResponse response, Exception e) {
		try {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			String message = e.getMessage();
			
			out.printf("<script>alert('%s');</script>", message);
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
	
	/**
	 *  페이지 이동
	 * 
	 * @param response
	 * @param url
	 * @param target
	 */
	public static void go(HttpServletResponse response, String url, String target) {
		try {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			
			target = target == null ? "self" : target;
			out.printf("<script>%s.location.replace('%s');</script>", target, url);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void go(HttpServletResponse response, String url) {
		go(response, url, "self");
	}
}
