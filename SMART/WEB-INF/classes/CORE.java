package core;

import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
//import DataStore.STOREDATA;
import PredictionLogic.MAKECLASS;
import PredictionLogic.THINK;
import DataStorage.STORAGE;

public class CORE extends HttpServlet
{
	boolean isNumber(String val)
	{
		boolean flag=false;
				for(char itr:val.toCharArray())
				{
					if(Character.isDigit(itr)==true)
						flag=true; 
					else
					{
						flag=false;
						break;
					}
				}
			return flag;
	}



	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{
		ArrayList<String> symptom= new ArrayList<String>();
		ArrayList<Integer> days= new ArrayList<Integer>();
		//STOREDATA SD=new STOREDATA();
		//GET_STORED_DATA GSD=new GET_STORED_DATA();
		try
		{
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		symptom.clear();
		days.clear();
		String h[]=new String[1000];
		Enumeration symptoms=request.getParameterNames();
		while(symptoms.hasMoreElements())
			{

				String p=(String)(symptoms.nextElement());
				System.out.println("Got parameter names -> "+p);
				h=request.getParameterValues(p);
				if(h[0]!=null)
				{
					if(isNumber(h[0])==true)
					{
						days.add(Integer.parseInt(h[0]));
					}
					else
					{
					symptom.add(h[0]);
					}
				}	

			}
				System.out.println("Symptoms values -> "+symptom);
				System.out.println("Days values -> "+days);
				THINK T=new THINK();
				System.out.println("Called think");
				HttpSession session1=null;
				session1=request.getSession(false);
				String s_key=(String)(session1.getAttribute("email"));
				if(s_key!=null)
				T.getPrintData(symptom,days,s_key);
			response.sendRedirect("html/Result_page.jsp");
				/*STORAGE S=new STORAGE();
				S.SUB_STORAGE_get();*/
				//SD.setData(symptom,days);
				//GSD.getPrintData();


		}
		catch(Exception e)
		{
			System.out.println("From CORE->doGEt : "+e);
		}
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request,response);
	}
}
