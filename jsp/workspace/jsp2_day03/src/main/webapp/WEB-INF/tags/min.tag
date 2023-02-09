<%@ tag pageEncoding="UTF-8" %>
<%@ tag body-content="empty" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="var" required="true" rtexprvalue="false" %>
<%@ attribute name="num1" type="java.lang.Integer" required="true"  rtexprvalue="false" %>
<%@ attribute name="num2" type="java.lang.Integer" required="true"  rtexprvalue="false" %>
<%@ variable name-from-attribute="var" alias="minimum" variable-class="java.lang.Integer" scope="AT_END" %>
<%
	int minimum = num1;
	if (num2 < num1) minimum = num2;
%>
<c:set var="minimum" value="<%=minimum%>" />