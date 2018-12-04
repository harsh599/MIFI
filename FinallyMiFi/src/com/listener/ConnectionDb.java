package com.listener;

import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.mysql.jdbc.Connection;

/**
 * Application Lifecycle Listener implementation class ConnectionDb
 *
 */
@WebListener
public class ConnectionDb implements ServletContextListener {
	Connection con;
    /**
     * Default constructor. 
     */
    public ConnectionDb() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent event)  { 
         // TODO Auto-generated method stub
    	try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent event)  { 
    	ServletContext sc = event.getServletContext();
   	 
    	String url = sc.getInitParameter("url");
    	String user_name = sc.getInitParameter("username");
    	String password = sc.getInitParameter("password");
    	String driver = sc.getInitParameter("driver");
    	try {
			Class.forName(driver);
			
		}
    	catch (ClassNotFoundException e)
    	{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	try {
			con = (Connection) DriverManager.getConnection(url, user_name, password);
			event.getServletContext().setAttribute("DbConnection",con);
		} 
		catch (SQLException e)
    	{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
 
	
}
