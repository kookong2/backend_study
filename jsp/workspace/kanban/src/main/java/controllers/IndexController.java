package controllers;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import commons.Status;
import models.Kanban;
import models.service.ListService;
import models.service.ServiceManager;

@WebServlet("/index.jsp")
public class IndexController extends HttpServlet {

	/**
	 * 
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ListService service = ServiceManager.getInstance().getListService();
		
		Map<Status, List<Kanban>> kanbans = service.gets();
		req.setAttribute("kanbans", kanbans);
		
		// RequestDispatcer를 통해 controller를 index.jsp와 연동
		RequestDispatcher rd = req.getRequestDispatcher("main/index.jsp");
		rd.forward(req, resp);
	}
	
}
