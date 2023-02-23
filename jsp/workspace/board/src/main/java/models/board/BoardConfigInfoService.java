package models.board;

import commons.validator.Validator;

public class BoardConfigInfoService {
	private BoardConfigDao boardConfigDao;
	private Validator<BoardConfig> validator;
	
	public BoardConfigInfoService(BoardConfigDao boardConfigDao, Validator<BoardConfig> validator) {
		this.boardConfigDao = boardConfigDao;
		this.validator = validator;
	}
}
