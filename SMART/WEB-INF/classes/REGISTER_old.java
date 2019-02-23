package Register;

import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
//import CsvWriter.CSVWRITER;

/*class CSV_CONNECT
{
    ArrayList<String> username=new ArrayList<String>();
	int itr=0;
 

	ArrayList<String> getUsernames(String file_name)//throws FileNotFoundException
	{
		try
		{
		String data;
		String temp[]=new String[1000];
		File f= new File(file_name);
        Scanner sc= new Scanner(f);
            while(sc.hasNext())
            {
                data=sc.next();
				temp=data.split(",");
          		this.username.add(temp[1]);
            }
            sc.close();
			//File.close(f);
         }
         catch(Exception e)
         {
         	System.out.println("CSV_CONNECT REGISTER-> "+e);
         }

		return(this.username);
	}
}*/


public class REGISTER extends HttpServlet
{

   int accept=0;
   int enter_data_to_csv=0;
	/*public  void check_accept(HttpServletRequest request,HttpServletResponse response,String email) throws ServletException, IOException
	{

		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		ArrayList<String> usernames=new ArrayList<String>();
		if(this.accept==1)
			response.sendRedirect("html/register.html");
		else
		{
			usernames.clear();
			CSV_CONNECT CC=new CSV_CONNECT();
			usernames.addAll(CC.getUsernames("user_details.csv"));

			for(String i:usernames)
			{
				System.out.println("Usernames in dataset -> "+i);
				if(email.equalsIgnoreCase(i)==true)
				{
					System.out.println("Usernames matched -> "+i);
					this.enter_data_to_csv=1;
					response.sendRedirect("html/register.html");
					break;
				}
			}

		}
					
	}*/
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{
				try
				{						
					response.setContentType("text/html");
					PrintWriter pw = response.getWriter();
					
					ArrayList<String> data=new ArrayList<String>();				
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
					


					if(first_name.equals("") || last_name.equals("") || email.equals("") || password.equals("") ||dob_date.equals("")||dob_month.equals("")||dob_year.equals(""))
					{
						System.out.println("In All check if");
						response.sendRedirect("html/register.html");
					}
					else
					{
						data.add(first_name);
						data.add(last_name);
						data.add(radio);
						data.add(email);
						data.add(age);
						data.add(password);
						data.add(dob_date);
						data.add(dob_month);
						data.add(dob_year);


						for(char i: age.toCharArray() )
						{
							if( Character.isDigit(i)==true )
								this.accept=0;
							else
								this.accept=1;
						}
						//check_accept(request,response,email);
						//this.enter_data_to_csv=1;
						if(this.enter_data_to_csv==0)
							{
							System.out.println("Trying to write ......");
							FileWriter fw = new FileWriter("user_details.txt");
							/*BufferedWriter bw = new BufferedWriter(fw);
							PrintWriter pww = new PrintWriter(bw);
							pww.println(first_name+","+last_name);
							pww.flush();
							pww.close();
							bw.close();
							fw.close();*/
							
							fw.append("here");
							  fw.append(',');
							  fw.append("there");
							  fw.append('\n');
							 fw.flush();
							 fw.close();
							//CSVWRITER CWR= new CSVWRITER();
							//CWR.writeToCsv(data,"user_details.csv");
							response.sendRedirect("html/register_accept.html");

						}



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
	