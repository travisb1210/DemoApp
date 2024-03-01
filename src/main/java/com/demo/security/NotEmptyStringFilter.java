package com.demo.security;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/filterDemo")
public class NotEmptyStringFilter extends HttpFilter implements Filter {
       

	public void destroy() {
		// TODO Auto-generated method stub
	}


	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		System.out.println("In " + NotEmptyStringFilter.class);
		if(!request.getParameter("var1").equals("") || !request.getParameter("var2").equals("")) {
			System.out.println("Var1 and Var2 are not empty strings");
			chain.doFilter(request, response);
		}else {
			System.out.println("var1/var2 is an empty string");
			response.sendRedirect("/DemoApp/app");
		}
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
