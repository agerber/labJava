package edu.uchicago.gerber.labjava.lec08.glab.collecting;

import java.util.*;
import java.util.stream.Collectors;

public class CollectingDriver {
    public static void main(String[] args) {

        String[] names = {
          "Adam",
          "Adam",
          "Charlie",
          "Adam",
          "Adam",
          "Bobby",
          "Adam",
          "Adam",
          "Adam",
          "Fred",
          "Eddie"
        };



      Map<Object, List<String>> myMap =  Arrays.stream(names)
                .collect(Collectors.groupingBy(s -> s.length()));

        for (Object o : myMap.keySet()) {
            System.out.println("\n     " + o);
            List<String> list = myMap.get(o);
            for (String s : list) {
                System.out.print(s + " ");
            }
        }





    }
}
