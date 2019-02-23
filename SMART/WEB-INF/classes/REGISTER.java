package Register;

import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import DatabaseConnector.OPENDATABASE;


public class REGISTER extends HttpServlet
{

	Connection con=null;
	 boolean checkEntry(String email)throws SQLException
	{
		Statement stmt=this.con.createStatement();
        ResultSet rss=stmt.executeQuery("SELECT email from SMART_TABLE where email=email");
		try
		{
        while(rss.next())
	        {
	        if(rss.getString("email").equalsIgnoreCase(email))
	        	{
	        		stmt.close();
	        		rss.close();
	        		return(true);
	        	}	
	        }
	    stmt.close();
	    rss.close();
    	return false;
    	}
    	catch(Exception e)
    	{
    		System.out.println("Form REGISTER->checkEntry : "+e);
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
					String first_name,last_name,age,radio,email,password,dob_date,dob_month,dob_year,height,weight;
					first_name=request.getParameter("first_name");
					last_name=request.getParameter("last_name");
					radio=request.getParameter("r");
					email=request.getParameter("email");
					age=request.getParameter("age");
					password=request.getParameter("password");
					dob_date=request.getParameter("dob_date");
					dob_month=request.getParameter("dob_month");
					dob_year=request.getParameter("dob_year");
					height=request.getParameter("height");
					weight=request.getParameter("weight");
					if(last_name==null || height==null || weight==null)
					{
						last_name="no";
						height="no";
						weight="no";
					}
					System.out.println("========================================================");
					System.out.println("first name:"+first_name);
					System.out.println("last name:"+last_name);
					System.out.println("radio:"+radio);
					System.out.println("email:"+email);
					System.out.println("Age : "+age);
					System.out.println("password:"+password);
					System.out.println("date:"+dob_date);
					System.out.println("month:"+dob_month);
					System.out.println("year:"+dob_year);
					System.out.println("weight:"+weight);
					System.out.println("height:"+height);
					System.out.println("========================================================");
					if(first_name.equals("")  || email.equals("") || password.equals("") ||dob_date.equals("")||dob_month.equals("")||dob_year.equals(""))
					{
						System.out.println("In All check if");
						response.sendRedirect("html/register.html");
					}
					else
					{
						this.con=od.getDbConnection();
						if(checkEntry(email)==false)
						{
						 PreparedStatement pstmt = con.prepareStatement("INSERT INTO SMART_TABLE values(?,?,?,?,?,?,?,?,?,?,?)");  
					      pstmt.setString(1,first_name);
					      pstmt.setString(2,last_name);
					      pstmt.setString(3,radio);
					      pstmt.setString(4,age);
					      pstmt.setString(5,email);
					      pstmt.setString(6,dob_date);
					      pstmt.setString(7,dob_month);
					      pstmt.setString(8,dob_year);
					      pstmt.setString(9,password);
					      pstmt.setString(10,height);
					      pstmt.setString(11,weight);
					      pstmt.executeUpdate();
					      pstmt.close();
					      this.con.close();
					      response.sendRedirect("html/register_accept.html");
						}
						else
						{
							this.con.close();
							response.sendRedirect("html/register.html");
						}
					}
				}
				catch(Exception e)
				{
					System.out.println("From REGISTER->doGet : "+e);
				}
	}			
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request,response);
	}			
}
	
