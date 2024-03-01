package com.demo.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.ThreadLocalRandom;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.demo.model.HTML;

@WebServlet("/app")
public class HomeServlet extends HttpServlet {
	
	private static final HTML htmlOut =  new HTML(ThreadLocalRandom.current().nextInt(1,11));
	
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		if(session.getAttribute("credential") == null) {
			RequestDispatcher rd = req.getRequestDispatcher("pages/login.jsp");
			rd.forward(req, res);
		}
		
		Cookie cookie = new Cookie("sessionCookie", "123");
		res.addCookie(cookie);
		
		PrintWriter out = res.getWriter();
		
//		RequestDispatcher rd = req.getRequestDispatcher("pages/index.jsp");
//		rd.forward(req, res);
		
		out.print(htmlOut.getHtmlString());
		
	}
	
	
}
