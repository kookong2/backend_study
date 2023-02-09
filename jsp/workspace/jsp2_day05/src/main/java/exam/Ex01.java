package exam;


import org.apache.ibatis.session.SqlSession;

import config.MybatisConnection;
import models.member.Member;

public class Ex01 {
	public static void main(String[] args) {
		
		SqlSession sqlSession = MybatisConnection.getSession();
		Member member = new Member();
		member.setUserId("user03");
		member.setUserNm("사용자03");
		member.setUserPw("123456");
		member.setMobile("01012345649");
		
		int cnt = sqlSession.insert("MemberMapper.insert",member);
		sqlSession.commit();	//트랜잭션
		System.out.println(cnt);
		
	}
}
