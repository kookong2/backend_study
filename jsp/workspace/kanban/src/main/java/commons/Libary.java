package commons;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Libary {
	
	public static void alertError(HttpServletResponse response, Exception e) throws IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.printf("<script>alert('%s');</script>", e.getMessage());
	}
	
	// 등록 (getWiter()) 했을 때,
	// 스크립트에 새로고침 소스 추가
	public static void reload(HttpServletResponse response, String target) throws IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.printf("<script>%s.location.reload();</script>", target);
	}
	
	// 부모 창을 새로 고침하게 만듦
	public static void reload(HttpServletResponse response) throws IOException{
		reload(response,"self");
	}
}
