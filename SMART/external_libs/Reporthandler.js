//var health_rating=0;

function analyze() 
{
        var systolic_pressure,distolic_pressure,pressure_result;
        var height,weight,bmi,bmi_result;
        var HDL,LDL,cholestrol_result;
        var water,nodrink,alergies,genetic,sleep,tied,appitite,stamina;
        var health_rating=0,bad_health=0,health_status;
        distolic_pressure = document.getElementById("diatolic_p").value;
        systolic_pressure = document.getElementById("systolic_p").value;
        if(distolic_pressure=="" || systolic_pressure=="")
        {   pressure_result="Can't calculate: check input feilds";}
        else
        {
            if (systolic_pressure<=120 && distolic_pressure >=80)
           {
                 health_rating++;
                 pressure_result="Normal Pressure";
           }
        else if(systolic_pressure>120 && distolic_pressure>80)
            {
                 pressure_result="High Pressure"; bad_health++;
            }
        else if(systolic_pressure<120 && distolic_pressure<80)
            {
                 pressure_result="Low Pressure"; bad_health++;
            }
        }
        
    
        height = document.getElementById("height").value;
        weight = document.getElementById("weight").value;
        if(height=="" || weight=="")
        {   bmi_result="Can't calculate: check input feilds";}
        else
        {
            bmi=weight/Math.pow(height,2);
            if(bmi<18.5)
            {     bmi_result="Underweight"; bad_health++; }
            else if(bmi>18.5 && bmi<24.9)
            {
                health_rating+=1;
                bmi_result="Normal Weight";
            }
            else if(bmi>25.0 && bmi<29.9)
            {   bmi_result="Over Weight";   bad_health++;  }
            else if(bmi>=30)
            {   bmi_result="Obesity";     bad_health++;  }
        }
        
        HDL=document.getElementById("hdl").value;
        LDL=document.getElementById("ldl").value;
        if(HDL=="" || LDL=="")
        {   cholestrol_result="Can't calculate: check input feilds";}
        else
        {
            if((HDL>40 && HDL<60) && (LDL>100 && LDL<130))
            {
                 health_rating+=1;
                cholestrol_result="Normal";
            }
            else
            {   cholestrol_result="Risk";  bad_health++; }
        }
        
        

        water=document.getElementById("water").value;
        if(water>=2)
        {   health_rating+=1; }
        else
            bad_health++;

        nodrink=document.getElementById("no");
        if(nodrink.checked==true)
        { health_rating++; }
        else
            bad_health++;

        alergies=document.getElementById("alg_yes");
        if(alergies.checked==true)
        { health_rating++; }
        else
            bad_health++;

        genetic=document.getElementById("g_diseases");
        if(genetic.checked==true)
        { health_rating++; }

        sleep=document.getElementById("sleep").value;
        if(sleep>7)
        { health_rating++; }
            bad_health++;

        tied=document.getElementById("tiedness");
        if(tied.checked==true)
        { bad_health++; }

        appitite=document.getElementById("appitite");
        if(appitite.checked==true)
        { bad_health++; }

        stamina=document.getElementById("stamina");
        if(stamina.checked==true)
        { bad_health++; }

            health_status=(health_rating)/(health_rating+bad_health);
            health_status*=100;
        alert("Blood Pressure: "+pressure_result+
              "\nBMI: "+bmi_result+
              "\nCholestrol: "+cholestrol_result+
              "\n Health Status: "+health_status.toFixed(2)+"%"+
              "\n\n Please fill all feilds to get accurate health status");
        
}
