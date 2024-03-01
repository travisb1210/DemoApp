package com.demo.service;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.demo.dao.CredentialDAO;
import com.demo.model.Credential;

@WebServlet("/login")
public class LoginService extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		
		String userName = req.getParameter("username");
		String password = req.getParameter("password");
		
		CredentialDAO dao = new CredentialDAO();
		Credential cred = null;
		
		RequestDispatcher rDispatcher = req.getRequestDispatcher("/app");
		
		try {
			cred = dao.getCredential(userName, password);
			HttpSession session = req.getSession();
			session.setAttribute("credential", cred);
			
			System.out.println("Establishing session");
			rDispatcher.forward(req, res);
		} catch (Exception e) {
			System.out.println("FAILURE: " + e.getMessage());
			rDispatcher = req.getRequestDispatcher("pages/login.jsp");
			rDispatcher.forward(req, res);
		}

	}
}
