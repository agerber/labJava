package edu.uchicago.gerber.labjava.lec04.glab.uml;

import java.util.*;

public class ProgramToInterfaces {
    public static void main(String[] args) {

        Map<String,String> map = new TreeMap<>();

        map.put("East Timor", "Dili");
        map.put("Romania", "Bucharest");
        map.put("Ireland", "Dublin");

        displayMap(map);

        List<String> myList = new LinkedList<>();



    }



    private static void displayMap(Map<String,String> map){

        for (String key : map.keySet()) {
            System.out.println(key + " : " + map.get(key));
        }
    }

}
