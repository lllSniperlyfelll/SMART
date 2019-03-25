package DataStorage;
import java.io.*;
import java.util.*;
import static java.lang.System.out;

public class STORAGE
{
static ArrayList<String> output_data=new ArrayList<>();
static String s_key="";
public  void STORAGE_set(ArrayList<String> output_data,String s_key)
	{
		this.s_key=s_key;
		this.output_data.clear();
		this.output_data.addAll(output_data);
	}
public  ArrayList<String> SUB_STORAGE_get()
	{
		out.println("Data from storage -> "+this.output_data);
		return(this.output_data);
	
	}
public String  getSessionKey()
	{
		out.println("S_key from storage -> "+this.s_key);
		return(this.s_key);
	
	}
}


/*class STORAGE
{
	public static void main(String args[])
	{
		STORAGE1 ST=new STORAGE1();
		ArrayList<String> a=new ArrayList<>();
		a.add("hello");
		a.add("Working");
		ST.STORAGE_set(a);
		SUB_STORAGE SS=new SUB_STORAGE();
		out.println("Data is -> "+SS.SUB_STORAGE_get());
	}
}*/