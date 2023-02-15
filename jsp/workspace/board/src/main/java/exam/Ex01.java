package exam;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.net.SyslogAppender;

import config.MyConnection;
import models.member.Member;
// 등록
public class Ex01 {

	public static void main(String[] args) {
		SqlSession session= MyConnection.getSession();
		Member member= new Member();
		member.setUserId("user01");
		member.setUserPw("123456");
		member.setUserNm("사용자01");
		member.setMobile("0000");
		
		int cnt = session.insert("MemberMapper.insert",member);
		
		session.commit();
		System.out.println(cnt);
		System.out.printf("userNo=%d%n",member.getUserNo());
	}
}
