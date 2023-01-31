<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>페이지 상단 - ex07</h1>
	<jsp:include page="header.jsp"/>
	<jsp:include page="ex05.jsp">
		<jsp:param name="num1" value = "10"/>
		<jsp:param name="num2" value = "20"/>
	</jsp:include>
	<jsp:include page="footer.jsp"/>
	<h1>페이지 하단 - ex07</h1>
</body>
</html>