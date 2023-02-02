package models.service;

import javax.servlet.http.HttpServletRequest;

import models.Kanban;
import models.KanbanDao;

public class InfoService {
	private KanbanDao dao;

	public InfoService(KanbanDao dao) {
		this.dao = dao;
	}
	
	public Kanban get(HttpServletRequest request) {
		
		String _id = request.getParameter("id");
		if(_id == null || _id.isBlank()) {
			throw new RuntimeException("잘못된 접근 입니다.");
		}
		
		int id = Integer.parseInt(_id);
		Kanban kanban = dao.get(id);
		if(kanban == null) {
			throw new RuntimeException("작업 내용이 없습니다.");
		}
		
		return kanban;
	}
}
