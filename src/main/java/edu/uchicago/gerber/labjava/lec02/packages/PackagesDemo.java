package edu.uchicago.gerber.labjava.lec02.packages;

// Importing Date from java.util package
import java.util.Date;


public class PackagesDemo  {

    public static void main(String[] args) {
        // Using Date from java.util package
        Date utilDate = new Date();
        System.out.println("java.util.Date: " + utilDate);

        // Using Date from java.sql package using fully-qualified name
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        System.out.println("java.sql.Date: " + sqlDate);
    }
}
