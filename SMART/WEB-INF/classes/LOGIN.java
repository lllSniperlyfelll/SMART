package LoginHandler;

import javax.servlet.http.HttpSession;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import DatabaseConnector.OPENDATABASE;

public class LOGIN extends HttpServlet

{
	Connection con=null;
	HttpSession session=null;
	boolean sessionExists(String email,HttpServletRequest request)
	{
		try
		{
		this.session=request.getSession(false);
		if(session==null)
			return false;
		else
			{
				if(request.getAttribute("email").equals(email))
					return true;
				else
					return false;
			}
		}
		catch(Exception e)
		{
			System.out.println("From LOGIN->sessionExists : "+e);
		}
		return false;

	}

	boolean checkPassword(String password,String email)throws SQLException
	{
		Statement stmt=this.con.createStatement();
		String query="SELECT email,password from smart_table where email="+ ("'"+email+"'");
		System.out.println("Query -> "+query);
        ResultSet rss=stmt.executeQuery(query);
		try
		{
        while(rss.next())
	        {
	        	String emaill,passwordd;
	        	emaill=rss.getString("email");
	        	passwordd=rss.getString("password");
	        	System.out.println("Email and password fetched -> "+emaill+" -> " +passwordd);
	        if(emaill.equals(email) && passwordd.equals(password))
	        	{
	        		stmt.close();
	        		rss.close();
	        		return(true);
	        	}	
	        }
		}
	    catch(Exception e)
	    {
	    	System.out.println("From LOGIN->checkPassword : "+e);
	    }
	   	stmt.close();
	    rss.close();
	    return false;
	}


	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{
				try
				{						
					response.setContentType("text/html");
					PrintWriter pw = response.getWriter();
					OPENDATABASE od = new OPENDATABASE();
					this.con=od.getDbConnection();
					String email,password;
					email=request.getParameter("email1");
					password=request.getParameter("password1");

					System.out.println(" email "+email);
					System.out.println(" password "+password);
					
					if(checkPassword(password,email)==true)
					{
						System.out.println("Password ok ");
						if(sessionExists(email,request)==false)
						{

							this.session=request.getSession();
							this.session.setAttribute("email",email);
							response.sendRedirect("html/register_accept.html");
						}
					}	
					else
					{
						response.sendRedirect("html/register.html");
					}


				}
				catch(Exception e)
				{
					System.out.println("From LOGIN->doGet : "+e);
				}
	}

	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request,response);
	}
}