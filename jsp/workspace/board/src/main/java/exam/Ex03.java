package exam;

import org.apache.ibatis.session.SqlSession;

import config.MyConnection;
import models.member.Member;

public class Ex03 {

	public static void main(String[] args) {
		SqlSession session = MyConnection.getSession();
		Member params = new Member();
		params.setUserId("user01");
		
		int cnt = session.delete("MemberMapper.delete",params);
		session.commit(); //sql에 이 정보를 업데이트 시킴
		System.out.println(cnt);
	}
}
