package lec10.glab.serialize;
import java.io.*;
import java.util.ArrayList;

   public class DeserializeDemo
   {
      public static void main(String [] args)
      {
    	  ArrayList<Student> stuNames =  null;
         try
         {
            FileInputStream fis =
                          new FileInputStream("stuNames.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            stuNames = (ArrayList<Student>) ois.readObject();
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
        
        for (Student stu : stuNames) {
			System.out.println(stu);
		}

    }
}