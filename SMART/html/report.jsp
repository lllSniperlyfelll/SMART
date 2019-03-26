
<%@page language="java" pageEncoding="UTF-8" %>
<%@ page language="java" import="java.io.*"%>
<%@ page language="java" import="java.util.*"%>
<%@ page language="java" import="DatabaseConnector.OPENDATABASE"%>
<%@ page language="java" import="javax.servlet.http.HttpSession"%>
<%@ page language="java" import="java.sql.*"%>
<%@ page language="java" import="javax.servlet.*"%>
<%@ page language="java" import="javax.servlet.http.*"%>
<%@ page language="java" import="DataStorage.STORAGE"%>



<%!
public String s_key="";
HttpSession session=null;
public String this_s_key="";
Connection com=null;
String first_name,last_name,gender,age,height,weight;
String dis="";
String op_data="";
%>

<%
s_key="";
this_s_key="";
dis="";
op_data="";
ArrayList<String> data =new ArrayList<String>();
ArrayList<String> days=new ArrayList<String>();
ArrayList<String> symp=new ArrayList<String>();
STORAGE SS=new STORAGE();
s_key=SS.getSessionKey();
data.clear();
session=request.getSession(false);
this_s_key=(String)(session.getAttribute("email"));
if(s_key.equals(this_s_key))
	{
	System.out.println(" Keys Equated in report.jsp");
	OPENDATABASE OD=new OPENDATABASE();
		com=OD.getDbConnection();
		Statement stmt=com.createStatement();
		String query="SELECT * from smart_table where email="+ ("'"+s_key+"'");
		System.out.println("Query -> "+query);
        ResultSet rss=stmt.executeQuery(query);
		try
		{
        while(rss.next())
	        {
	        	first_name=rss.getString("first_name");
	        	last_name=rss.getString("last_name");
	        	gender=rss.getString("gender");
	        	age=rss.getString("age");
	        	height=rss.getString("height");
	        	weight=rss.getString("weight");
	        	//System.out.println("Email and password fetched -> "+emaill+" -> " +passwordd);	
	        }
		}
	    catch(Exception e)
	    {
	    	System.out.println("From report.jsp : "+e);
	    }
	   	stmt.close();
	    rss.close();
	    OD.DB_CLOSER(com);
	    data.addAll(SS.SUB_STORAGE_get());
	    Iterator itr=data.iterator();
        dis=data.get(0);
        while(itr.hasNext())
        {
            if(itr.next().toString().equals(dis))
                itr.remove();

        }
        Iterator itr1=data.iterator();
        while(itr1.hasNext())
        {
            String val=itr1.next().toString();
            char array[]=val.toCharArray();
            for(char r:array)
            {
                if(Character.isDigit(r)==false)
                {
                    days.add(val);
                    break;
                }
                else
                {
                    symp.add(val);
                    break;
                }
            }
        }

        Iterator itr2=symp.iterator();
        Iterator itr3=days.iterator();

        while(itr2.hasNext() && itr3.hasNext())
        {
        	op_data+="<tr><td><label style='width: :100%' class='w3-text w3-large w3-text-white w3-wide'>"+itr3.next().toString()+", </label></td></tr>";
        }






















	}
else
	{
	System.out.println("Error in match");
	response.sendRedirect("noinput.html");
	}
%>







<html>
<head>
	<link rel="stylesheet" href="../css/w3.css"> 
	<link rel="stylesheet" href="../css/bootstrap.min.css">
	<link rel="stylesheet" href="../css/w3-colors-flat.css">
	<link rel="stylesheet" href="../css/w3-colors-metro.css">
	<link rel="stylesheet" href="../css/w3-colors-win8.css">
	<link href="https://fonts.googleapis.com/css?family=Alfa+Slab+One" rel="stylesheet">
	<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-colors-win8.css">
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-colors-flat.css">
	<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-colors-metro.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

