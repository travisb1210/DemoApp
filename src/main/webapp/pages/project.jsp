<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%
		//On this page, PostGres database connection is being established, data is being retrieved
		//and that data is being displayed on the page
		Class.forName("org.postgresql.Driver");
	
		String url = "jdbc:postgresql://localhost:5432/students";
		String userName = "postgres";
		String password = "pass123";
		
		String sql = "SELECT * FROM students WHERE NAME='Travis';";
		
		Connection con = DriverManager.getConnection(url, userName, password);
		System.out.println("DB connection is established");
		
		Statement st = con.createStatement();
		
		ResultSet rs = st.executeQuery(sql);
		rs.next();
	%>
	
	Roll Number: <%= rs.getString(1) %><br>
	Marks: <%= rs.getString(2) %><br>
	Name: <%= rs.getString(3) %>
		
	<%
		con.close();
		System.out.println("DB connection is closed");
	%>
	
</body>
</html>