<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="util"  tagdir="/WEB-INF/tags" %>
<util:max num1="100" num2="200" />
${maximum}

<util:min var="min" num1="100" num2="200" />
${min}
<br>
<%
List<String> fruits = Arrays.asList("Apple", "Orange", "Mango");
pageContext.setAttribute("fruits", fruits);
%>
<util:forEach var="fr" items="${fruits}">
	${fr}<br>
</util:forEach>


