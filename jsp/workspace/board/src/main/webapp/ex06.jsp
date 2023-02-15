<%@ page contentType="text/html;charset=utf-8"%>
<%@ page import="javax.servlet.http.*" %>
<%
Cookie[] cookies=request.getCookies();
for(Cookie cookie:cookies){
	String name=cookie.getName();
	String value=cookie.getValue();
	out.print("name = "+ name+", value= "+value+"<br>");
}
%>