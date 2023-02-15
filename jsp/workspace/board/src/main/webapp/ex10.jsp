<%@ page contentType="text/html;charset=utf-8"%>
<%
	String session1=(String)session.getAttribute("session1");
	String session2 =(String)session.getAttribute("session2");
	System.out.println("session1= "+session1);
	System.out.println("session2= "+session2);
%>