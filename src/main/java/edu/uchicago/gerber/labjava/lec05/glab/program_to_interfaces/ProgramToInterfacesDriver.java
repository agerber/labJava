package edu.uchicago.gerber.labjava.lec05.glab.program_to_interfaces;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class ProgramToInterfacesDriver {
    public static void main(String[] args) {

        List<String> myList = new LinkedList<>();

        myList.add("Chicago");
        myList.add("Ypsilanti");
        myList.add("New York");
        myList.add("Boston");
        myList.add("Houston");
        myList.add("Los Angeles");
        myList.add("Albany");

        myList =  sortList(myList);
        printList(myList);

    }


    private static void printList(List<String> list){

        for (String str : list) {
            System.out.println(str);
        }

    }

    private static List<String> sortList(List<String> list){

        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        return list;
    }

}
