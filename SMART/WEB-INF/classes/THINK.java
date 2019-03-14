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


	boolean arrayIsAllZero(ArrayList<Double> list)
	{
		Iterator itr=list.iterator();
		while(itr.hasNext())
		{
			if(Double.parseDouble(itr.next().toString())>0.0)
			{
				//System.out.println("return false");
				return false;
			}
		}
				//		System.out.println("return true");
		return true;
	}

	ArrayList <String> getSymptomCluster(MAKECLASS MC,String feature_disease_val)
	{
		ArrayList<String> Symptoms=new ArrayList<>();
		Symptoms.clear();
		Iterator itr=MC.raw_classes.iterator();
		Iterator itr_symps=MC.symptoms.iterator();
		while(itr.hasNext() && itr_symps.hasNext())
		{
			String raw_disease_val=itr.next().toString().toLowerCase();
			String raw_symps=itr_symps.next().toString().toLowerCase();
			if(raw_disease_val.equals(feature_disease_val))
			{
				Symptoms.add(raw_symps);
			}
		}
		return(Symptoms);
	}
	void diseasePrediction(ArrayList<String> isymptoms,ArrayList<String> idays,MAKECLASS MC,ArrayList<Double> class_count,ArrayList<Double> class_probability)
	{
		Iterator itr=MC.feature_classes.iterator();
		Iterator class_count_itr=class_count.iterator();
		Iterator class_probability_itr = class_probability.iterator();
		ArrayList<String> sym_cluster=new ArrayList<>();
		ArrayList<Double> symptom_probablities=new ArrayList<>();

		while(itr.hasNext() && class_count_itr.hasNext() && class_probability_itr.hasNext())
		{
			String feature_disease_val=itr.next().toString().toLowerCase();
			Double class_count_val=Double.parseDouble(class_count_itr.next().toString());
			Double class_probability_val=Double.parseDouble(class_probability_itr.next().toString());

			sym_cluster.clear();
			sym_cluster.addAll(getSymptomCluster(MC,feature_disease_val));
			System.out.println("feature_disease_val -> "+feature_disease_val+" And  Symptoms cluster ->" +sym_cluster);
			Iterator input_symptoms_itr=isymptoms.iterator();
			ArrayList<Double> temp_probabilities=new ArrayList<>();
			temp_probabilities.clear();

			while(input_symptoms_itr.hasNext())
			{
				String isym=input_symptoms_itr.next().toString().toLowerCase();
				double sym_count=0;
				Iterator sym_cluster_itr=sym_cluster.iterator();
				while(sym_cluster_itr.hasNext())
				{
					String sym_cluster_val=sym_cluster_itr.next().toString().toLowerCase();
					if(sym_cluster_val.equals(isym))
					{
						sym_count++;
					}
				}
				System.out.println("symptom match count -> "+sym_count);
				System.out.println("Symptom match count / class_count_val : "+sym_count+"/"+class_count_val);
				Double sym_count_new=sym_count/class_count_val;
				System.out.println("Symptom match count new value -> "+sym_count_new);
				temp_probabilities.add(sym_count_new);


			}
		System.out.println(" Above added to array list ->"+temp_probabilities);
		if(arrayIsAllZero(temp_probabilities)==false)
			{
				Iterator itrr=temp_probabilities.iterator();
									double product=1;
				while(itrr.hasNext())
				{

					double value=Double.parseDouble(itrr.next().toString());
					if(value!=0.0)
					{
						System.out.println("value is -> "+value);
						product*=value;
					}
				}
				System.out.println("product value is -> "+product);
				System.out.println("after multiplying product value with class probability"+product+"*"+class_probability_val);
				product*=class_probability_val;
				System.out.println("val of product is product -> "+product);

				symptom_probablities.add(product);

			}
		else
			symptom_probablities.add(0.0);


		}
		System.out.println("Final symptom_probablities are -> "+symptom_probablities);
		//System.out.println("feature_classes ->"+MC.feature_classes);
		/*System.out.println("MC.symptoms -> "+MC.symptoms);
		while(itr.hasNext())
		{
			//System.out.println("In loop 1");
			String feature_disease=itr.next().toString();
			feature_disease=feature_disease.toLowerCase();

			Iterator itr1=MC.raw_classes.iterator();
			Iterator raw_sym_itr=MC.symptoms.iterator();

			while(itr1.hasNext() && raw_sym_itr.hasNext())
			{*/
							//System.out.println("In loop 2");
				/*String raw_disease=itr1.next().toString();
				
				String raw_symptoms=raw_sym_itr.next().toString();

				raw_symptoms=raw_symptoms.toLowerCase();

				raw_disease=raw_disease.toLowerCase();
				System.out.println("raw_symptoms -> "+raw_symptoms);

				feature_disease=itr.next().toString().toLowerCase();
				if(raw_disease.equals(feature_disease))
					{				
					Iterator itr2=isymptoms.iterator();
					while(itr2.hasNext())
					{*/
									//System.out.println("In loop 3");
						//String isym=itr2.next().toString().toLowerCase();
						//

						/*if(isym.equals(raw_symptoms))
							System.out.println("raw_disease ->  "+raw_disease+"  feature_disease -> "+feature_disease);
							System.out.println("SYmptom -> "+ isym);
						*/

				//	}

				//}
				//	else
				//		break;
				
			//}
		}
	
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
			//System.out.println("For disease -> "+disease+"  class count is : "+class_prob);
			this.class_count.add(class_prob);
			class_prob=class_prob/(double)MC.count;
			this.class_probability.add(class_prob);

		}
		System.out.println("Class Probabilities -> "+this.class_probability);
		System.out.println("Class Count -> "+this.class_count);
		diseasePrediction(this.ip_symptoms,this.ip_days,MC,class_count,class_probability);
	}

 public void getPrintData(ArrayList<String> input_symptoms,ArrayList<Integer> input_days)
	 {
	 	MAKECLASS MC=new MAKECLASS();
	 	System.out.println("Called MAKECLASS from think");
	 	MC.MakeClass();

	//	System.out.println("Total Number of disease -> "+MC.count);
	//	System.out.println("og classes -> "+MC.raw_classes);
	//	System.out.println("feature_classes classes -> "+MC.feature_classes);
	//	System.out.println("Symptoms-> "+MC.symptoms);
	//	System.out.println("Days-> "+MC.days);
	//	System.out.println("Input Symptoms from THINK-> "+input_symptoms);
		this.ip_symptoms.addAll(input_symptoms);
		Iterator itr=input_days.iterator();
		while(itr.hasNext())
		 {
		 	String j=itr.next().toString();
		 	this.ip_days.add(j);
		 }
		 //System.out.println("Input days from THINK ->"+ip_days);
		 		 getClassProbability(MC);
	}
}
