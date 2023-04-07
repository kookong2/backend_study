package models.board;

import java.util.List;

import commons.db.query.QueryExecutor;

public class BoardConfigDao {

	private QueryExecutor qe; 
	
	public BoardConfigDao(QueryExecutor qe) {
		this.qe=qe;
	}
	
	// 게시글 설정 목록 
	// 게시글을 설정 목록을 리스트로 뽑아내는 것 
	public List<BoardConfig> gets(BoardConfig boardConfig){
		List<BoardConfig> configs = qe.query(boardConfig,"BoardCongiMapper.configs");
		
		return configs; 
	}
	
	// 
	public List<BoardConfig> gets() {
		List<BoardConfig> configs = qe.query("BoardConfigMapper.configs");
		return configs;
	}
	
	/**
	 * id( 게시판 등록 하는 id) 로 게시판 설정 조회
	 * @param id
	 * @return
	 */
	public BoardConfig get(String id) {
		BoardConfig params =new BoardConfig();
		params.setId(id);
		
		BoardConfig config = qe.queryOne(params,"BoardConfigMapper.config");
		return config;
	}
	
	/**
	 * 게시판 설정 하나씩 조회
	 * @param boardConfig
	 * @return
	 */
	public boolean save(BoardConfig boardConfig) {
		int cnt=qe.queryOne(boardConfig, "BoardConfigMapper.count");
		int result=0;
		// 
		if(cnt>0) {
			result = qe.update(boardConfig,"BoardConfigMapper.configs");
		}else { // 게시판 설정이 따로 없으므로
			result=qe.insert(boardConfig,"BoardConfigMapper.insert");
		}
		return result>0;
	}
	
	/**
	 * id로 쿼리로 delete 실행 
	 * 아이디로 게시판 삭제 
	 * @param id
	 * @return
	 */
	public boolean delete(String id) {
		BoardConfig params = new BoardConfig();
		params.setId(id);
		int result = qe.delete(params,"BoardConfigMapper.delete");
		
		return result>0;
		
		
	}
	
	
	
	
	
}
