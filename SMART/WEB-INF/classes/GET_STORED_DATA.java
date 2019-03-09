package GetStoredData;

import java.io.*;
import java.util.*;
import DataStore.STOREDATA;

public class GET_STORED_DATA
{

 public void getPrintData()
 {
 	STOREDATA ST = new STOREDATA();
 	System.out.println("GET_STORED_DATA got symptoms -> "+(ST.getSymptoms()));
 	System.out.println("GET_STORED_DATA got days -> "+(ST.getDays()));
 }
}