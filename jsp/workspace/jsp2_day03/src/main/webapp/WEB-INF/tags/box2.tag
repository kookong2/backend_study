<%@ tag pageEncoding="UTF-8" %>
<%@ tag body-content="scriptless" %>
<%@ tag import="java.util.Map" %>
<%@ tag trimDirectiveWhitespaces="true" %>
<%@ tag dynamic-attributes="attrs" %>
<%
	Map<String, String> attrs = (Map<String, String>)jspContext.getAttribute("attrs");
	System.out.println(attrs);
%>
<div style="border: ${attrs.size}px solid ${attrs.color}; font-size:${attrs.fontsize}px">
	<jsp:doBody />
</div>