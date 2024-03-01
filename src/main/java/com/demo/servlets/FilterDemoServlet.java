package com.demo.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/filterDemo")
public class FilterDemoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		String var1 = req.getParameter("var1");
		String var2 = req.getParameter("var2");
		
		PrintWriter out = res.getWriter();
		out.printf(
				"""
				Welcome to security filter demo! 
				Var 1 is %s and Var 2 is %s
				Var 1 length is %d and Var 2 length is %d
				""", var1, var2, var1.length(), var2.length()
		);
		
		
	}
}
