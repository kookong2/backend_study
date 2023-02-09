<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="util" tagdir="/WEB-INF/tags" %>
<%
LocalDateTime now = LocalDateTime.now();
pageContext.setAttribute("date", now);
 %>
<util:dateFormat value="${date}"  pattern="yyyy.MM.dd HH:mm"/>
<c:set var="num" value="100" />
${num}