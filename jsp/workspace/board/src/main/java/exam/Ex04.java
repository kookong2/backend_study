package exam;

import org.apache.ibatis.session.SqlSession;

import config.MyConnection;
import models.member.Member;

public class Ex04 {

	public static void main(String[] args) {
		SqlSession session=MyConnection.getSession();
		Member member = new Member();
		member.setUserId("user01");
		member.setUserNm("(변경)사용자01");
		
		int cnt = session.update("MemberMapper.update",member);
		session.commit();
	}

}
