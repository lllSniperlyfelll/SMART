import java.io.*;
import java.util.*;

class analyzer
{
    analyzer(String sym, String day)
    {
        int testvalue=0;
        ArrayList<String> Nsymtoms= new ArrayList<>();
        Nsymtoms.add("fever");
        Nsymtoms.add("headache");
        Nsymtoms.add("scabs");
        Nsymtoms.add("loss_of_head_support");
        Nsymtoms.add("Severe_headache");
        ArrayList<String> Ndays= new ArrayList<>();
        Ndays.add("1");
        Ndays.add("2");
        Ndays.add("3");
        Ndays.add("4");
        Ndays.add("5");

        //process days----------------------------------------------------------------------------
        try
         { testvalue=Integer.parseInt(day);}
        catch (Exception e)
        { System.out.print("Error! You entered char in days");}
        if(testvalue<=0)
         System.out.print("Error! Days can't be -ve nor zero");
        if (Ndays.contains(day))
         System.out.println("day is valid");
        
        //process symtoms------------------------------------------------------------------------------------
        
        /*for(int i=0;i<sym.length();i++)
        {
            if(!(Character.isLetter(sym.charAt(i))))
                {
                    System.out.println("Invalid input symtoms");
                    break;
                }
        }*/
        for(int i=0;i<Nsymtoms.size();i++)
        {
            if(sym.contains(Nsymtoms.get(i)))
            {
                String single_sym=Nsymtoms.get(i);
                System.out.println("Symtoms-> "+single_sym);
            }
        }
    }
}
class lang_process
{
    public static void main(String a[]) throws Exception
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.print("symtoms-> ");
        String symtoms=br.readLine();
        System.out.print("Days-> ");
        String day=br.readLine();
        new analyzer(symtoms,day);
    }
}
