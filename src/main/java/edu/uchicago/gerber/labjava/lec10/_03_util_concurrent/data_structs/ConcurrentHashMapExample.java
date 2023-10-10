package edu.uchicago.gerber.labjava.lec10._03_util_concurrent.data_structs;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapExample {

    private static final ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

    public static void main(String[] args) {

        // Thread 1: Adds some keys and values to the map
        Thread thread1 = new Thread(() -> {
            map.put("Two", 2);
            map.put("Three", 3);
            map.put("Four", 4);
            map.put("Five", 5);
            map.put("Six", 6);
            map.put("Seven", 7);
            map.put("Eight", 8);
            map.put("Nine", 9);
            map.put("Ten", 10);
            map.put("Queen", 10);
            map.put("King", 10);
            map.put("Ace", 1);
            System.out.println("Thread 1 added all cards but Jack.");
        });

        // Thread 2: Modifies some values and adds a new key-value pair
        Thread thread2 = new Thread(() -> {
            map.put("Ace", 11);  // Modifying value for key "Ace"
            map.put("Jack", 10); // Adding new key-value
            System.out.println("Thread 2 modifies Ace and adds Jack.");
        });

        // Start the threads
        thread1.start();
        thread2.start();

        // Wait for the threads to finish
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Print the final contents of the map
        System.out.println("Final map content: " + map);
    }
}
