
<%@page language="java" pageEncoding="UTF-8" %>
<%@ page language="java" import="java.io.*"%>
<%@ page language="java" import="java.util.*"%>
<%@ page language="java" import="DatabaseConnector.OPENDATABASE"%>
<%@ page language="java" import="javax.servlet.http.HttpSession"%>
<%@ page language="java" import="java.sql.*"%>
<%@ page language="java" import="javax.servlet.*"%>
<%@ page language="java" import="javax.servlet.http.*"%>




<%!
public String quote="";
public String primary_key="";
HttpSession session1=null;
Connection com=null;
String img="",img1,img2;
Float bmi;
String emaill,gender;
String login="not";
%>

<%



    session1=request.getSession(false);
    if( (session1)!=null)
    {
            System.out.println("Session from dashboardt -> "+session);        
        //session=request.getSession(false);
        primary_key=(String)(session1.getAttribute("email"));
        System.out.println("primary key from dash bordd -> "+primary_key);
        if(primary_key!=null)
        {
            login="not";
           // primary_key=session.getAttribute("email").toString();
        System.out.println("Primary key  from dashboard -> "+primary_key);
        OPENDATABASE OD=new OPENDATABASE();
        com=OD.getDbConnection();
        Statement stmt=com.createStatement();
        String query="SELECT email,gender from smart_table where email="+ ("'"+primary_key+"'");
        System.out.println("Query -> "+query);
        ResultSet rss=stmt.executeQuery(query);
        try
        {
        while(rss.next())
            {
                
                emaill=rss.getString("email");
                gender=rss.getString("gender");    
            }
            if(gender.equalsIgnoreCase("male"))
                img="'"+"../image/user_logo.png"+"'";
            else
                img="'"+"../image/female_user_logo.png"+"'";

            img1="'"+"../image/signin.png"+"'";
            img2="'"+"../image/register.png"+"'";
        }
        catch(Exception e)
        {
            System.out.println("From Profile.jsp : "+e);
        }
        stmt.close();
        rss.close();
        OD.DB_CLOSER(com);
        }
        else
        {
            System.out.println("Email not found in dashboard ");
            login="needed";
        }
    }
    else
    {
        login="needed";
    }

    System.out.println("Session from -> "+login);

%>




























<!DOCTYPE html>
<html lang="en">
<head>
        <title>SMART</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script type="" src="../external_libs/jquery.js"></script>
        <script type="" src="../external_libs/jQuery_cycle.js"></script>
        <script type="text/javascript" src="../external_libs/dashboardtab.js"></script>
        <link rel="stylesheet" href="../css/w3.css">
        <link rel="stylesheet" href="../css/bootstrap.min.css">
        <link rel="stylesheet" href="../css/mystyle.css">
        <link rel="stylesheet" href="../css/w3-colors-flat.css">
		<link rel="stylesheet" href="../css/w3-colors-metro.css">
		<link rel="stylesheet" href="../css/w3-colors-win8.css">
		<link href="https://fonts.googleapis.com/css?family=Alfa+Slab+One" rel="stylesheet">
		<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-colors-win8.css">
		<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
		<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-colors-flat.css">
		<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-colors-metro.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.cycle/3.0.3/jquery.cycle.all.js"></script>

        	
       <script>
	    $(document).ready(function(){
	    $('.slide_end').cycle({ 
	   fx : 'fade,zoom,turnDown,curtainX,uncover,curtainY',
	   randomizeEffects: 1,
	   requeueOnImageNotLoaded: true,
	   pause: 0,
	   pauseOnPagerHover: 0,
	    sync:  true, 
	    delay: 4000 
	        });
	    });
    	</script>

      	<script>
	    $(document).ready(function(){
	    $('.slide_start').cycle({ 
	   fx : 'fade',
	   randomizeEffects: 1,
	   requeueOnImageNotLoaded: true,
	   pause: 0,
	   pauseOnPagerHover: 0,
	    sync:  true, 
	    delay: 2000 
	        });
	    });
	    </script>


    </head>
