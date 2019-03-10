package PredictionLogic;


import java.io.*;
import java.util.*;
import PredictionLogic.MAKECLASS;

public class THINK 
{
	ArrayList<Double> class_probability=new ArrayList<Double>();
	ArrayList<Double> class_count=new ArrayList<Double>();
	ArrayList<String> ip_days=new ArrayList<String>();
	ArrayList<String> ip_symptoms=new ArrayList<String>();


	void getClassProbability(MAKECLASS MC)
	{
		
		String disease="";
		Iterator itr=MC.feature_classes.iterator();
		double class_prob=0;
		while(itr.hasNext())
		{
			Iterator raw_itr=MC.raw_classes.iterator();
			disease=itr.next().toString().toLowerCase();
			class_prob=0;
			while(raw_itr.hasNext())
			{
				String classs=raw_itr.next().toString().toLowerCase();
				if( disease.equals(classs) )
				{
					class_prob++;
				}
			}
			System.out.println("For disease -> "+disease+"  class count is : "+class_prob);
			this.class_count.add(class_prob);
			class_prob=class_prob/(double)MC.count;
			this.class_probability.add(class_prob);

		}
		System.out.println("Class Probabilities -> "+this.class_probability);
	}

 public void getPrintData(ArrayList<String> input_symptoms,ArrayList<Integer> input_days)
	 {
	 	MAKECLASS MC=new MAKECLASS();
	 	System.out.println("Called MAKECLASS from think");
	 	MC.MakeClass();
		 getClassProbability(MC);
		System.out.println("Total Number of disease -> "+MC.count);
		System.out.println("og classes -> "+MC.raw_classes);
		System.out.println("feature_classes classes -> "+MC.feature_classes);
		System.out.println("Symptoms-> "+MC.symptoms);
		System.out.println("Days-> "+MC.days);
		System.out.println("Input Symptoms from THINK-> "+input_symptoms);
		this.ip_symptoms.addAll(input_symptoms);
		Iterator itr=input_days.iterator();
		while(itr.hasNext())
		 {
		 	String j=itr.next().toString();
		 	this.ip_days.add(j);
		 }
		 System.out.println("Input days from THINK ->"+ip_days);
	}
}
