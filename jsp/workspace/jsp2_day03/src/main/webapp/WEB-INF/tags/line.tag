<%@tag pageEncoding="UTF-8" %>
<%@tag body-content="empty" %>
<%@attribute name="size" type="java.lang.Integer"  required="true" %>
<% 
	for (int i = 0; i < size; i++) {
		out.print("가");
	}
%>