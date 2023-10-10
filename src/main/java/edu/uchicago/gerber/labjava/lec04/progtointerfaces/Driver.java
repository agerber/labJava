package edu.uchicago.gerber.labjava.lec04.progtointerfaces;

import java.util.*;

public class Driver {



    public static void main(String[] args) {


        List<String> stringList = new ArrayList<>();


        Map<Integer,String> map = new LinkedHashMap<>();
        map.put(60601, "Chicago");
        map.put(90210, "Beverly Hills");
        map.put(12134, "New Haven");


        printMap(map);



    }


    private static void printMap(Map<Integer,String> map){

        for (Integer key : map.keySet()) {
            System.out.println(map.get(key));
        }


    }


}
