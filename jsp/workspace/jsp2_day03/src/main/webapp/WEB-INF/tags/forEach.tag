<%@ tag pageEncoding="UTF-8" %>
<%@ tag body-content="scriptless" %>
<%@ tag import="java.util.Iterator" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ tag trimDirectiveWhitespaces="true" %>
<%@ attribute name="var" required="true" rtexprvalue="false" %>
<%@ attribute name="items" type="java.util.Collection" required="true" %>
<%@ variable name-from-attribute="var" alias="item" variable-class="java.lang.String"  scope="NESTED" %>
<%
	Iterator<String> iter = items.iterator();
	while(iter.hasNext()) { 
		String item = iter.next(); %>
		<c:set var="item" value="<%=item%>" />	
		<jsp:doBody />	
<%}%>
