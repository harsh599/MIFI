package com.database;

import java.sql.PreparedStatement;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.beans.GymInfo;
import com.mysql.jdbc.Connection;


public class Database
{
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	ArrayList details = new ArrayList();
	public Database(Connection con)
	{
		this.con = con;
	}
	public ArrayList extract()
	{
		
		try {
			pstmt = con.prepareStatement("select * from gyminfo");
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				GymInfo gi = new GymInfo();
				gi.setID(rs.getInt(1));
				gi.setImage(rs.getString(2));
				gi.setGymName(rs.getString(3));
				gi.setLocality(rs.getString(4));
				gi.setGAddress(rs.getString(5));
				gi.setGInfo(rs.getString(6));
				gi.setPrice(rs.getString(7));
				details.add(gi);
				
			}
			System.out.println(details);
		}
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return details;
	}
	
	
	public boolean vaidate(String uName,String uPass)
	{
		try {
			pstmt = con.prepareStatement("select * from logincredentials");
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				if((rs.getString(1)).equals(uName) && rs.getString(2).equals(uPass))
				{
					return true;
				}
			}
			
			
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}

}
