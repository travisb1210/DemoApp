package com.demo.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(value = "/sqRoot")
public class SquareRootServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		System.out.println("Arrived at square root servlet\n");

		PrintWriter out = res.getWriter();
		out.println("<h1>INSIDE SQUARE ROOT SERVLET</h1>");
		
//		System.out.println("Retrieving value from request parameters");
//		int sqRootBase = Integer.parseInt(req.getParameter("addServletSum")); //Retrieve from query parameters if using RequestDispatcher or a new request that was redirected
		
//		HttpSession session = req.getSession();
//		System.out.println("Retrieving value from Http Session");
//		int sqRootBase = (int)session.getAttribute("sessionSum"); //Retrieve value from HttpSession when redirecting
		
		int sqRootBase = 0;
		
		for(Cookie cookie : req.getCookies()) {
			if(cookie.getName().equals("sumCookie")) {
				System.out.print("Retrieving value from cookies\n");
				sqRootBase = Integer.parseInt(cookie.getValue());
				break;
			}
		}
		
		out.println("Square Root of " + sqRootBase + " is " + sqRootBase * sqRootBase);
		out.println(
			"""
			<form action="index.html" method="post">
				<input type="submit" value="Go Home">
			</form>
			"""
		);
	}
}
