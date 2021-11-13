package edu.uchicago.gerber.labjava.lec07.glab.stream.behaviorparam;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicatesDriver {
    public static void main(String[] args) {

        List<String> myNames = new ArrayList<>();
        myNames.add("Adam");
        myNames.add("Sam");
        myNames.add("Adrian");
        myNames.add("Silvester");
        myNames.add("Carl");

        //here I have two predicates
        Predicate<String> predContainsLetterS = name -> name.toLowerCase().contains("s");
        Predicate<String> predLongerThan5 = name -> name.length() > 5;

        //I have to check each element O(n)
        for (String myName : myNames) {
            if (predLongerThan5.test(myName) && predContainsLetterS.negate().test(myName)){
                System.out.println(myName);
            }
        }




    }
}
