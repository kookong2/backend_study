package controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import commons.Libary;
import models.KanbanDao;
import models.service.AddService;

@WebServlet("/kanban")
public class KanbanController extends HttpServlet {

	/**
	 * 일정 등록 처리 
	 * 
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			AddService service = new AddService(new KanbanDao());
			service.add(req);
		} catch (RuntimeException e) {
			Libary.alertError(resp, e);
		}
	}
	
	/**
	 * 일정 수정 처리 
	 * 
	 */
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	}
	
	/**
	 * 일정 삭제 처리 
	 * 
	 */
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
