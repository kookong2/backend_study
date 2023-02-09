<%@ tag pageEncoding="UTF-8" %>
<%-- <%@ tag body-content="scriptless" %> --%>
<%@ tag body-content="tagdependent" %>
<%@ attribute name="color" %>
<div style="color: ${color};">==========================</div>
<jsp:doBody />
<div style="color: ${color};">===========================</div>