<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*" %>
<c:set var="date" value="<%= new Date()%>"/>
<fmt:formatDate type="date" value="${date}" dateStyle="full"/>
<br>
<fmt:formatDate type="time" value="${date}" dateStyle="full"/>
<br>
<fmt:formatDate type="both" value="${date}" pattern="yyyy.MM.dd HH.mm E"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>