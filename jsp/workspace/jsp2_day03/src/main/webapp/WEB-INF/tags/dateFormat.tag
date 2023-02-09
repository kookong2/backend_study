<%@ tag pageEncoding="UTF-8" %>
<%@ tag body-content="empty" %>
<%@ tag trimDirectiveWhitespaces="true" %>
<%@ tag import="java.time.format.DateTimeFormatter" %>
<%@ attribute name="value" type="java.time.temporal.TemporalAccessor" required="true" %>
<%@ attribute name="pattern" %>
<%
	pattern = pattern == null ? "yyyy-MM-dd" : pattern;
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
%>
<%=formatter.format(value)%>