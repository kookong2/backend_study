package commons;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class Libary {
	
	public static void alertError(HttpServletResponse response, Exception e) throws IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.printf("<script>alert('%s');</script>", e.getMessage());
	}
}
