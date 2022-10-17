package edu.uchicago.gerber.labjava.lec03.glab;

//import java.util.Date;
//import java.sql.Date;
//import java.util.*;

public class Packs {


    //there are 4 scopes, private, default, protected, public

    //If member doesn't change, why is it a good idea to make it static?
    private static final String SCHOOL = "UCHICAGO";


    public static void main(String[] args) {
        java.sql.Date date1 = new java.sql.Date(1L);
        java.util.Date date2 = new java.util.Date();


       // date1 = date2;




    }

    //only other methods of this class can see this method
    private static void sayHello(String strParam){
        System.out.println("Hello there " + strParam + " from " + SCHOOL );
    }


}
