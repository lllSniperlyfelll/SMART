var health_rating=0;

function analyze(option) 
{
    var temp;
    if (option == "1") 
    {
        var systolic_pressure = document.getElementById("systolic_p").value;
        var distolic_pressure = document.getElementById("diatolic_p").value;
        
        if (systolic_pressure<=120 && distolic_pressure >=80)
           { document.getElementById("btnBP").innerHTML="Normal Pressure"; health_rating+=1; }
        else if(systolic_pressure>120 && distolic_pressure>80)
            { document.getElementById("btnBP").innerHTML="High Pressure";}
        else if(systolic_pressure<120 && distolic_pressure<80)
            { document.getElementById("btnBP").innerHTML="Low Pressure";}
    }
    else if(option == "2")
    {
        var height = document.getElementById("height").value;
        var weight = document.getElementById("weight").value;
        var bmi=weight/Math.pow(height,2);
        if(bmi<18.5)
        { document.getElementById("btnBMI").innerHTML="Underweight";}
        else if(bmi>18.5 && bmi<24.9)
        {document.getElementById("btnBMI").innerHTML="Normal Weight"; health_rating+=1;}
        else if(bmi>25.0 && bmi<29.9)
        {document.getElementById("btnBMI").innerHTML="Over Weight";}
        else if(bmi>=30)
        {document.getElementById("btnBMI").innerHTML="Obesity";}
    }
    else if(option == "3")
    {
        var HDL=document.getElementById("hdl").value;
        var LDL=document.getElementById("ldl").value;
        if(HDL>40 && HDL<60)
        {document.getElementById("btnSugar").innerHTML="Normal"; health_rating+=1;}
        else
        {document.getElementById("btnSugar").innerHTML="Risk";}
        if(LDL>100 && LDL<130)
        {document.getElementById("btnSugar").innerHTML="Normal"; health_rating+=1;}
        else
        {document.getElementById("btnSugar").innerHTML="Risk";}
    }
    else if(option == "4")
    {
        var alc=document.getElementById("alc");
        if(alc.checked==true)
        { alert("alchol");}
    }
    else if(option == "5")
    { 
        var water=document.getElementById("water").value;
        if(water>=2)
        {
            document.getElementById("pSugar").innerHTML="Good";
            health_rating+=1;
        }
    }
    else if(option == "6")
    {
        var sleep=document.getElementById("sleep").value;
        if(sleep<7)
        {document.getElementById("pSleep").innerHTML="According to doctors we should <br> sleep for minium for 7Hrs outof 24hrs";}
    }
    else if(option=="7")
     alert(health_rating);
}
