<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.*" %>
<%
	Cookie[] cookies = request.getCookies();
	for(Cookie cookie : cookies){
		String name = cookie.getName();
		String value = cookie.getValue();
		out.print("name = " + name + ", value = " + value + "<br>");
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