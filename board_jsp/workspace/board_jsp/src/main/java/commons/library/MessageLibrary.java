package commons.library;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MessageLibrary {

	/**
	 * 오류 메세지 출력
	 * @param response
	 * @param e
	 */
	public static void alertError(HttpServletResponse response,Exception e) {
		try {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			String message = e.getMessage();
			out.printf("<script>alert(%s);</script>",message);
		
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
	//오류 메세지 오버로딩
	public static void alertError(HttpServletResponse response, Exception e, String after) {
		alertError(response,e);
		
		if(after.equals("back")) { //다시 앞으로 즉, history.back(-1) : 이전 페이지로 이동하는 것 
			go(response,-1);
		}
	}
	
	/**
	 * 현재 페이지(target)에서 넘어갈 페이지(url) 
	 * 
	 * 회원가입->로그인 등 이외에도 페이지 이동이 필요할 시 이 메서드 사용
	 * @param response
	 * @param url
	 * @param target
	 */
	public static void go(HttpServletResponse response, String url, String target) {
		try {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out=response.getWriter();
			
			target=target==null?"self":target;
// HEAD
			out.printf("<script>%s.location.replace('%s');</script>",target,url);

			out.printf("<script>%s.location.replace(%s);</script>",target,url);
//  b784b7dea644576cdb193e00df55dc8ecb954037
		}catch(Exception e1) {
			e1.printStackTrace();
		}
	}
	
	/**
	 * 페이지 이동 오버로딩
	 * 
	 * 이전 페이지로 넘어갈때 주로 사용. 
	 * 접속권한 없는 페이지 들어갔을때 다시 되돌아갈 페이지 
	 * ex) 회원 권한 -> 관리자페이지 클릭
	 * @param response
	 * @param step
	 * @param target
	 */
	public static void go(HttpServletResponse response, int step, String target) {
		try {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out =response.getWriter();
			
			target=target==null?"self":target;
			out.printf("<script> %s.history.go(%d); </script>",target,step);
		}catch(Exception e1) {
			e1.printStackTrace();
		}
	}
	
	/**
	 * 자기 자신 페이지로 돌아갈때  
	 * 오류뜨거나 하면, 오류 메세지를 출력한 후, 자신의 페이지에 남아있어야 함. 
	 * @param response
	 * @param step
	 */
	public static void go(HttpServletResponse response, int step) {
		go(response,step,"self");
	}
}
