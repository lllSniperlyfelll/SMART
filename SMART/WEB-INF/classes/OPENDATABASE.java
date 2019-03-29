package DatabaseConnector;

import java.io.*;
import java.sql.*;
import java.util.*;


public class OPENDATABASE
{
Connection com=null;
Connection info_con=null;
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

	public Connection getInfoDbConnection()
	{
		try
		{
		
		Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		info_con=DriverManager.getConnection("jdbc:mysql://localhost:3306/smart_info","root","");
		System.out.println("COnnected to info Database"+info_con.toString());
		return(info_con);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return(info_con);
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