<%@ tag pageEncoding="UTF-8"%>
<%@ tag trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="title" %>



<layout:common title="${title}">
	<jsp:attribute name="header">
		<h1>헤더</h1>
	</jsp:attribute>
	<jsp:attribute name="footer">
		<h1>푸터</h1>
	</jsp:attribute>
	
	
	<jsp:body>
		<jsp:doBody />
	</jsp:body>
</layout:common>