<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	pageContext.setAttribute("name", "이름1");
	request.setAttribute("name", "이름2");
	application.setAttribute("name", "이름3");
%>
<c:remove var="name" scope="application" />

${pageScope.name}<br>
${requestScope.name}<br>
${applicationScope.name}<br>