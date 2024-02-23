package com.demo.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class HomeServlet extends HttpServlet {
	
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		System.out.println("Booting server");
		Cookie cookie = new Cookie("sessionCookie", "123");
		res.addCookie(cookie);
		
		RequestDispatcher rd = req.getRequestDispatcher("pages/index.jsp");
		rd.forward(req, res);
		
	}
}
