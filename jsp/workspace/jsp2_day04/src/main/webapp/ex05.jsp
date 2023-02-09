<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<%
	String[] addCss = {"test1","test2","test3"};
	String[] addScript = {"testjs1","testjs2"};
	
	pageContext.setAttribute("addCss", addCss);
	pageContext.setAttribute("addScript", addScript);
%>
<layout:main title="회원가입">
		<h1>본문!</h1>
</layout:main>