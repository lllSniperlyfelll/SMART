
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

public String dis="";
public String sym_data="";
public String days_data="";
ArrayList<String> data=new ArrayList<String>();
ArrayList<String> days=new ArrayList<String>();
ArrayList<String> symp=new ArrayList<String>();
ArrayList<String> dis_info=new ArrayList<String>();
%>

<%

dis="";
sym_data="";
data.clear();
days.clear();
symp.clear();
dis_info.clear();
STORAGE S=new STORAGE();
    data.clear();
    data.addAll(S.SUB_STORAGE_get());
    System.out.println("data from result -> "+data);
    if(data.size()==0)
    {
        response.sendRedirect("noinput.html");
    }
    else
    {
        Iterator itr=data.iterator();
        dis=data.get(0);
        dis=dis.replace("_"," ");
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
            sym_data+="<tr>";
            sym_data+="<td> <font style='font-weight: bolder;' class='w3-text w3-xlarge'><i class='fa fa-plus-square w3-large'></i>&nbsp;&nbsp;"+itr3.next().toString().replace("_"," ")+"</td></font><td><font style='font-weight: bolder;' class='w3-text w3-xlarge'><i class='fa fa-bed'></i> &nbsp;&nbsp;"+itr2.next().toString().replace("_"," ")+" days</td></font>";
            sym_data+="</tr>";
        } 
        dis_info.clear();
        dis_info.addAll(databaseInfo(dis)); 
        if(dis_info.size()==0)
        {
            response.sendRedirect("noinput.html");
        }   
    }  

%>










<%!
protected ArrayList<String> databaseInfo(String disease)
{
        ArrayList<String> info_data=new ArrayList<String>();
    disease="'"+"malaria"+"'";
    String query="SELECT * from diseases where diseases="+disease;
    Connection con=null;
    OPENDATABASE OD=new OPENDATABASE();
    Statement stmt=null;
    ResultSet rss=null;
    try
        {
    con=OD.getInfoDbConnection();

        info_data.clear();
        stmt=con.createStatement();
        rss=stmt.executeQuery(query);
        
        while(rss.next())
            {
                info_data.add(rss.getString("info"));
                info_data.add(rss.getString("precaution"));
                //System.out.println(" info of"+disease+" disease -> "+rss.getString("info"));
 
            }
        stmt.close();
        rss.close();
        OD.DB_CLOSER(con);
        return (info_data);
        }
        catch(Exception e)
        {
            System.out.println("Form RESULT_PAGE.jsp->databaseInfo : "+e);
        }
        return (info_data);
}

%>









<!DOCTYPE html>
<html lang="en">
<head>
        <title>SMART Search result</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="../css/w3.css">
        <link rel="stylesheet" href="../css/bootstrap.min.css">
        <link rel="stylesheet" href="../css/w3-colors-metro.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>

<body >
        <div class="w3-animate-zoom w3-card-4 w3-bar w3-metro-blue w3-top w3-mobile" style="width:100%;height:62px;z-index: 100">
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
    </div><br><br><br>

    <div class=" w3-card-4 w3-margin-right w3-light-blue w3-margin-left w3-display-container w3-round-small">
        <img src="../image/report_back.gif" width="100%" height="400" class="w3-round-small w3-opacity">
        <font style="font-weight: bold;" class="w3-text-white w3-large w3-display-topleft w3-margin-top w3-margin-left">Predicted Disease :</font>
        <font style="font-weight: bolder;" class=" w3-text-white w3-margin-left w3-jumbo w3-display-left"><%out.write(dis); %></font>
        <div class="w3-text-white w3-container w3-display-right" style="font-weight: bolder;width: 70%;height: auto;" >
                    <font class="w3-text-white">

                        <%out.write(dis_info.get(0));%>


            <!--          <p>
