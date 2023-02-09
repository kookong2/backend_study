<%@tag pageEncoding="UTF-8" %>
<%@tag trimDirectiveWhitespaces="true" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@attribute name="num1" type="java.lang.Integer" required="true" %>
<%@attribute name="num2" type="java.lang.Integer" required="true" %>
<%@variable name-given="maximum"  variable-class="java.lang.Integer"  scope="AT_END" %>
<%
	int maximum = num1;
	if (num2 > num1) maximum = num2; 
%>
<c:set var="maximum" value="<%=maximum%>" />