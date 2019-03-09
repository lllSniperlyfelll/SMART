package Logoutpack;

import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class LOGOUT extends HttpServlet
{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{
		try
		{
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		HttpSession session=null;
		session=request.getSession(false);
		session.invalidate();
		response.sendRedirect("html/dashboard.jsp");
		}
		catch(Exception e)
		{
			System.out.println("Form LOGOUT->doGet : "+e);
		}

	}

	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request,response);
	}
}