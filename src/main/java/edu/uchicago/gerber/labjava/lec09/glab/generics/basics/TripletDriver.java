package edu.uchicago.gerber.labjava.lec09.glab.generics.basics;

public class TripletDriver {


    public static void main(String[] args) {
        Triplet<String,String, ?> trip = new Triplet("Hello", "There", 12);
       // Triplet<String,String, ?> trip2 = new Triplet("Hello", "There", "String");
        Triplet<String,String, ?> trip3 = new Triplet("Hello", "There", new Long(12L));
        System.out.println(trip3 + ":" + trip);

    }
}
