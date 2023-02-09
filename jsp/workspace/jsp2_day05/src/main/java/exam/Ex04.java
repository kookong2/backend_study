package exam;

import org.apache.ibatis.session.SqlSession;

import config.MybatisConnection;
import models.member.Member;

public class Ex04 {
	public static void main(String[] args) {
		
		SqlSession sqlSession = MybatisConnection.getSession();
		Member member = new Member();
		member.setUserId("user08");
		member.setUserPw("12345");
		member.setUserNm("고길동");
		member.setMobile("01023321414");
		
		int cnt = sqlSession.insert("MemberMapper.insert",member);
		sqlSession.commit();
		System.err.printf("userNo = %d%n",member.getUserNo());
	}
}
