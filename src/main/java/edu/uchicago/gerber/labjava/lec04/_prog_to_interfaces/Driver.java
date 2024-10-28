package edu.uchicago.gerber.labjava.lec04._prog_to_interfaces;

import java.util.*;

public class Driver {



    public static void main(String[] args) {

        //programming to interfaces
        List<String> list = new ArrayList<>();
        //List<String> list = new ArrayList<>();

        list.add("United States");
        list.add("Lithuania");
        list.add("Chile");
        list.add("China");
        list.add("Denmark");
        list.add("Vietnam");

        printList(list);


    }


    //make this a List
    private static void printList(List<String> list){

        for (String str : list) {
            System.out.println(str);
        }

    }




}
