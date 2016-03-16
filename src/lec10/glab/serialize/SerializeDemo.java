package lec10.glab.serialize;

import java.io.*;
import java.util.ArrayList;



public class SerializeDemo
{
   public static void main(String [] args)
   {
	   
	  ArrayList<Student> stuNames =  new ArrayList<>();
       stuNames.add(new Student("David",2014));
       stuNames.add(new Student("Gyan",2014));
       stuNames.add(new Student("Melissa",2014));
       stuNames.add(new Student("Mathew",2014));
       stuNames.add(new Student("Arjun",2014));
       stuNames.add(new Student("Drew",2014));


       String strCurrentDir = System.getProperty("user.dir");


      try
      {
         FileOutputStream fos =
         new FileOutputStream(strCurrentDir + "/stuNames.ser");
         ObjectOutputStream oos =
                            new ObjectOutputStream(fos);
         oos.writeObject(stuNames);
         oos.close(); //flushes and closes
          fos.close();
      }catch(IOException e)
      {
          e.printStackTrace();
      }
   }
}