package InputProccesor;

import java.io.*;
import java.util.*;
import static java.lang.System.out;

public class LANGUAGE_PROCCESSOR
{
	ArrayList<String> dictionary=new ArrayList<String>();
	ArrayList<String> ipsym_copy=new ArrayList<String>();
	ArrayList<Integer> ipdays_copy=new ArrayList<Integer>();

	public void match(ArrayList<String> input_symptoms,ArrayList<Integer> input_days)
	{
		try
		{


		getDictionaryData();
		
		this.ipdays_copy.clear();
		this.ipsym_copy.clear();

		this.ipsym_copy.addAll(input_symptoms);
		this.ipdays_copy.addAll(input_days);

		Iterator itr1= ipsym_copy.iterator();
		//Iterator itr2= ipdays_copy.iterator();
		while(itr1.hasNext())
		{
			String ins=itr1.next().toString().toLowerCase();
			if(!(this.dictionary.contains(ins)))
			{
				ipdays_copy.remove(ipsym_copy.indexOf(ins));
				itr1.remove();
			}
		}
		out.println("Proccesing input SYmptoms in LANGUAGE_PROCCESSOR-> "+this.ipsym_copy);
		/*ArrayList<Integer> ipdays_copy_1=new ArrayList<Integer>();
		ipdays_copy_1.clear();
		ipdays_copy_1.addAll(ipdays_copy);
		this.ipdays_copy.clear();

		Iterator itr3=ipdays_copy_1.iterator();
		while(itr3.hasNext())
		{
			int days=Integer.parseInt(itr3.next().toString());
			if(days<0)
			{
				days*=-1;
				this.ipdays_copy.add(days);
			}

		}*/
	}
	catch(Exception e)
	{
		out.println("From LANGUAGE_PROCCESSOR -> match "+e);
	}
	}

	public ArrayList<String> getProccessedSymptoms()
	{
		return(this.ipsym_copy);
	}

	public ArrayList<Integer> getProccessedDays()
	{
		return(this.ipdays_copy);
	}


	void getDictionaryData()
	{

		String traindata="invalid";
		String data[]=new String[100];
		try
		{
			/*File file=new File("data_dictionary.csv");
			Scanner scanner =new Scanner(file);
			while(scanner.hasNext())
			{
	
				traindata=scanner.next();
				traindata=traindata.replace("_"," ");
				temp=traindata.split(",");
				if(this.dictionary.contains(temp[0])==false)
					this.dictionary.add(temp[0].toLowerCase());
			}
			System.out.println("DATA IN ARRAY LIST -> "+this.dictionary);*/

			BufferedReader br=new BufferedReader(new FileReader("C:/xampp/tomcat/webapps/SMART/WEB-INF/classes/disease_dataset.csv"));
			while(traindata!=null)
			{
				traindata=br.readLine();
				if(traindata!=null)
				{
/*				this.count++;*/
				data=traindata.split(",");
				this.dictionary.add(data[1].replace("_"," ").toLowerCase());
				}
				
			}out.println("Data from dictionary LANGUAGE_PROCESSOR-> "+this.dictionary);
		}
		catch(Exception e)
		{
			System.out.println("From LAUNGUGE_PROCESSOR -> getDictionaryData :"+e);
		}
	}
}

/*class LANGUAGE_PROCESSOR
{
	public static void main(String args[])throws IOException
	{
		LANGUAGE_PROCESSOR_MAIN LPM=new LANGUAGE_PROCESSOR_MAIN();
		String statement;
		LPM.getDictionaryData();
		System.out.println("Enter String -> ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		statement=br.readLine();
		LPM.match(statement);
	}

}*/