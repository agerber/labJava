package edu.uchicago.gerber.labjava.lec07.spent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorSpentExample {
    public static void main(String[] args) {
        List<String> items = new ArrayList<>();
        items.add("apple");
        items.add("banana");
        items.add("cherry");

        Iterator<String> iterator = items.iterator();

        // First iteration - fully consume the iterator
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("Trying to iterate again:");

        // Attempting to iterate again - iterator is now "spent"
        while (iterator.hasNext()) {
            System.out.println(iterator.next()); // No output; iterator has no more elements
        }
    }
}
