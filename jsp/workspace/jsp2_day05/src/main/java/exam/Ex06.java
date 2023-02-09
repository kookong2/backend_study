package exam;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import config.MybatisConnection;
import models.member.Member;

public class Ex06 {
	public static void main(String[] args) {
		SqlSession sqlSession = MybatisConnection.getSession();
		Member member = new Member();
		
		//member.setUserNm("%사용자%");
		//member.setUserId("%user%");
		
		
		List<Member> members = sqlSession.selectList("MemberMapper.getMembers",member);
		
		for(Member mem : members) {
			
			System.out.println(mem);
		}
	}
}
