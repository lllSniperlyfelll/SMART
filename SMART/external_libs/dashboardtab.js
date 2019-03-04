

function hello()
{
  var height=parseFloat(document.getElementById("hgt").value);
  var weight=parseFloat(document.getElementById("wgt").value);
  var bmi=weight/height;

  //document.getElementById("button").style.display = "none";
  
  if(bmi<18.5)
  {
    document.getElementById("demo").innerHTML="BMI is "+bmi+" kg/m2";
    document.getElementById("demo1").innerHTML="Your Are Underweight";
  }
  else if(bmi>18.5 && bmi<24.9)
  {
    document.getElementById("demo").innerHTML="BMI is "+bmi+" kg/m2";
    document.getElementById("demo1").innerHTML="Your are Healthy ";
  }
  else if(bmi>25.0 && bmi<29.9)
  {
    document.getElementById("demo").innerHTML="BMI is "+bmi+" kg/m2";
    document.getElementById("demo1").innerHTML="Your Are Overweight";
  }
  else if(bmi>=30)
  {
    document.getElementById("demo").innerHTML="BMI is "+bmi+" kg/m2";
    document.getElementById("demo1").innerHTML="Your Are Obese";
  }
}

function openTab(cityName) {
  var i;
  var x = document.getElementsByClassName("city");
  for (i = 0; i < x.length; i++) {
    x[i].style.display = "none";  
  }
  document.getElementById(cityName).style.display = "block";  
}
