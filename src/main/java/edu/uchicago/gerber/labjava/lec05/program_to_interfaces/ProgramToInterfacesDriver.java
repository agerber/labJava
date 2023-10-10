package edu.uchicago.gerber.labjava.lec05.program_to_interfaces;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ProgramToInterfacesDriver {
    public static void main(String[] args) {

        List<String> myList = new ArrayList<>();

        myList.add("Chicago");
        myList.add("Ypsilanti");
        myList.add("New York");
        myList.add("Boston");
        myList.add("Houston");
        myList.add("Los Angeles");
        myList.add("Albany");

       sortList(myList);
        printList(myList);

    }


    private static void printList(List<String> list){

        for (String str : list) {
            System.out.println(str);
        }

    }

    private static void sortList(List<String> list){

        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

    }

}
