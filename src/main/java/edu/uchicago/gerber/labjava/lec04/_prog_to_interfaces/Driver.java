package edu.uchicago.gerber.labjava.lec04._prog_to_interfaces;

import java.util.*;

public class Driver {



    public static void main(String[] args) {

        Map<String,String> map = new HashMap<>();

        map.put("United States", "North America");
        map.put("Lithuania", "Europe");
        map.put("Chile", "South America");
        map.put("China", "Asia");
        map.put("Denmark", "Europe");
        map.put("Vietnam", "Asia");

        printMap(map);


    }


    private static void printMap(Map<String,String> map){

        for (String key : map.keySet()) {
            System.out.println(getCountryAndContinent(key, map));
        }
    }

    private static String getCountryAndContinent(String key, Map<String,String> map){
        return key + " : " + map.get(key);

    }


}
