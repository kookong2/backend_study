package org.koreait.member;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

@Service
public class MemberListService {
	
	@Autowired
	MemberDao memberDao = new MemberDao();
	
	private DateTimeFormatter formatter;
	
	
	public MemberListService( ) {}
	
	public MemberListService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public List<Member> gets() {
		List<Member> members = memberDao.getMembers();
		for (Member member : members) {
			if (formatter == null) {
				member.setRegDtStr(member.getRegDt().toString());
			} else {
				member.setRegDtStr(formatter.format(member.getRegDt()));
			}
		}
		
		return members;
	}
	
	//@Autowired(required=false)
	@Autowired
	public void setDateTimeFormatter(@Nullable DateTimeFormatter formatter) {
		this.formatter = formatter;
	}
}