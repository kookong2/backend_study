<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	// 범위가 제일 좁은 pageContext에 num이 들어감
	pageContext.setAttribute("num", 100);
	request.setAttribute("num", 200);
	application.setAttribute("num", 300);
%>
<!--
<c:set var="num" value="100" scope="request"/>
  -->
<!--
<c:remove var="num" scope="page"/>
  -->
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		${num}<br>
		page - ${pageScope.num}<br>
		request - ${requestScope.num}<br>
		application - ${applicationScope.num}
	</body>
</html>