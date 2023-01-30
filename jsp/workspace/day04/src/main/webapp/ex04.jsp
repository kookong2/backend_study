<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%
	Class.forName("com.mysql.cj.jdbc.Driver");
	String url = "jdbc:mysql://localhost:3306/kanban?user=root&password=aA!123456";
	
	try(Connection conn = DriverManager.getConnection(url);
		Statement stmt = conn.createStatement()){
		
		ResultSet rs = stmt.executeQuery("SELECT * FROM member");
		while(rs.next()){
			int memNo = rs.getInt("memNo");
			String memId = rs.getString("memNm");
			String memPw = rs.getString("memPw");
			String memNm = rs.getString("memNm");
			
			System.out.printf("memNo = %d, memId = %s, memPw = %s, memNm = %s %n",
								memNo,memId,memPw,memNm);
		}
		
		rs.close();
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