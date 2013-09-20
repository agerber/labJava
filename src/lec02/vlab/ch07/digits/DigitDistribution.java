package lec02.vlab.ch07.digits;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DigitDistribution
{
   /**
      Reads all numbers in the input.
      @param in a scanner
      @return an array list of all numbers in the input
   */
   public static ArrayList<Double> getNumbers(Scanner in)
   {
      in.useDelimiter("[^0-9.,]+");
      
      ArrayList<Double> result = new ArrayList<Double>();
      
      while (in.hasNext())
      {
         String next = in.next();
         next.replace(",", "");
         try
         {
               double value = Double.parseDouble(next);
               result.add(value);
         }
         catch (NumberFormatException ex)
         {
            // Couldn't convert
         }
      }
      return result;
   }

   /**
      Gets the counts of the first non-zero digits in a list of numbers
      @param values a list of numbers
      @param an array of counts whose ith element is the 
      count of values starting with the digit i
   */
   public static int[] getFirstDigitCounts(ArrayList<Double> values)
   {
      int[] counters = new int[10];
      for (double value : values)
      {
         if (value >= 1) 
         {
            int firstDigit = ("" + value).charAt(0) - '0';
            counters[firstDigit]++;
         }
      }      
      return counters;
   }

   public static void main(String[] args)
   {
      try
      {
         System.out.print("Input file: ");         
         Scanner in = new Scanner(System.in); 
         String filename = in.nextLine();
         Scanner infile = new Scanner(new File(filename));
      
         ArrayList<Double> numbers = getNumbers(infile);

         int[] counts = getFirstDigitCounts(numbers);
         
         for (int i = 1; i <= 9; i++)
         {
            System.out.println(i + ": " + counts[i]);
         }
      }
      catch (FileNotFoundException ex)
      {
         System.out.println(ex.getMessage());
      }
   }
}
