<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	int num1 = 100;
	int num2 = 200;
%>
<c:set var="num1" value="100" scope="application" />
<c:set var="num2" value="${num1 + 200}" /><br>
<c:set var="num3" value="<%=(num1 + num2) %>" />
${num1}<br>
${applicationScope.num1}<br>
${num2}<br>
${num3}