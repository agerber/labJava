package edu.uchicago.gerber.labjava.lec07.declarative;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ImperativeExample {
    public static void main(String[] args) {
        //start with an arrayList
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        //iterate through ALL elements
        for (Integer n : numbers) {
            if (n % 2 == 0) {      // Filter even numbers
                System.out.println(n * 2);
            }
        }

    }
}
