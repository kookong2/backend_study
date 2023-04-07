<%@ tag pageEncoding="UTF-8" %>
<%@ tag body-content="scriptless" %>
<%@ tag trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="start" type="java.lang.Integer"  required="true" %>
<%@ attribute name="end" type="java.lang.Integer"  required="true" %>
<%@ attribute name="name"  required="true" %>
<%@ attribute name="label" %>
<select name="${name}" class="option_box"  id="birth_mm">
<c:if test="${ !empty label }">
	<option value="">${label}</option>
</c:if>
<% for (int i = start; i <= end; i++) {%>
	<option value="<%=i%>" ><%=(i < 10) ? "0" + i : i %></option>
<% } %>
</select>