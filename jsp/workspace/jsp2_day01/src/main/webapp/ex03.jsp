<%@ page contentType="text/html; charset=utf-8" %>

<form method="post" action="ex03_ps.jsp">
	<input type="checkbox" name="choice" value="0">0
	<input type="checkbox" name="choice" value="1">1
	<input type="checkbox" name="choice" value="2">0
	<input type="checkbox" name="choice" value="3">3
	<button type="submit">등록!</button>
</form>

${header.cookie}<br>
${header['User-Agent']}<br>
<%--
${pageContext.out.print('출력')}<br>
${pageContext.response.sendRedirect("ex02.jsp")}
--%>
