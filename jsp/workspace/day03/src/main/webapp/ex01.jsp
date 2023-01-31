<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.time.LocalDateTime"%>
<%@ page info="자바 JSP 연습!" %>
<%@ page errorPage = "ex01.error.jsp" %>
<%
	LocalDateTime now = LocalDateTime.now();
	out.print(now);
	
	String info = this.getServletInfo();
	out.print("<br>");
	out.print(info);
	
	// 에러페이지 유발을 위한 것
	//String str = null;
	//str.toUpperCase();
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