<b>About Malaria</b><br>
Malaria is a serious tropical disease spread by mosquitoes. If it isn't diagnosed and treated promptly, it can be fatal.
A single mosquito bite is all it takes for someone to become infected.
</p>
<p>
<b>What causes malaria?</b><br>
Malaria is caused by a type of parasite known as Plasmodium. There are many different types of Plasmodia parasites, but only five cause malaria in humans.
The Plasmodium parasite is mainly spread by female Anopheles mosquitoes, which mainly bite at dusk and at night. When an infected mosquito bites a human, it passes the parasites into the bloodstream.
Malaria can also be spread through blood transfusions and the sharing of needles, but this is very rare.
</p> -->
            </font>
            </div>

        <!-- <table class="w3-table w3-display-middle w3-text-white w3-margin-left" align="center"> 
            <tr><td>Predicted Disease</td>
                <td><i class="fa fa-arrow-right"></i><b>Medical name : </b><label style="font-weight: bolder;">H1N1 influenza</label></td>
            </tr>
            <tr><td rowspan="3"><font style="font-weight: bolder;" class="w3-jumbo"><% out.write(dis);%></font></td>
                <td><i class="fa fa-arrow-right"></i><b>Cause By: </b>H1N1 Virus</td>
            </tr>
                <tr>
                    <td><i class="fa fa-arrow-right"></i><b>Reason of cause: </b>Air borne & contagaous diesease</td>
                </tr>
                <tr>
                    <td><i class="fa fa-arrow-right"></i><b>Target organ: </b>(specify the organ to which this dieases occur if any)</td>
                </tr>
                <tr>
                        <td><i class="fa fa-heartbeat w3-large"></i>  <b>Vaccine : </b>Available(vacinne name)</td>
                    </tr>
        </table> -->
    </div>

    <br>
    <center>
    <div class="w3-card-4 w3-margin w3-light-blue w3-round-small w3-metro-blue" style="width: 80%">
        <!-- <img src="../image/sym_back.jpg" width="100%" height="400" class="w3-opacity"> -->
        <center><header class=" w3-text-white"><h1>You're Entered Symtoms and Days</h1></header></center>
        <hr style="border-color: white">
        <br>
        <center><table class="w3-table w3-text-white" style="font-weight: bolder;width: 80%" border="0">
            <!-- <tr>
                <td> <font style="font-weight: bolder;" class="w3-text w3-xlarge"><i class="fa fa-plus-square w3-large"></i>  Fever</td></font>
                <td><font style="font-weight: bolder;" class="w3-text w3-xlarge"><i class="fa fa-bed"></i>  5 days</td></font>
            </tr>
            <tr>
                <td><font style="font-weight: bolder;" class="w3-text w3-xlarge"><i class="fa fa-plus-square w3-large"></i>  Sore throat</td></font> 
                <td><font style="font-weight: bolder;" class="w3-text w3-xlarge"><i class="fa fa-bed"></i>  5 days</td></font>
            </tr>
            <tr>
                <td><font style="font-weight: bolder;" class="w3-text w3-xlarge"><i class="fa fa-plus-square w3-large"></i>  Muscele Aches</td> </font>
                <td><font style="font-weight: bolder;" class="w3-text w3-xlarge"><i class="fa fa-bed"></i>  5 days</td></font>
            </tr>
            <tr>
                <td><font style="font-weight: bolder;" class="w3-text w3-xlarge"><i class="fa fa-plus-square w3-large"></i>  Chills</td> </font>
                <td><font style="font-weight: bolder;" class="w3-text w3-xlarge"><i class="fa fa-bed"></i>  5 days</td></font>
            </tr>
            <tr>
                <td><font style="font-weight: bolder;" class="w3-text w3-xlarge"><i class="fa fa-plus-square w3-large"></i>  Fatigue</td> </font>
                <td><font style="font-weight: bolder;" class="w3-text w3-xlarge"><i class="fa fa-bed"></i>  5 days</td></font>
            </tr>
            <tr>
                <td><font style="font-weight: bolder;" class="w3-text w3-xlarge"><i class="fa fa-plus-square w3-large"></i>  Vomiting</td> </font>
                <td><font style="font-weight: bolder;" class="w3-text w3-xlarge"><i class="fa fa-bed"></i>  5 days</td></font>
            </tr>
            <tr>
                <td><font style="font-weight: bolder;" class="w3-text w3-xlarge"><i class="fa fa-plus-square w3-large"></i>  Diarrea</td> </font>
                <td><font style="font-weight: bolder;" class="w3-text w3-xlarge"><i class="fa fa-bed"></i>  5 days</td></font>
            </tr> -->
            <% out.write(sym_data); %>
        </table></center>
    </div></center>

    <br>

<!--     <div class="w3-card-2 w3-margin w3-padding w3-white w3-round-large"> -->
        <center>
    <div class="w3-card-4 w3-margin w3-metro-blue w3-round-small w3-metro-blue" style="width: 80%">
            <header class="w3-text-white"><i class="fas fa-hand-holding-heart"></i> <h2>Precations</h2></header><hr style="border-color: white">
            <!-- <table class="w3-table w3-text-white">
                <tr><td> <font style="font-weight: bolder;" class="w3-text w3-large"><i class="fa fa-medkit"></i> Stay Home</td></font></tr>
                <tr><td><font style="font-weight: bolder;" class="w3-text w3-large"><i class="fa fa-medkit"></i> Wash Hand Frequently</td></tr>
                <tr><td><font style="font-weight: bolder;" class="w3-text w3-large"><i class="fa fa-medkit"></i> Avoid Crowds</td></tr>
                <tr><td><font style="font-weight: bolder;" class="w3-text w3-large"><i class="fa fa-medkit"></i> Vist Docter</td></tr>
            </table> -->
            <font class="w3-text-white w3-large">
            <% out.write(dis_info.get(1)); %>
            </font>
    </div>
    <br><br>
    <a href="dashboard.jsp" style="text-decoration: none">
    <div class="w3-right w3-margin-bottom w3-margin-right w3-round-small w3-button w3-container w3-metro-blue w3-card-4">
        <font class="w3-text-white w3-xxlarge">Back to Dashboard</font>
    </div>
</a>
</center>
    <center><h4>Take care & stay healthy</h4></center>
</body>
</html>
