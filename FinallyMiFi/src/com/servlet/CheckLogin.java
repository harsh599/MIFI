package com.servlet;

import java.io.IOException;


import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.database.Database;
import com.mysql.jdbc.Connection;
import com.providers.Providers;


public class CheckLogin extends HttpServlet 
{
	
	Database do1;
	public void init(ServletConfig c)throws ServletException
	{
		super.init(c);
		Connection con =(Connection)getServletContext().getAttribute("DbConnection");
		do1 = new Database(con);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session1 = request.getSession(true);
		System.out.println("Inside CheckLogin Servlet");
		PrintWriter out = response.getWriter();
		String uName = request.getParameter("username");
		String uPass = request.getParameter("password");
		do1.vaidate(uName,uPass);
		if(do1.vaidate(uName,uPass) == true)
		{
			
			session1.setAttribute("uName",uName);
			System.out.println(session1.getId()+"inside servlet");
			RequestDispatcher rd = request.getRequestDispatcher("/test.jsp");
			rd.forward(request, response);
		}
		else
		{
			out.println("UserName Doesn't exists");
			RequestDispatcher rd = request.getRequestDispatcher("/login.html");
			rd.include(request, response);
			
		}
		
	}

}
