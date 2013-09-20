package lec10.glab.serialize;

import java.io.*;
import java.util.ArrayList;



public class SerializeDemo
{
   public static void main(String [] args)
   {
	   
	  ArrayList<String> strNames =  new ArrayList<String>();
	  strNames.add("Adam");
	  strNames.add("Ken");
	  strNames.add("Wei");
	  strNames.add("Gyan");
	  strNames.add("David");
	  

      try
      {
         FileOutputStream fos =
         new FileOutputStream("strStudents.ser");
         ObjectOutputStream oos =
                            new ObjectOutputStream(fos);
         oos.writeObject(strNames);
         oos.close(); //flushes and closes
          fos.close();
      }catch(IOException e)
      {
          e.printStackTrace();
      }
   }
}