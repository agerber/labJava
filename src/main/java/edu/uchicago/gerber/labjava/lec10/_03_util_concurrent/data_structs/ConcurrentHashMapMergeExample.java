package edu.uchicago.gerber.labjava.lec10._03_util_concurrent.data_structs;

import java.util.AbstractMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class ConcurrentHashMapMergeExample {

    private static final ConcurrentHashMap<String, Integer> wordCountMap = new ConcurrentHashMap<>();

    public static void main(String[] args) throws InterruptedException {


        String[] words1 = {"apple", "banana", "apple", "apricot", "strawberry"};
        String[] words2 = {"orange", "banana", "apple"};
        String[] words3 = {"apricot", "fig", "apple"};

        Thread thread1 = new Thread(() -> processWords(words1));
        Thread thread2 = new Thread(() -> processWords(words2));
        Thread thread3 = new Thread(() -> processWords(words3));

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();



        // Print word counts
        wordCountMap.forEach((word, count) -> System.out.println(word + ": " + count));
//        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
//        toLinkedList(wordCountMap).forEach(System.out::println);
    }

    private static void processWords(String[] words) {
        for (String word : words) {
            // For each word, merge it into the map.
            wordCountMap.merge(word, 1, Integer::sum);
        }
    }

    private static LinkedList<String> toLinkedList(AbstractMap<String,Integer> unsortedMap){

       return  unsortedMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .map(e -> String.valueOf(e.getKey().charAt(0)).toUpperCase() + e.getKey().substring(1) + ": " + e.getValue())
                .collect(Collectors.toCollection(LinkedList::new));


    }
}
