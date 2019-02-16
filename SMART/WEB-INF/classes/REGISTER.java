

import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.sql.*;


public class REGISTER extends HttpServlet
{
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{
				try
				{						
					String first_name,last_name,age,radio,email,password,dob_date,dob_month,dob_year;
					first_name=request.getParameter("first_name");
					last_name=request.getParameter("last_name");
					radio=request.getParameter("r");
					email=request.getParameter("email");
					age=request.getParameter("age");
					password=request.getParameter("password");
					dob_date=request.getParameter("dob_date");
					dob_month=request.getParameter("dob_month");
					dob_year=request.getParameter("dob_year");

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
					System.out.println("========================================================");
					response.setContentType("text/html");
					PrintWriter pw = response.getWriter();


					if(first_name.equals("") || last_name.equals("") || email.equals("") || password.equals("") ||dob_date.equals("")||dob_month.equals("")||dob_year.equals(""))
					{
						System.out.println("In All check if");
						response.sendRedirect("htmls/register.html");
					}
				}
					
				
				catch(Exception e)
				{
					System.out.println(e);
				}
	}			

	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request,response);
	}			
}
	