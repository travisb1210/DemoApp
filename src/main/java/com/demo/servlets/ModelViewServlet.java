package com.demo.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mvc")
public class ModelViewServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException { 
		
		String name = "Travis";
		
		req.setAttribute("label", name);
		RequestDispatcher rd = req.getRequestDispatcher("pages/display.jsp");
		
		rd.forward(req, res);
	}
}
