package jsp2_day01.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Exam01Servlet extends HttpServlet {
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		//String t1 = config.getInitParameter("t1");
		//String t2 = config.getInitParameter("t2");
		//System.out.printf("t1=%s, t2=%s %n", t1, t2);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//ServletConfig config = getServletConfig();
		//String t1 = config.getInitParameter("t1");
		//String t2 = config.getInitParameter("t2");
		//System.out.printf("t1=%s, t2=%s %n", t1, t2);
		RequestDispatcher rd = req.getRequestDispatcher("ex04.jsp");
		rd.forward(req, resp);
	}
}