</head>
	<body class="">
		<div class="w3-left w3-bar w3-light-blue w3-opacity-max" style="width:110%;height: 210%; ">
			
		</div>

		<div class="w3-display-topmiddle w3-container w3-white w3-margin-top w3-round-small w3-card-4" style="width:60%;height:130%">
			<div class="w3-container w3-display-topleft w3-metro-blue w3-card-4 w3-round-small" style="width: 100%;height: 10%">
				<center><font class="w3-display-middle w3-text w3-jumbo w3-wide" style="width: 100%;font-family: cursive;font-weight: bolder;"> S M A R T </font></center>
			</div>
			<br><br>
			<div class="w3-display-middle w3-container w3-light-blue w3-margin-top w3-card-4 " style="width:95%;height:90%;z-index: -1">
				<br><br>
				<center><font class="w3-display-top w3-margin-top w3-text w3-text-white w3-xxlarge">HEALTH REPORT<hr></font></center><br>
				<br>
				<table border="0"  class="w3-display-middle  " style="width: 90%;background-color: transparent;">
					<tr class="w3-hover-white" >
						<td style="text-align: center;">
							<br>
							<br><br><br><br>
							<div class="w3-container w3-metro-blue w3-round-small w3-card-4">
								<label style="width: :100%" class="w3-text w3-xlarge w3-text-white w3-wide">Name:-<% out.write(" "+first_name+" "+last_name); %> </label>
							</div>
							<br>
						</td>
					</tr>
					<tr class="w3-hover-white">
						<td style="text-align: center;">
							<br>
							<div class="w3-container w3-metro-blue w3-round-small w3-card-4">
								<label style="width: :100%" class="w3-text w3-xlarge w3-text-white w3-wide">Gender:- <% out.write(" "+gender); %></label>
							</div><br>
						</td>
					</tr>
					<tr class="w3-hover-white">
						<td style="text-align: center;">
<br>
							<div class="w3-container w3-metro-blue w3-round-small w3-card-4">
								<label style="width: :100%" class="w3-text w3-xlarge w3-text-white w3-wide">Age:-<% out.write(" "+age); %></label>
							</div><br>
						</td>
					</tr>
					<tr class="w3-hover-white">
						<td style="text-align: center;">
<br>
							<div class="w3-container w3-metro-blue w3-round-small w3-card-4">
								<label style="width: :100%" class="w3-text w3-xlarge w3-text-white w3-wide">Weight:- <%out.write(" "+weight); %>kg </label>
							</div><br>
						</td>
					</tr>

					<tr class="w3-hover-white">
						<td style="text-align: center;">
<br>
							<div class="w3-container w3-metro-blue w3-round-small w3-card-4">
								<label style="width: :100%" class="w3-text w3-xlarge w3-text-white w3-wide">Height:- <%out.write(" "+height); %>m </label>
							</div><br>
						</td>
					</tr>

					<tr class="w3-hover-white">
						<td style="text-align: center;">
							<br>
							<div class="w3-container w3-metro-blue w3-round-small w3-card-4">
								<table border="0" style="width: 90%">
									
									<tr>
										<td style="text-align: center;">
											<label style="width: :100%" class="w3-text w3-xlarge w3-text-white w3-wide">Symptoms :- </label>
										</td>
										<td style="text-align: center;">
											<center>
											<table border="0">
												<% out.write(op_data); %>
												<!--<tr>
													<td>
												<label style="width: :100%" class="w3-text w3-large w3-text-white w3-wide">fever, </label>			
													</td>
												</tr>
												<tr>
													<td>
														<label style="width: :100%" class="w3-text w3-large w3-text-white w3-wide">cough, </label>
													</td>
												</tr>
												<tr>
													<td>
														<label style="width: :100%" class="w3-text w3-large w3-text-white w3-wide">headache, </label>
													</td>
												</tr> -->
											</table>
											</center>
									</tr>
								</table>
								
							</div>
							<br>
						</td>
					</tr>
						<tr class="w3-hover-white">
						<td style="text-align: center;">
<br>
							<div class="w3-container w3-metro-blue w3-round-small w3-card-4">
								<label style="width: :100%" class="w3-text w3-xlarge w3-text-white w3-wide">Disease predicted : -  <font class="w3-text-white w3-xxlarge"><% out.write("'"+dis+"'");  %></font></label>
							</div><br>
						</td>
					</tr>
				</table>
				<font class="w3-display-bottomright w3-text-white w3-xlarge w3-margin-bottom w3-margin-right"> Generated by - SMART</font>
		</div>
	</body>
</html>