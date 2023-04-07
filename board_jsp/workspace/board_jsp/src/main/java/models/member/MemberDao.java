package models.member;

import commons.db.query.QueryExecutor;

/**
 * Member를 가져와, db에서 데이터에 직접 접근할 수 있음 
 * -> 각 메서드의 매개변수  -> QueryExecutor
 * @author LG
 *
 */
public class MemberDao {
	
	private QueryExecutor qe;
	
	public MemberDao() {
		qe = new QueryExecutor();
	}
	
	/**
	 * 회원 정보 DB 추가
	 * @param member
	 * @return
	 */
	public boolean register(Member member) {
		int cnt=qe.insert(member,"MemberMapper.insert");
		return cnt>0;
	}
	
	/** 
	 * 회원 정보 DB 수정
	 * @param member
	 * @return
	 */
	public boolean update(Member member) {
		int cnt = qe.update(member,"MemberMapper.update");
		return false;
	}
	
	/**
	 * 회원 정보 DB 삭제 
	 * @param member
	 * @return
	 */
	public boolean delete(Member member) {
		int cnt =qe.delete(member, "MemberMapper.delete");
		return cnt>0;
	}
	
	/**
	 * useId로 회원 정보 조회
	 * @param userId
	 * @return
	 */
	public Member get(String userId) {
		Member params = new Member();
		params.setUserId(userId);
		Member member= qe.queryOne(params,"MemberMapper.member");
		return member;
	}

	/**
	 * userId로 회원 등록 여부 체크
	 * @param userId
	 * @return
	 */
	public boolean isExists(String userId) {
		Member params=new Member();
		params.setUserId(userId);
		int cnt = qe.count(params, "MemberMapper.count");
		return cnt>0;
	}
	
	

}
