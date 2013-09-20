package lec10.serialize;
import java.io.*;
import java.util.ArrayList;

   public class DeserializeDemo
   {
      public static void main(String [] args)
      {
    	  ArrayList<String> strNames =  null;
         try
         {
            FileInputStream fis =
                          new FileInputStream("strStudents.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            strNames = (ArrayList<String>) ois.readObject();
            ois.close();
            fis.close();
        }catch(IOException e)
        {
            e.printStackTrace();
            return;
        }catch(ClassNotFoundException cnf)
        {
            System.out.println("class not found");
            cnf.printStackTrace();
            return;
        }
        
        for (String str : strNames) {
			System.out.println(str);
		}

    }
}