</head>
<body >
		<div class="w3-animate-zoom w3-card-4 w3-container w3-metro-blue w3-top w3-mobile" style="width:100%;height:62px;z-index: 100">
			<table border="0" class="w3-animate-zoom w3-display-topmiddle">
				<tr>
					<td style="text-align: center;"> <font class=" w3-animate-zoom w3-wide w3-xlarge w3-opacity-min " style="font-family: cursive"> SMART</font>
					</td>
				</tr>
				<tr>
					<td><font class="w3-animate-zoom  w3-wide w3-tiny w3-opacity-min " style="font-family: cursive"> (Simple Medical Assistant for Rapid Treatment)</font>
					</td>
				</tr>
				
			</table>
			
			<% 
            if(login.equalsIgnoreCase("not"))
            {
            out.write("<form action='http://localhost:8080/SMART/html/profile.jsp' action='get'><button style='background: transparent; border:0;outline: none'><div class='w3-animate-zoom w3-hover-opacity w3-hover-white w3-card-4 w3-ripple w3-white w3-display-topleft w3-round-small w3-xlarge w3-mobile w3-margin-left' style='margin-top: 0.5%'><table border='0' class='w3-animate-zoom w3-left w3-mobile'><tr><td style='text-align: center;'><img src="+img+" width='40' height='40'><br></td><td style='text-align: center;'>&nbsp;&nbsp;<font class='w3-animate-zoom w3-small' style='font-family: cursive'>"+emaill+"</font>&nbsp;&nbsp;</td></tr></table></div></button></form>");
             }
            else
            {
                out.write("<div class='w3-animate-zoom w3-right ' style='height: 20%;width:20%' ><table border='0' cellpadding='10' class='w3-display-right'><tr><td><a href='register.html' style='text-decoration:none'<div class=' w3-dropdown-hover w3-animate-zoom  w3-large w3-card-4 w3-round-large' style='background-color: powderblue;font-weight: bolder;'><div class=' w3-dropdown-hover w3-animate-zoom w3-button w3-large w3-card-4 w3-round-large' style='background-color: powderblue;font-weight: bolder;'><font class='w3-text-white'>Login</font></div></div></a></td><td><a href='register.html' style='text-decoration:none'><div class=' w3-dropdown-hover w3-animate-zoom  w3-large w3-card-4 w3-round-large' style='background-color: powderblue;font-weight: bolder;'><div class=' w3-dropdown-hover w3-animate-zoom w3-button w3-large w3-card-4 w3-round-large' style='background-color: powderblue;font-weight: bolder;'><font class='w3-text-white'>Register</font></div></a></td></tr></table></div>");
            }
            %>


	</div><br><br><br>
    
    <div class="w3-animate-zoom w3-display-container  w3-white w3-card-4  " style="width:100%" id="home">
    	<div class="slide_start w3-container" style="z-index: -0.5">
       <img src="../image/dashboard_back.jpg" alt="titleimg"  class="w3-animate-zoom w3-display-leftmiddle w3-opacity-min" width="100%" height="673px">
       <img src="../image/slide2.jpg" alt="titleimg"  class="w3-animate-zoom w3-display-leftmiddle w3-opacity-min" width="100%" height="673px">
       <img src="../image/slide3.jpg" alt="titleimg"  class="w3-animate-zoom w3-display-leftmiddle w3-opacity-min" width="100%" height="673px">
       <img src="../image/slide4.jpg" alt="titleimg"  class="w3-animate-zoom w3-display-leftmiddle w3-opacity-min" width="100%" height="673px">
       <img src="../image/slide5.jpg" alt="titleimg"  class="w3-animate-zoom w3-display-leftmiddle w3-opacity-min" width="100%" height="673px">
       <img src="../image/slide6.jpg" alt="titleimg"  class="w3-animate-zoom w3-display-leftmiddle w3-opacity-min" width="100%" height="673px">
   </div>
       <div class="w3-animate-fade w3-display-right  w3-margin-right w3-right w3-xlarge" style="z-index: 10">
          <div style="font-family:cursive;font-weight: bolder;" class="w3-animate-fade w3-jumbo w3-text-white w3-right w3-wide">S M A R T</div><br>
          <h3 class="w3-animate-zoom  w3-text-white w3-right w3-xlarge w3-wide  " style="font-family: cursive;font-weight: bolder;">Simple Medical Assitant Rapid for Treatment</h3>
          <br><br><br><button class="w-animate-fade  w3-button w3-text-white w3-card-4 w3-right w3-xlarge w3-metro-blue w3-round-large"><strong>ABOUT US</strong></button>
       </div>

       
    </div>    <br><br><br><br>

    
    <table align="center" width="90%">
        <tr>
            <td align="center"><div id="slide" class="w3-animate-zoom   w3-xlarge  w3-text-white card bg-primary w3-hover-light-blue">
                    <div class="w3-animate-zoom card-img-top w3-medium"/>
                <div class="w3-animate-zoom card-body"><h1>Symtoms Analysis</h1><br>Give Your Symtoms<br> & know about diesease</div>
            </div></td>
            <td align="center"><div class="text-white">
                    <div class="w3-animate-zoom card-body"><h1>Health Analysis</h1><br>Generate Health<br>Report<br><br></div>
            </div></td>
            <td align="center">
            	<div class="w3-animate-zoom  slide text-white w3-card-4  card bg bg-primary w3-hover-light-blue" >
                    <div class="w3-animate-zoom card-body"><h1>Health Analysis</h1><br>Generate Health<br>Report</div>
            </div>
			</td>
        </tr>
        <tr>
        	<td align="center"><div class="w3-animate-zoom text-white" style="background-color: transparent;"/></td>

        	<td align="center"><div class="w3-animate-zoom slide w3-card-4  w3-text-white w3-light-blue w3-hover-blue">
                    <div class="w3-animate-zoom card-img-top w3-large"/>
                    <div class="w3-animate-zoom card-body"><h1>Reports</h1><br>Know about Medical Reports<br></div>
            </div>
        	</td>


        	<td align="center"><div class="w3-animate-zoom text-white" style="background-color: transparent;">
                    <div class="w3-animate-zoom card-img-top fa fa-stethoscope w3-large"/>
                    <div class="w3-animate-zoom card-body"></div>
            </div>

        	</td>

        	<td align="center"><div class="w3-animate-zoom slide w3-card-4  w3-light-blue w3-text-white w3-hover-blue">
                    <div class="w3-animate-zoom card-body"><h1>Diet Chart</h1><br>Get information about your<br>diet to prevent diseases</div>
            </div>
        	</td>
        </tr>
    </table><br><br><br><br><br><br>

    <div class="w3-animate-zoom w3-container ">
    	<table style="width:100%" border ="0">
    		<tr>
    			<td style="text-align: center;"> 
    				<img src="../image/BMI chart.jpg" id="bmichart" alt="Lights" width="70%" height="440px" class="w3-animate-zoom w3-margin-left w3-card-2">
    			</td>
    			<td style="width: 50%">
    				<div class="w3-animate-zoom w3-container white">

    					<table class="w3-animate-zoom  w3-container w3-margin-right" width="450px">
    						<tr>
    							<td>
    								<br>
    								<div class="w3-animate-zoom w3-container w3-metro-blue w3-card-4" style="text-align: center;">
    									<label class="w3-animate-zoom w3-text w3-text-white w3-xlarge" style="font-family: cursive;"> Know Your BMI <sub>(body mass index)</sub></label>
    								</div>
    								<br>
    							</td>
    						</tr>
                    <tr><td><input type="number"  placeholder="Weight in kg ..." class="w3-animate-zoom  w3-card-4 w3-input w3-bottombar w3-border-blue" id="wgt"><br></td></tr>
                    <tr><td><input type="number" placeholder="Height in m ..." class="w3-animate-zoom w3-card-4  w3-input w3-bottombar w3-border-blue" id="hgt" ><br></td></tr>
                    <tr>
                        <td>
                            <button class="w3-button w3-teal w3-card-4 w3-round-small w3-animate-zoom " style="outline: none" onclick="hello()">Calculate</button>
                          
                            <div class="w3-animate-zoom w3-card-4 w3-white">
                            	 <center>
                            	<p id="demo" onclick="demoshow()">      </p>
                            <p id="demo1">      </p></center>
							</div>
                        </td>
                        
                    </tr>
            		
            		</table>
    				</div>
    			</td>
    		</tr>
    	</table>
            
           <!-- <div class=" w3-container w3-yellow">
            <table class=" w3-container w3-margin-right" width="450px">
                    <tr><td><input type="number" placeholder="Weight in kg" class="w3-input w3-bottombar w3-border-blue" id="wgt"><br></td></tr>
                    <tr><td><input type="number" placeholder="Height in m" class="w3-input w3-bottombar w3-border-blue" id="hgt"><br></td></tr>
                    <tr>
                        <td>
                            <button class="w3-button w3-teal" onclick="hello()">Calculate</button>
                            <p id="demo" onclick="demoshow()">      </p>
                            <p id="demo1">      </p></td>
                    </tr>
            </table>
        </div>-->
          </div> <br><br><br><br>
    
   <!-- <table align="center" width="90%" height="400px">
        <tr align="center">
            <td class="sidetab"><button class="w3-white w3-bar w3-border-blue" onclick="openTab('search')">Most Searched Diseases </button></td>
            <td rowspan="5" width="70%">
                <div id="search" class="w3-container w3-display-container city">
                    <span onclick="this.parentElement.style.display='none'" class="w3-button w3-large w3-display-topright"> </span>
                    <img src="../image/most searched.png" height="400px" width="500px">
                </div>

                <div id="genetic" class="w3-container w3-display-container city" style="display:none">
                    <span onclick="this.parentElement.style.display='none'" class="w3-button w3-large w3-display-topright"> </span>
                    <img src="../image/genetic.jpg" height="400px" width="500px">
                </div>
                          
                <div id="stress" class="w3-container w3-display-container city" style="display:none">
                    <span onclick="this.parentElement.style.display='none'" class="w3-button w3-large w3-display-topright"> </span>
                    <img src="../image/stress life.jpg" height="400px" width="500px">
                </div>
    
                <div id="food" class="w3-container w3-display-container city" style="display:none">
                    <span onclick="this.parentElement.style.display='none'" class="w3-button w3-large w3-display-topright"> </span>
                    <img src="../image/diet.jpg" height="400px" width="700px">
                </div>
            </td>
        </tr>
        <tr align="center">
            <td class="sidetab">
                <button class="w3-white w3-bar w3-border-blue" onclick="openTab('genetic')">Genetic Diseases</button>
            </td>
        </tr>
        <tr align="center">
            <td class="sidetab"><button class="w3-white w3-bar w3-border-blue" onclick="openTab('stress')">Lifestyle Problems</button></td>
        </tr>
        <tr align="center">
            <td class="sidetab"><button class="w3-white w3-bar w3-border-blue" onclick="openTab('food')">Diet</button></td>
        </tr>
    </table>-->
	
	<center>
		<div class="w3-animate-zoom slide_end w3-white w3-container" style="width:100%;height:100%;text-align: right;" >
	<center><img src="../image/most searched.png" class="w3-animate-zoom   w3-round w3-padding w3-border " height="500px" width="1000px"></center>
	<center><img src="../image/health.jpg" class="w3-animate-zoom   w3-round w3-padding w3-border" height="500px" width="1000px"></center>
	<center><img src="../image/diet.jpg" class="w3-animate-zoom  w3-round w3-padding w3-border" height="500px" width="1000px"></center>
	<center><img src="../image/BMI imp.png" class="w3-animate-zoom  w3-round w3-padding w3-border" height="500px" width="1000"></center>
	</div></center>
<br><br><br><br>
    <footer align="center" style="padding:14px;" class="w3-animate-zoom w3-container w3-metro-blue w3-opacity-min"><center><label class="w3-text-white" style="width: 90%"> Copyright <sup>&copy;</sup> SMART is only for education and simulation ,learning purposes</label></center></footer>
</body>
</html>
