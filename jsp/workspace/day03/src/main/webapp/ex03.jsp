<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="num" value="10"/>
<c:if test="${num==10}">
	10이 맞습니다.
	<br>
</c:if>
<c:forEach var="n" begin="1" end="10" step="2">
	${n}<br>
</c:forEach>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>