package core;

import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import InputProccesor.LANGUAGE_PROCCESSOR;
import PredictionLogic.MAKECLASS;
import PredictionLogic.THINK;
import DataStorage.STORAGE;

public class CORE extends HttpServlet
{ 

	boolean isRedundand(String symptom_str,ArrayList<String> symptom)
	{
		int count=0;
		Iterator itr=symptom.iterator();
		while(itr.hasNext())
		{
			if(itr.next().toString().equals(symptom_str))
				count++;
		}

		if(count>1)
			return(true);
		return  (false);

	}

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
		ArrayList<String> proccessed_data= new ArrayList<String>();

		//STOREDATA SD=new STOREDATA();
		//GET_STORED_DATA GSD=new GET_STORED_DATA();
		try
		{
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		proccessed_data.clear();
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
					symptom.add(h[0].toLowerCase());
					}
				}	

			}
				System.out.println("Symptoms values -> "+symptom);
				System.out.println("Days values -> "+days);
				System.out.println("Called LANGUAGE_PROCCESSOR from CORE");
				Iterator sitr =symptom.iterator();
				Iterator ditr =days.iterator();
				while(sitr.hasNext() && ditr.hasNext())
				{
					String symptom_str=sitr.next().toString();
					String days_str=ditr.next().toString();

					if(isRedundand(symptom_str,symptom)==true)
					{
						sitr.remove();
						ditr.remove();
					}
				}

				System.out.println("Symptoms values  with  repeated  removed values -> "+symptom);
				System.out.println("Days values with repeated  removed values -> "+days);







				LANGUAGE_PROCCESSOR LP=new LANGUAGE_PROCCESSOR();
				LP.match(symptom,days);
				symptom.clear();
				days.clear();

				symptom.addAll(LP.getProccessedSymptoms());
				days.addAll(LP.getProccessedDays());

				System.out.println("Procceses symptoms ->"+symptom);
				System.out.println("Procceses days ->"+days);


				if(symptom.size()<4 || days.size()<4)
				{
					response.sendRedirect("html/errorinput.html");
				}
				else
				{

				THINK T=new THINK();
				System.out.println("Called think from CORE");
				HttpSession session1=null;
				session1=request.getSession(false);
				String s_key=(String)(session1.getAttribute("email"));
				if(s_key!=null)
				T.getPrintData(symptom,days,s_key);
				response.sendRedirect("html/Result_page.jsp");
				}
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
