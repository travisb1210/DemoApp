package com.demo.servlets;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.model.Student;

@WebServlet("/mvc")
public class ModelViewServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		List<Student>students = Arrays.asList(new Student(1, "Travis", 44),new Student(2, "Chase", 50), new Student(3, "Hunter", 40));
		
		String name = "Travis";
		
		req.setAttribute("label", name);
		req.setAttribute("students", students);
		
		RequestDispatcher rd = req.getRequestDispatcher("pages/display.jsp");
		
		rd.forward(req, res);
	}
}
