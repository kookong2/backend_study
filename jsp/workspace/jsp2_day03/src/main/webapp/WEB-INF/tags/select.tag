<%@ tag pageEncoding="UTF-8" %>
<%@ tag body-content="empty" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ tag import="java.util.Iterator" %>
<%@ tag trimDirectiveWhitespaces="true" %>
<%@ attribute name="var" required="true" rtexprvalue="false" %>

<%@ attribute name="items" type="java.util.List" required="true" %>
<%@ variable name-from-attribute="var" alias="html" variable-class="java.lang.String" scope="AT_END" %>
<% 
	StringBuffer sb = new StringBuffer(500);
	sb.append("<select>");
	Iterator<String> iter = items.iterator();
	while(iter.hasNext()) {
		String item = iter.next();
		sb.append("<option value='");
		sb.append(item);
		sb.append("'>");
		sb.append(item);
		sb.append("</option>");
	}
	sb.append("</select>");
	if (var == null) {
		out.print(sb);
	} else {%>
	<c:set var="html" value="<%=sb%>" />
<%} %>
