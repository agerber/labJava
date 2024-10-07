package edu.uchicago.gerber.labjava.lec02;

import java.util.ArrayList;
import java.util.Random;

public class ArrayListCapacity {

    public static void main(String[] args) {

        ArrayList<String> months = new ArrayList<>();
        //initialize underlying array with defeault capacity (size) 10
        //each bucket has a value of null initially.

        months.add("jan");
        months.add("feb");
        months.add("mar");
        months.add("apr");
        months.add("may");
        months.add("jun");
        months.add("jul");
        months.add("aug");
        months.add("sep");
        months.add("oct"); //at capacity

        //create a larger array and COPY each element over!!!!, then add the following
        months.add("nov");
        months.add("dec");

        System.out.println(months);


        //////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////



        int size = 113;

        ArrayList<String> names = new ArrayList<>(size);
        while (size-- > 0){
            names.add(generateRandomString() + "::" + size);
        }

        System.out.println(names);




        //////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////


        ArrayList<Integer> vals = new ArrayList<>();
        size = 10;
        while (size-- > 0){
            //vals.add(new Integer(144));
            vals.add(144);
        }

        System.out.println(vals);




    }
    private static String generateRandomString() {
        final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        final int LENGTH = 10;  // Length of the random string

        Random random = new Random();
        StringBuilder sb = new StringBuilder(LENGTH);

        for (int i = 0; i < LENGTH; i++) {
            int index = random.nextInt(CHARACTERS.length());
            sb.append(CHARACTERS.charAt(index));
        }

        return sb.toString();
    }
}
