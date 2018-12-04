package com.filters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


@WebFilter("/LoginVaidation")
public class LoginVaidation implements Filter
{

  
    public LoginVaidation() 
    {
       
    }

	
	public void destroy() 
	{
		
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
	{
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String uName = request.getParameter("username");
		String uPass = request.getParameter("password");
		System.out.println("inside login validation filter");
		if(uPass.length() < 2 || uPass.length() > 15)
		{
			System.out.println("incorrect length");
			RequestDispatcher rd = request.getRequestDispatcher("/login.html");
			out.println("Password length must be between 8 to 15 characters");
			rd.include(request, response);
			
			
		}
		else
		{
			System.out.println("correct length filters");
			RequestDispatcher rd = request.getRequestDispatcher("/login");
			rd.forward(request, response);
		}
		//chain.doFilter(request, response);
	}

	
	public void init(FilterConfig fConfig) throws ServletException
	{
		
	}

}
