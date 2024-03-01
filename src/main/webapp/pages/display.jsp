<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@ taglib prefix='sql' uri='http://java.sun.com/jsp/jstl/sql' %>
<%@ taglib prefix='fn' uri='http://java.sun.com/jsp/jstl/functions' %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<c:out value="====================================="/><br>
	<c:out value="Demonstrating various ways to access request attributes"/><br>	
	Hello World - direct HTML
	
	<br>
	
	<%
	//Request attributes can be accessed directly in JSP via the expression language syntax
	
	//The same thing can be accomplished with JSTL tags. This is not implicitly included just by
	//using JSP. It must be imported with <%@... tag

		String name = request.getAttribute("label").toString();
		int number = 0;
		out.println(name + " - from within scriptlet tag accessing request attribute");
	%>
	
	<br>
	
	${label} - using expression language syntax to access request attribute
	
	<br>
	
	<c:out value="Hello world ${label} - using JSTL tag with expression language to print name" /><br>
	<c:out value="====================================="/><br>
	
	<br>
	
	<%		
	//These JSTL tags can also be used to execute conditional JSP code in addition to other 
	//programatic ways of controlling the content that is displayed on the page. JSTL also has
	//the capability of setting variables, including resources, and other features
	%>
	<c:out value="====================================="/><br>
	<c:out value="Demonstrating JSTL for loop" />	
	<br>
	<c:out value="List of students: "/>
	<c:forEach items="${students}" var="s">
		<br>${s}
	</c:forEach>
	<br>
	<c:out value="====================================="/>
	
	<br>
	
	<c:out value="====================================="/>
	<br>
	<c:out value="Querying database using JSTL SQL library"/>
	<br>
	<sql:setDataSource var="db" driver="org.postgresql.Driver" url="jdbc:postgresql://localhost:5432/students" user="postgres" password="pass123" />
	<sql:query var="rs" dataSource="${db}">SELECT * FROM STUDENTS</sql:query>
	
	<c:forEach items="${rs.rows}" var="student">
		<br><c:out value="${student.roll_no}"/> <c:out value="${student.name}"/> <c:out value="${student.marks}"/> 
	</c:forEach>
	<br>
	<c:out value="====================================="/>
	
	<br>
	
	<c:out value="====================================="/>
	<br>
	<c:out value="Demonstrating JSTL functions"/><br>
	<c:set var="testString" value="This is a test string" />
	Length of test string: ${fn:length(testString)}
	
	<c:forEach items="${fn:split(testString,' ')}" var="s">
	
		${s}
		
	</c:forEach>
	
	<br>
	
	index: ${fn:indexOf(testString, 'test')}<br>
	is there: ${fn:contains(testString, "string")}<br>
	<c:if test="${! fn:contains(testString, 'Travis')}">
		<c:out value="Travis is not here"/>
	</c:if>		
	<br>
	<c:out value="====================================="/>
	
	
	
</body>
</html>