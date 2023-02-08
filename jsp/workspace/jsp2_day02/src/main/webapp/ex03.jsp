<%@page import="org.apache.naming.java.javaURLContextFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="date" value="<%= new java.util.Date() %>"/>
<fmt:setTimeZone value="America/New_York"/>
<fmt:formatDate value="${date}" type="both"/>	

<br>

<fmt:setTimeZone value="Asia/Hong_Kong"/>
<fmt:formatDate value="${date}" type="both"/>	

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
</body>
</html>