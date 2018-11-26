package lec09.glab.simpledatastructs;

import java.util.*;

public class ProgrammingToInterfaces {

    public static void main(String[] args) {


        List<String> myStrings = new ArrayList<>();
        myStrings.add("Adam");
        myStrings.add("Bobby");
        myStrings.add("Charlie");

        List<Date> myDates = new LinkedList<>();

        myDates.add(new Date(89789));
        myDates.add(new Date(234));
        myDates.add(new Date(908888));

        Map<Integer, String> map1 = new TreeMap<>();
        System.out.println(addValuesToMap(myStrings, map1));


        Map<Integer, Date> map2 = new HashMap<>();
        System.out.println(addValuesToMap(myDates, map2));

    }

    //return a list of keys and values. you can't instatite generic classes, so pass them in
    private static <V> Map addValuesToMap(List<V> list, Map<java.lang.Integer, V> map) {

        for (V v : list) {
            map.put(v.hashCode(), v);
        }

        return map;
    }



}
