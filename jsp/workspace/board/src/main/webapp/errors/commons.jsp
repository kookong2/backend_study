<%@page contentType="text/html;charset=utf-8"%>
<%@ page isErrorPage="true" %>
<%
	exception.printStackTrace();
	pageContext.setAttribute("message",exception.getMessage());
%>
${message}
