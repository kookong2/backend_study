package commons.library;

import javax.servlet.http.HttpServletRequest;

public class UrlLibrary {
	
	/**
	 * URL 자동완성
	 * @param request
	 * @param url
	 * @return
	 */
	public static String getURL(HttpServletRequest request, String url) {
		
		url=url==null?"":url;
		return request.getContextPath()+url;
	}
	
	/**
	 * getURL 오버로딩
	 * 
	 * @param request
	 * @return
	 */
	public static String getURL(HttpServletRequest request) {
		return getURL(request,null);
	}

}
