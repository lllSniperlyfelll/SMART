package Think;


import java.io.*;
import java.util.*;
//import DataStore.STOREDATA;
import MakeClass.MAKECLASS;

public class THINK 
{
	ArrayList<Double> class_probability=new ArrayList<Double>();

	void getClassProbability(MAKECLASS MC)
	{
		
		String disease="";
		Iterator itr=MC.feature_classes.iterator();
		double class_prob=0;
		while(itr.hasNext())
		{
			Iterator raw_itr=MC.raw_classes.iterator();
			disease=itr.next().toString().toLowerCase();
			while(raw_itr.hasNext())
			{
				String classs=raw_itr.next().toString().toLowerCase();
				if( disease.equals(classs) )
				{
					class_prob++;
				}
			}
			class_prob=class_prob/(double)MC.count;
			this.class_probability.add(class_prob);

		}
		System.out.println("Class Probabilities -> "+this.class_probability);
	}

 public void getPrintData()
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
	 }
}
/*
class THINK
{
public static void main(String args[])
	 {
	 	THINK1 l= new THINK1();

	 	l.getPrintData();
	 }
}*/