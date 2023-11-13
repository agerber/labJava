package edu.uchicago.gerber.labjava.lec07.stream.behaviorparam;

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


        Predicate<String> longerThan5 = name -> name.length() > 5;

        //I have to check each element O(n)
        for (String myName : myNames) {
            if (longerThan5.test(myName)){
                System.out.println(myName);
            }
        }

        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");

        //with streams, I don't iterate the entire collection - it uses internal iteration
        myNames.stream()
                .filter(name -> name.length() > 5)
                .forEach(s -> System.out.println(s));




    }
}
