<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="age" value="22" />
<c:choose>
	<c:when test="${ age < 8}">
		<h2>유치원!</h2>
	</c:when>
	<c:when test="${age < 14 }">
		<h2>초등학교!</h2>
	</c:when>
	<c:when test="${age < 17 }">
		<h2>중학생</h2>
	</c:when>
	<c:when test="${age < 20}">
		<h2>고등학생</h2>
	</c:when>
	<c:otherwise>
		<h2>성인!</h2>
	</c:otherwise>
</c:choose>