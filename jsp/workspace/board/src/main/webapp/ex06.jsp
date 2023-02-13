<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.*" %>
<%
	//Cookie cookie = new Cookie("key2","value2");
	// 쿠키 만료시간
	//cookie.setMaxAge(60 * 60 * 24 * 7);
	
	// 쿠키 저장공간 설정
	//cookie.setPath("/board/test");
	//response.addCookie(cookie);
	
	Cookie[] cookies = request.getCookies();
	for(Cookie cookie : cookies){
		//System.out.printf("%s=%s%n", cookie.getName(), cookie.getValue());
		
		String name = cookie.getName();
		if(name.indexOf("key") != -1){
			cookie.setMaxAge(0);	// 만료시간 0 -> 브라우저가 삭제
			response.addCookie(cookie);
		}
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
</body>
</html>