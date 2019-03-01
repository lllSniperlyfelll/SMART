import java.io.*;
import java.util.*;
 
class MAKECLASS
{

	static String getLHS(String data)
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



	static void getTranningData()
	{
		ArrayList<String> raw_classes=new ArrayList<String>();
		ArrayList<String> feature_classes=new ArrayList<String>();
		String traindata="";
		String raw_data;
		int disease_count=0;
		try
		{
			File file=new File("disease_dataset.csv");
			Scanner scanner =new Scanner(file);
			while(scanner.hasNext())
			{
				traindata=scanner.next();
				traindata=traindata.replace(" ","");
				raw_classes.add(getLHS(traindata).replace(" ",""));
			}
			Iterator itr=raw_classes.iterator();
			while(itr.hasNext())
			{	
				if( (itr.next().toString()).equals("") )
					itr.remove();
			}			
			Iterator itrr=raw_classes.iterator();
			while(itrr.hasNext())
			{
				raw_data=itrr.next().toString();
				if(feature_classes.contains(raw_data)==false)
				{
					disease_count++;
					feature_classes.add(raw_data);
				}
			}
			System.out.println("Feature Classes -> "+feature_classes);
			System.out.println("\n ACTUAL NUMBER OF DISEASES -> "+disease_count);
		}
		catch(Exception e)
		{
			System.out.println("Form MAKECLASS -> getTranningData : "+e);
		}
	}
	public static void main(String args[])
	{
		System.out.println("!**! THIS CODE IS USED TO GET THE ACTUALL NUMBER AND NAMES OF CLASSES(DISEASES) FROM THE RAW DATASET HENCE REMOVING DULPICATE OF DISEASES\n");
		getTranningData();
	}

}