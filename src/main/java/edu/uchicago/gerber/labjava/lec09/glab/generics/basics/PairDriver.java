package edu.uchicago.gerber.labjava.lec09.glab.generics.basics;

import edu.uchicago.gerber.labjava.lec04.glab.points.TDPoint;

import java.util.ArrayList;
import java.util.List;

public class PairDriver {
    public static void main(String[] args) {

        List<Pair<String, ? super TDPoint>> list = new ArrayList<>();

        list.add(new Pair<>("my generic point", 34));
        list.add(new Pair<>("my object", 89L));


        for (Pair<String, ? super TDPoint> stringPair : list) {
            System.out.println(stringPair);
        }




//        for (Pair<String, ? extends Number> stringPair : list) {
//            if (stringPair.getSecond() instanceof Double){
//                System.out.println("The Celcius temp is " + stringPair);
//            } else {
//                System.out.println("The Fahrenheit temp is " + stringPair);
//            }
//        }


    }
}
