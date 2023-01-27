package day03;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/action2")
public class ActionIncludeServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html; charset=utf-8");
		
		RequestDispatcher rd1 = req.getRequestDispatcher("header.jsp");
		rd1.include(req, resp);
		
		RequestDispatcher rd2 = req.getRequestDispatcher("ex06.jsp");
		rd2.include(req, resp);
		
		RequestDispatcher rd3 = req.getRequestDispatcher("footer.jsp");
		rd3.include(req, resp);
		
		
		
	}
	
}
