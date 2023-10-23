package edu.uchicago.gerber.labjava.lec04._more_interfaces;

import java.util.Arrays;

public class StringSorter {

    public static void main(String[] args) {
        String[] names = {"Zach", "Alice", "Bob", "Charlie"};

        System.out.println("Before Sorting:");
        for(String name : names) {
            System.out.println(name);
        }

        Arrays.sort(names);

        System.out.println("\nAfter Sorting:");
        for(String name : names) {
            System.out.println(name);
        }
    }
}
