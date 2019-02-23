package DatabaseConnector;

import java.io.*;
import java.sql.*;
import java.util.*;


public class OPENDATABASE
{
Connection com=null;
	public Connection getDbConnection()
	{
		try
		{
		
		Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		com=DriverManager.getConnection("jdbc:mysql://localhost:3306/SMART_DATABASE","root","");
		return(com);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return(com);
	}
	
	public void DB_CLOSER(Connection com)
	{
		try
		{
		com.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}