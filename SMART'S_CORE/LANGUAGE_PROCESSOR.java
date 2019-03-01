import java.io.*;
import java.util.*;

class LANGUAGE_PROCESSOR_MAIN
{
	ArrayList<String> dictionary=new ArrayList<String>();
	protected void match(String statement)
	{
	Iterator itr = this.dictionary.iterator();
		while(itr.hasNext())
		{
		String next_token=(itr.next().toString()).toLowerCase();
		if( (statement.toLowerCase()).contains(next_token))
			System.out.println("Found data in language -> "+next_token);	
		}

	}
	void getDictionaryData()
	{

		String traindata="";
		String temp[]=new String[100];
		try
		{
			File file=new File("data_dictionary.csv");
			Scanner scanner =new Scanner(file);
			while(scanner.hasNext())
			{
				traindata=scanner.next();
				traindata=traindata.replace("_"," ");
				temp=traindata.split(",");
				if(this.dictionary.contains(temp[0])==false)
					this.dictionary.add(temp[0]);
			}
			System.out.println("DATA IN ARRAY LIST -> "+this.dictionary);
		}
		catch(Exception e)
		{
			System.out.println("From LAUNGUGE_PROCESSOR -> getDictionaryData :"+e);
		}
	}
}

class LANGUAGE_PROCESSOR
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

}