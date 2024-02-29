<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	Hello World - direct HTML
	
	<br>
	
	<%
	//Request attributes can be accessed directly in JSP via the expression language syntax
	//The same thing can be accomplished with JSTL tags. This is not implicitly included just by
	//using JSP. It must be imported with <%@... tag
		String name = request.getAttribute("label").toString();
		out.println(name + " - from within scriptlet tag accessing request attribute");
	%>
	
	<br>
	
	${label} - using expression language syntax to access request attribute
	
	<br>
	
	<c:out value="Hello world - using JSTL tag" />
	
</body>
</html>