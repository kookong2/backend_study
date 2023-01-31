<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setAttribute("key1", "값1");
	String value = (String)request.getAttribute("key1");
	out.write(value);
	
	application.setAttribute("key2", "값2");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${key1}</h1> 
	<h1>${key2}</h1> 
</body>
</html>