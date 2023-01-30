<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%
	Class.forName("com.mysql.cj.jdbc.Driver");
	String url = "jdbc:mysql://localhost:3306/kanban";
	
	String sql = "INSERT INTO member(memId, memPw, memNm) VALUES(?,?,?)";
	//String sql = "UPDATE member SET memNm='사용자04' WHERE memId = 'user04'";
	try(Connection conn = DriverManager.getConnection(url,"root","aA!123456");
		PreparedStatement pstmt = conn.prepareStatement(sql)){
		
		
		pstmt.setString(1, "user04");
		pstmt.setString(2, "123456");
		pstmt.setString(3, "사용자04");
		
		
		//pstmt.setString(1, "사용자04");
		
		int cnt = pstmt.executeUpdate();
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