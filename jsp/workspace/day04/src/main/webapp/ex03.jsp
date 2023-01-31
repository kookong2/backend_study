<%@page import="javax.servlet.jsp.tagext.TryCatchFinally"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%
	Class.forName("com.mysql.cj.jdbc.Driver");

	String url = "jdbc:mysql://localhost:3306/kanban?user=root&password=aA!123456";
	
	try(Connection conn = DriverManager.getConnection(url);
		Statement stmt = conn.createStatement()){
		
		//INSERT
		/**
		String sql = "INSERT INTO member(memId, memPw, memNm)" +
					"VALUES('user03','12345','사용자03')";
		*/
		
		//UPDATE
		
		String sql = "UPDATE member " +
					"SET memPw ='2345' "+
					"WHERE memId ='user01'";
		
		
		//DELETE
		/**
		String sql = "DELETE FROM member WHERE memId='user02'";
		*/
		
		int cnt = stmt.executeUpdate(sql);
		System.out.println(cnt);
		
	}catch(SQLException e){
		e.printStackTrace();
	}
	
	
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