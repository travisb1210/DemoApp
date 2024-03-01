package com.demo.security;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class LongEnoughFilter
 */
@WebFilter("/filterDemo")
public class LongEnoughFilter extends HttpFilter implements Filter {
       

	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		System.out.println("In " + LongEnoughFilter.class);
		if(request.getParameter("var1").length() > 3 && request.getParameter("var2").length() > 3) {
			System.out.println("Var1 and Var2 are long enough");
			chain.doFilter(request, response);
		}else {
			System.out.println("Var1 and Var2 are too short");
			response.sendRedirect("/DemoApp/app");
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
