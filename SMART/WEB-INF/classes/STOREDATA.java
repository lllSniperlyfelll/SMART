
package DataStore;
import java.io.*;
import java.util.*;

public class STOREDATA
{
	static ArrayList<String> Symptoms=new ArrayList<String>();
	static ArrayList<Integer> Days=new ArrayList<Integer>();
	public void setData(ArrayList<String> symptoms,ArrayList<Integer> days)
	{
		this.Symptoms.clear();
		this.Days.clear();
		this.Symptoms.addAll(symptoms);
		this.Days.addAll(days);
	}
	public ArrayList<String> getSymptoms()
	{
		return(this.Symptoms);
	}
	public ArrayList<Integer> getDays()
	{
		return(this.Days);
	}
}