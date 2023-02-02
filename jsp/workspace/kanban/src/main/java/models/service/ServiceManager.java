package models.service;

import models.KanbanDao;

public class ServiceManager {
	
	// 싱글톤 패턴
	private static ServiceManager instance;
	
	private ServiceManager() {}
	
	
	public KanbanDao kanbanDao() {
		return new KanbanDao();
	}
	
	public AddService getAddService() {
		
		return new AddService(kanbanDao());
	}
	
	public EditService getEditService() {
		return new EditService(kanbanDao());
	}
	
	public DeleteService getDeleteService() {
		return new DeleteService(kanbanDao());
	}
	
	public ListService getListService() {
		return new ListService(kanbanDao());
	}
	
	public InfoService getInfoService() {
		return new InfoService(kanbanDao());
	}
	
	// 싱글톤 패턴
	public static ServiceManager getInstance() {
		if(instance == null) {
			instance = new ServiceManager();
		}
		
		return instance;
	}
}
