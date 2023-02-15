<%@ page contentType="text/html;charset=utf-8"%>
<%@ page import="commons.*" %>
<%
	//HttpServletRequest
	//CommonRequestWrapper
	CommonRequestWrapper req=(CommonRequestWrapper)request;
	String value=req.getCookie("key1");
	out.print(value);
%>