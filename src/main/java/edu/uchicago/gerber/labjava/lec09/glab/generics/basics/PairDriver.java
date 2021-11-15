package edu.uchicago.gerber.labjava.lec09.glab.generics.basics;

import edu.uchicago.gerber.labjava.lec04.glab.points.TDPoint;

import java.util.ArrayList;
import java.util.List;

public class PairDriver {
    public static void main(String[] args) {

        List<Pair<String, ?>> list = new ArrayList<>();

        list.add(new Pair<>("To be or not to be", "Shakespeare"));
        list.add(new Pair<>("Do or do not do, there is no try", "Yoda"));
        list.add(new Pair<>("Let there be light", new Long(-2000L)));

        for (Pair<String, ?> stringPair : list) {
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
