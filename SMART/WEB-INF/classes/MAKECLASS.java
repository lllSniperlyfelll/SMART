package PredictionLogic;

import java.io.*;
import java.util.*;
 
public class MAKECLASS
{
	public ArrayList<String> raw_classes=new ArrayList<String>();
	public ArrayList<String> symptoms=new ArrayList<String>();
	public ArrayList<String> days=new ArrayList<String>();
	public  ArrayList<String> input_symptoms=new ArrayList<String>();
	public  ArrayList<String> input_days=new ArrayList<String>();
	public ArrayList<String> feature_classes=new ArrayList<String>();
	public int count=0;
String getLHS(String data)
	{
		String lhs="";
		for(char i:data.toCharArray())
		{
			if(i==',')
				break;
			else
			{
				if(i!=' ')
					lhs+=(Character.toString(i));
			}
		}
		return(lhs);
	}
 	public void MakeClass()
		{
		this.raw_classes.clear();
		this.feature_classes.clear();
		System.out.println("!**! THIS CODE IS USED TO GET THE ACTUALL NUMBER AND NAMES OF CLASSES(DISEASES) FROM THE RAW DATASET HENCE REMOVING DULPICATE OF DISEASES\n");
		String traindata="test";
		String raw_data;
		
		String data[]=new String[1000];
		try
		{
			File file=new File("disease_dataset.csv");
			System.out.println("Path -> "+file.getAbsolutePath());
			System.out.println("Im in make class");
			BufferedReader br=new BufferedReader(new FileReader("C:/xampp/tomcat/webapps/SMART/WEB-INF/classes/disease_dataset.csv"));
			while(traindata!=null)
			{
				traindata=br.readLine();
				if(traindata!=null)
				{
				this.count++;
				data=traindata.split(",");
				this.raw_classes.add(data[0]);
				this.symptoms.add(data[1]);
				this.days.add(data[2]);
				}
			}
			System.out.println("File opened");
			Iterator itr=this.raw_classes.iterator();
			while(itr.hasNext())
			{	
				if( (itr.next().toString()).equals("") )
					itr.remove();
			}			
			Iterator itrr=this.raw_classes.iterator();
			while(itrr.hasNext())
			{
				raw_data=itrr.next().toString();
				if(this.feature_classes.contains(raw_data)==false)
				{
					this.feature_classes.add(raw_data);
				}
			}
		}
		

		catch(Exception e)
		{
			System.out.println("Form MAKECLASS -> getTranningData : "+e);
		}
	}
}
