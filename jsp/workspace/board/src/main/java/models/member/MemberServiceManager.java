package models.member;

/**
 * 회원 관련 서비스 객체 관리 
 * @author LG
 *
 */
public class MemberServiceManager {

	private static MemberServiceManager instance=null;
	
	private MemberServiceManager() {}
	
	public MemberDao memberDao() { 
		return new MemberDao();
	}
	/**
	 * 회원가입
	 * @return
	 */
	public MemberJoinService getMemberJoinService() {
		
		MemberJoinService service= new MemberJoinService(memberDao());
		service.setValidator(new MemberJoinValidator(memberDao()));
		return service;
	}
	
	/**로그인서비스
	 * 
	 * @return
	 */
	public MemberLoginService getMemberLoginService() {
		MemberLoginValidator validator = new MemberLoginValidator(memberDao());
		return new MemberLoginService(memberDao(), validator);
	}
	
	public static MemberServiceManager getInstance() {
		if(instance==null) {
			instance=new MemberServiceManager();
			}
		return instance;
	}
}
