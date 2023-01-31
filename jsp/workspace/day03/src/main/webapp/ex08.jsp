<%@page import="day03.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id ="member" class="day03.Member" scope="request"/>

<jsp:setProperty name="member" property="*" />
<jsp:setProperty name="member" property="memId" param="userId" />
<jsp:getProperty name="member" property="memId" />
<jsp:getProperty name="member" property="memPw" />
<jsp:getProperty name="member" property="memNm" />

<%-- 
<%
	member.setMemId("user01");
	String memId = member.getMemId();
	//out.print(memId);
%>
${member.memId}
--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>