package exam;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import config.MybatisConnection;
import models.member.Member;

public class Ex02 {
	public static void main(String[] args) {
		SqlSession sqlSession = MybatisConnection.getSession();
		List<Member> members = sqlSession.selectList("MemberMapper.getMembers", Member.class);
		for(Member member : members) {
			System.out.println(members);			
		}
	}
}
