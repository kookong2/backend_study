<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%
	Class.forName("com.mysql.cj.jdbc.Driver");
	String url = "jdbc:mysql://localhost:3306/madang?user=root&password=aA!123456";
	
	String sql = "CALL InsertBook(?,?,?,?)";
	try(Connection conn = DriverManager.getConnection(url);
		CallableStatement cstmt = conn.prepareCall(sql)){
		
		cstmt.setInt(1, 99);
		cstmt.setString(2, "책99");
		cstmt.setString(3, "출판사99");
		cstmt.setInt(4, 30000);
		
		int cnt = cstmt.executeUpdate();
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