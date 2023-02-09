package controlls;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.compiler.NewlineReductionServletWriter;

@WebServlet("/test")
public class TestController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setAttribute("addCss", new String[] {"testcss1","testcss2"});
		req.setAttribute("addScript", new String[] {"testjs1","testjs2"});
		
		RequestDispatcher rd = req.getRequestDispatcher("test.jsp");
		rd.forward(req, resp);
	}
	
		
	
}
