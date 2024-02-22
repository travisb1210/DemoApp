package com.demo.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/home",
			initParams = {
				@WebInitParam(name = "name", value = "Travis"),
				@WebInitParam(name = "age", value = "28"),
			})
public class MyServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res ) throws IOException {
		
		PrintWriter out = res.getWriter();
		
		
		//These are grabbing parameters that are scoped to the entire
		//server. Every servlet can have access to them
//		ServletContext ctx = getServletContext();
//		String nameString = ctx.getInitParameter("name"); 
//		String ageString = ctx.getInitParameter("age");
		
		/*
		 * IN BOTH THE ABOVE AND BELOW SCENARIO, THIS IS ONLY APPLICABLE
		 * IF USING A WEB.XML FILE TO DEFINE SERVLETS
		 */

		//These are grabbing parameters scoped for this servlet only
		//Other servlets would not have access to these values
//		ServletConfig cfg = getServletConfig();
//		String nameStringLocal = cfg.getInitParameter("name");
//		String ageStringLocal = cfg.getInitParameter("age");
		
		//Get initialization parameters from the annotations
		//based configuration
		String nameString = getInitParameter("name");
		String ageString = getInitParameter("age");
		
		out.printf(
				"""
				<HTML>
				Hi! My name is %s and I am %s years old
				<form action="index.html" method="post">
					<input type="submit" value="Go Home">
				</form>
				</HTML>
				""", nameString, ageString);
	}
}
