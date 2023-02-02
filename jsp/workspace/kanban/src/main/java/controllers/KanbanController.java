package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.jni.Library;

import commons.Libary;
import models.CachedKanbanDao;
import models.KanbanDao;
import models.service.AddService;
import models.service.DeleteService;
import models.service.EditService;
import models.service.ServiceManager;

@WebServlet("/kanban")
public class KanbanController extends HttpServlet{

	/**
	 * 일정 등록 처리
	 * 
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			req.setCharacterEncoding("UTF-8");
			AddService service = ServiceManager.getInstance().getAddService();
			service.add(req);
			
			Libary.reload(resp,"parent");
			
		}catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * 일정 수정 처리
	 * 
	 */
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			req.setCharacterEncoding("UTF-8");
			EditService service = ServiceManager.getInstance().getEditService();
			service.edit(req);
			
		} catch (RuntimeException e) {
			Libary.alertError(resp,e);
		}
	}
	
	/**
	 * 일정 삭제 처리
	 * 
	 */
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			DeleteService service = ServiceManager.getInstance().getDeleteService();
			service.delete(req);
		} catch (RuntimeException e) {
			Libary.alertError(resp, e);
		}
	}
	
}
