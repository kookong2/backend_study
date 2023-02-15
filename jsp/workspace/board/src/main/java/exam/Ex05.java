package exam;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import config.MyConnection;
import models.member.Member;

public class Ex05 {

	public static void main(String[] args) {
		SqlSession session= MyConnection.getSession();
		Member params= new Member();
		params.setUserId("user01");
		params.setUserNm("%용자%");
		params.setMobile("%00%");
		
		List<Member> members=session.selectList("MemberMapper.members",params);
		
		for(Member member:members) {
			System.out.println(member);
		}
	}
}
