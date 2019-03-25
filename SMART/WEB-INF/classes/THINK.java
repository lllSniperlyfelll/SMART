package PredictionLogic;


import java.io.*;
import java.util.*;
import PredictionLogic.MAKECLASS;
import DataStorage.STORAGE;


public class THINK 
{
	ArrayList<Double> class_probability=new ArrayList<Double>();
	ArrayList<Double> class_count=new ArrayList<Double>();
	ArrayList<String> ip_days=new ArrayList<String>();
	ArrayList<String> ip_symptoms=new ArrayList<String>();
	static ArrayList<String> output_data=new ArrayList<>();
	String se_key="";

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
/*
	boolean matchFound(ArrayList<Double> temp_probabilities,ArrayList<Double> days_temp_probabilities)
	{

		System.out.println("!!!!!!!!Matching!!!!!!");

		if(temp_probabilities.contains(0.0)==true || days_temp_probabilities.contains(0.0)==true)
			return false;
		
		System.out.println("!!!!!!!Match Found!!!!!!!");

		return true;

	}*/

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


	ArrayList <String> getDaysCluster(MAKECLASS MC,String feature_disease_val)
	{
		ArrayList<String> Days=new ArrayList<>();
		Days.clear();
		Iterator itr=MC.raw_classes.iterator();
		Iterator itr_symps=MC.days.iterator();
		while(itr.hasNext() && itr_symps.hasNext())
		{
			String raw_classes_val=itr.next().toString().toLowerCase();
			String raw_days=itr_symps.next().toString().toLowerCase();
			if(raw_classes_val.equals(feature_disease_val))
			{
				Days.add(raw_days);
			}
		}
		return(Days);
	}


	void diseasePrediction(ArrayList<String> isymptoms,ArrayList<String> idays,MAKECLASS MC,ArrayList<Double> class_count,ArrayList<Double> class_probability)
	{
		Iterator itr=MC.feature_classes.iterator();
		Iterator class_count_itr=class_count.iterator();
		Iterator class_probability_itr = class_probability.iterator();
		ArrayList<String> sym_cluster=new ArrayList<>();
		ArrayList<String> days_cluster=new ArrayList<>();
		ArrayList<Double> symptom_probablities=new ArrayList<Double>();
		this.output_data.clear();

		while(itr.hasNext() && class_count_itr.hasNext() && class_probability_itr.hasNext())
		{
			String feature_disease_val=itr.next().toString().toLowerCase();
			Double class_count_val=Double.parseDouble(class_count_itr.next().toString());
			Double class_probability_val=Double.parseDouble(class_probability_itr.next().toString());

			sym_cluster.clear();
			days_cluster.clear();

			sym_cluster.addAll(getSymptomCluster(MC,feature_disease_val));
			days_cluster.addAll(getDaysCluster(MC,feature_disease_val));

			//System.out.println("feature_disease_val -> "+feature_disease_val+" And  Symptoms cluster ->" +sym_cluster);
			//System.out.println("feature_disease_val -> "+feature_disease_val+" And  Days cluster ->" +days_cluster);
			Iterator input_symptoms_itr=isymptoms.iterator();
			Iterator input_days_itr=idays.iterator();

			ArrayList<Double> temp_probabilities=new ArrayList<>();
			temp_probabilities.clear();
			ArrayList<Double> days_temp_probabilities=new ArrayList<>();
			days_temp_probabilities.clear();

			while(input_symptoms_itr.hasNext() && input_days_itr.hasNext())
			{
				String isym=input_symptoms_itr.next().toString().toLowerCase();
				String ipdays=input_days_itr.next().toString();

				double sym_count=0;
				double days_count=0;
				Iterator sym_cluster_itr=sym_cluster.iterator();
				Iterator days_cluster_itr=days_cluster.iterator();

				while(sym_cluster_itr.hasNext()  && days_cluster_itr.hasNext())
				{
					String days_cluster_val=days_cluster_itr.next().toString();
					String sym_cluster_val=sym_cluster_itr.next().toString().toLowerCase();

					if(sym_cluster_val.equals(isym) && days_cluster_val.equals(ipdays))
					{
						sym_count++;
						days_count++;
					}
/*
					if()
					{

					}*/
				}
				
				//System.out.println("symptom match count -> "+sym_count);
				//System.out.println("days match count -> "+days_count);
				Double days_count_new=days_count/class_count_val;
				//System.out.println("Symptom match count / class_count_val : "+sym_count+"/"+class_count_val);
				Double sym_count_new=sym_count/class_count_val;
				//System.out.println("Symptom match count new value -> "+sym_count_new);
				temp_probabilities.add(sym_count_new);
				days_temp_probabilities.add(days_count_new);

			}
		/*System.out.println("temp_probabilities sent for matching-> "+temp_probabilities);
		System.out.println("days_temp_probabilities sent for matching-> "+days_temp_probabilities);
		boolean flag=matchFound(temp_probabilities,days_temp_probabilities);*/
		
		 if(arrayIsAllZero(days_temp_probabilities)==false)
			{
				if(arrayIsAllZero(temp_probabilities)==false)
				{
					temp_probabilities.addAll(days_temp_probabilities);
				}
			}
		

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
				product*=class_probability_val;
				symptom_probablities.add(product);

			}
		else
			symptom_probablities.add(0.0);

		}
		
/*
		if(flag==true)
			break;*/
		
		
		System.out.println("Final symptom_probablities are -> "+symptom_probablities);
		//getLargestProbability(symptom_probablities);
		System.out.println("probablitiy index -> "+symptom_probablities.indexOf(Collections.max(symptom_probablities))+" : probablitiy ->"+symptom_probablities.get(symptom_probablities.indexOf(Collections.max(symptom_probablities)) ));
		System.out.println("Disease predicted is -> "+MC.feature_classes.get(symptom_probablities.indexOf(Collections.max(symptom_probablities)))+" : index number ->"+symptom_probablities.indexOf(Collections.max(symptom_probablities)));
		System.out.println("Dataset disease -> "+MC.feature_classes);
		
		output_data.add(MC.feature_classes.get(symptom_probablities.indexOf(Collections.max(symptom_probablities))));
		output_data.addAll(isymptoms);
		output_data.addAll(idays);
		STORAGE S=new STORAGE();
		S.STORAGE_set(output_data,this.se_key);


		
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

 public void getPrintData(ArrayList<String> input_symptoms,ArrayList<Integer> input_days,String session_name)
	 {
	 	this.se_key=session_name;
	 	MAKECLASS MC=new MAKECLASS();
	 	System.out.println("Called MAKECLASS from think");
	 	MC.MakeClass();
		this.ip_symptoms.addAll(input_symptoms);
		Iterator itr=input_days.iterator();
		while(itr.hasNext())
		 {
		 	String j=itr.next().toString();
		 	this.ip_days.add(j);
		 }
		 		 getClassProbability(MC);
	}
}
