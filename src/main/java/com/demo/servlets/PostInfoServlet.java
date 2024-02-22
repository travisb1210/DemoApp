package com.demo.servlets;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/postInfo")
public class PostInfoServlet extends HttpServlet {

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		System.out.println("Server received new information");
		res.getWriter().println(
			"""
			<h1>INSIDE POST INFO SERVLET</h1>
			Server received info from client
			<div>
				<form action="index.html" method="post">
						<input type="submit"  value="Go Home">
				</form>
			</div>
			"""
		);
	}
}
