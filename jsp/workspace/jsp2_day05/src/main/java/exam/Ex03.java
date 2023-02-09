package exam;

import org.apache.ibatis.session.SqlSession;

import config.MybatisConnection;
import models.member.Member;

public class Ex03 {
	public static void main(String[] args) {
		SqlSession sqlSession = MybatisConnection.getSession();
		Member params = new Member();
		params.setUserId("user01");
		Member member = sqlSession.selectOne("MemberMapper.get",params);
		System.out.println("======= 변경전 ========");
		System.out.println(member);
		
		System.out.println("======= 변경후 ========");
		
		// 수정
		/**
			member.setUserNm("(변경)사용자01일까요?");
			sqlSession.update("MemberMapper.update",member);
			sqlSession.commit();
			member = sqlSession.selectOne("MemberMapper.get",params);
			System.out.println(member);
		 */
		
		// 삭제
		params.setUserNo(member.getUserNo());
		int cnt = sqlSession.delete("MemberMapper.delete",params);
		sqlSession.commit();
		System.out.println(cnt);
		
		
	}
}
