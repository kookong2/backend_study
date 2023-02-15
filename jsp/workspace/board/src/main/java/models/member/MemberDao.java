package models.member;

import commons.db.QueryExecutor;

/**
 * @author LG
 * MemberDAO(Date Access Object)
 * 데이터 접근 할 수 있는 기능 
 */
public class MemberDao {
	
	private QueryExecutor qe;
	
	public MemberDao() {
		qe = new QueryExecutor();
	}

	/**
	 * 회원정보 DB 추가
	 * @param {Member}member: 회원가입 정보
	 * @return {boolean}
	 */
	public boolean register(Member member) {
		int cnt = qe.insert(member,"MemberMapper.insert");
		return cnt > 0;
	}
	/**
	 * 회원정보 수정
	 * @param member
	 * @return
	 */
	public boolean update(Member member) {
		
		int cnt = qe.update(member, "MemberMapper.update");
		return false;
	}
	
	/**
	 * 회원 정보 삭제
	 * @param member
	 * @return
	 */
	public boolean delete(Member member) {
		int cnt = qe.delete(member,"MemberMapper.delete");
		return false;
	}
	
	/**
	 * 회원정보를 아이디로 조회
	 * @param useId
	 * @return
	 */
	public Member get(String userId) {
		
		Member params=new Member();
		params.setUserId(userId);
		
		Member member= qe.queryOne(params,"MemberMapper.member");
		
		return member;
	}
	
	/**
	 * 회원 등록 여부 체크
	 * 
	 * @param userId
	 * @return
	 */
	public boolean isExists(String userId) {
		Member params = new Member();
		params.setUserId(userId);
		
		int cnt = qe.count(params, "MemberMapper.count");
		
		return cnt > 0;
	}
	
}
