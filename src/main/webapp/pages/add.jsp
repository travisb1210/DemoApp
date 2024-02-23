<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp"%>
<%@ include file="header.jsp" %>
<%@ include file="footer.jsp" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Two Numbers</title>
</head>
<body bgcolor="cyan">

		
		<%@
			page import="java.util.*"
		%>
		
		<%!
			//The above is a directive tag which is used for importing one or multiple Java packages that 
			//may be used by the servlet
			//In addition to the "@page" directive, there is also the "@include" and "@taglib" directives as well
		
			//This is a declaration block.
			//It is used for creating seperate data or methods that is outside of the service 
			//implementation
			int i = 0;	
			Date date = new Date();
		%>
		
		<%
			//Everything inside of the scriptlet (<%) tags will be processed as regular Java code
			/*
				When JSP page is being used, the code that is present here will be converted to 
				a Servlet equipped with a service method, request and response objects, and PrintWriter.
				Therefore those objects are implicitly available when Java code is being written on a JSP page
			*/
			
			if(request.getParameter("error") != null ) {
				throw new Exception("Error has occurred");
			}
		
			int num1 = request.getParameter("num1") != "" ? Integer.parseInt(request.getParameter("num1")) : 0;
			int num2 = request.getParameter("num2") != "" ? Integer.parseInt(request.getParameter("num2")) : 0;
			int sum =  num1 + num2;
			
			System.out.println("Inside add.jsp page");
//			out.println("Output: " + sum); //Alternatively, the JSP Expression syntax on line 53 can be used to invoke the out.print method directly)
	 		
		%>
		
		<%= "Output: " 
			+ sum
			+ "<br />" 
			+ "Date is: " + date
			+ "<br />"
		    + "Integer value i is: " + i
		%>
		
		

</body>
</html>