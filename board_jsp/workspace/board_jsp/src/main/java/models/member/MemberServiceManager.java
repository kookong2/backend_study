package models.member;
public class MemberServiceManager {
	
	private static MemberServiceManager instance;
	
	private MemberServiceManager() {}
	
	public static MemberServiceManager getInstance() {
		if(instance==null) {
			instance=new MemberServiceManager();
		}
		return instance;
	}
	
	public MemberDao memberDao() {
		return new MemberDao();
	}
	
	/**
	 * 회원가입
	 * @return
	 */
	public MemberJoinService getMemberJoinService() {
		MemberJoinService joinservice=new MemberJoinService(memberDao());
		joinservice.setJoinValidator(new MemberJoinValidator(memberDao()));
		return joinservice;
	}
	
	/** 
	 * 로그인 처리 
	 * @return
	 */
	public MemberLoginService getMemberLoginService() {
		MemberLoginValidator validator=new MemberLoginValidator(memberDao());
		return new MemberLoginService(memberDao(), validator);
	}
	
	
}

