<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:catch var="e">
	<%
		int num = 10 / 0;
	%>
</c:catch>
<c:if test="${ ! empty e }">
	${e.message}
</c:if>