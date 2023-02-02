<%@page import="models.Kanban"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, commons.Status, models.Kanban" %>

<%
	Map<Status, List<Kanban>> kanbans = (Map<Status, List<Kanban>>)request.getAttribute("kanbans");
	for(Map.Entry<Status, List<Kanban>> entry : kanbans.entrySet()){
		Status status = entry.getKey();
		List<Kanban> list = entry.getValue();
		%>
		<ul class="items">
			<li class="tit"><%=Status.getStatus(status) %></li>
			<%
				for(Kanban kanban : list){ %>
				<li class="item" data-id="<%=kanban.getId() %>"><%=kanban.getSubject() %></li>
			<%} %>
		</ul>
	<%}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>