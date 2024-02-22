package com.demo.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/add")
public class AddServlet extends HttpServlet {
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		int num1 = request.getParameter("num1") != "" ? Integer.parseInt(request.getParameter("num1")) : 0;
		int num2 = request.getParameter("num2") != "" ? Integer.parseInt(request.getParameter("num2")) : 0;
		int sum =  num1 + num2;
		
		System.out.println("Sum is " + sum);
		
		PrintWriter out = response.getWriter();
		out.println("<h1>INSIDE ADD SERVLET</h1>");
		out.println("Sum is " + sum);
		
		request.setAttribute("addServletSum", sum);
		//ReqDispatcher or Redirect can be used to communicate with another servlet
		
		//Request Dispatcher is good for sending requests to servlets ON THE SAME servlet
		//Request Dispatcher acts on the SAME request and response each time it is used
		/**
		 * CLIENT (req1) -> S1 (req1) -> S2
		 * CLIENT (res1) <- S2
		 */
		//RequestDispatcher rd = request.getRequestDispatcher("sqRoot");
		//rd.forward(request, response);
		
		//sendRedirect is good for sending requests to servlets on a different server
		//sendRedirect acts on a NEW request only every time it is utilized
		/**
		 * CLIENT (req1) -> S1 (req1) -> S2 on another server
		 * CLIENT (res1) <- S1
		 * CLIENT (req2) -> S2 on another server
		 * CLIENT (res2) <- S2
		 */
//		response.sendRedirect("sqRoot?addServletSum=" + sum); //URL Rewriting
		
//		HttpSession session = request.getSession();
//		session.setAttribute("sessionSum", sum); 
//		response.sendRedirect("sqRoot"); //Session management via Servlet Session object

		createAndAddCookies(response, sum);
		response.sendRedirect("sqRoot"); //Session management via cookie

		/*
		 * Cookies and http session can serve as forms of persistence throughout a web session
		 */
	}
	
	private static void createAndAddCookies(HttpServletResponse response, int sum) {
	
		Cookie sumCookie = new Cookie("sumCookie", String.valueOf(sum));
		Cookie anotherCookie = new Cookie("anotherCookie", "placeHolderValue");
		response.addCookie(sumCookie);
		response.addCookie(anotherCookie);
	}
}
