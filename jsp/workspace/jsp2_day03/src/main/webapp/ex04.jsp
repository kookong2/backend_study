<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="util"  tagdir="/WEB-INF/tags" %>
<%
	List<String> items = Arrays.asList("사과", "배", "망고", "바나나");
	pageContext.setAttribute("items", items);
%>
<util:select var="select" items="${items}" />
${select}