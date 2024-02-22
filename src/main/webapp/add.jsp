<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Two Numbers</title>
</head>
<body bgcolor="cyan">

		<%@
			page import="java.util.Date"
		%>
		
		<%!
			//The above is a directive tag which is used for importing one or multiple Java packages that 
			//may be used by the servlet
		
			//This is a declaration block.
			//It is used for creating seperate data or methods that is outside of the service 
			//implementation
			int i = 0;	
		%>
		
		<%
			//Everything inside of the scriptlet (<%) tags will be processed as regular Java code
			/*
				When JSP page is being used, the code that is present here will be converted to 
				a Servlet equipped with a service method, request and response objects, and PrintWriter.
				Therefore those objects are implicitly available when Java code is being written on a JSP page
			*/
			int num1 = request.getParameter("num1") != "" ? Integer.parseInt(request.getParameter("num1")) : 0;
			int num2 = request.getParameter("num2") != "" ? Integer.parseInt(request.getParameter("num2")) : 0;
			int sum =  num1 + num2;
			
			System.out.println("Inside add.jsp page");
//			out.println("Output: " + sum); //Alternatively, the syntax on line 41 can be used to invoke the out.print method directly)
	 		
		%>
		
		<%= "Output: " + sum %>

</body>
</html>