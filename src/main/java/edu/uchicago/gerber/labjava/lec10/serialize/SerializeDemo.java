package edu.uchicago.gerber.labjava.lec10.serialize;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class SerializeDemo
{
   public static void main(String [] args)
   {


	  List<Student> stuNames =  new ArrayList<>();
       stuNames.add(new Student("David",2014));
       stuNames.add(new Student("Gyan",2014));
       stuNames.add(new Student("Melissa",2014));
       stuNames.add(new Student("Mathew",2014));
       stuNames.add(new Student("Arjun",2014));
       stuNames.add(new Student("Drew",2014));


       String strCurrentDir = System.getProperty("user.dir");
       FileOutputStream fos = null;
       ObjectOutputStream oos = null;

      try
      {
          fos =
         new FileOutputStream(strCurrentDir + "/stuNames.ser");
          oos =
                            new ObjectOutputStream(fos);
         oos.writeObject(stuNames);
         oos.close(); //flushes and closes
          fos.close();
      }catch(IOException e)
      {
          e.printStackTrace();
      } finally {
          try {
              oos.close(); //flushes and closes
              fos.close();
          } catch (IOException e) {
              e.printStackTrace();
          }
      }
   }
}
