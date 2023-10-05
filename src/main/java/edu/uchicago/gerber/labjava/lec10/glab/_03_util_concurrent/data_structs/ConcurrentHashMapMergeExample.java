package edu.uchicago.gerber.labjava.lec10.glab._03_util_concurrent.data_structs;

import java.util.AbstractMap;
import java.util.LinkedHashMap;
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
//        sortByKey(wordCountMap).forEach((word, count) -> System.out.println(word + ": " + count));
    }

    private static void processWords(String[] words) {
        for (String word : words) {
            // For each word, merge it into the map.
            wordCountMap.merge(word, 1, Integer::sum);
        }
    }

    private static LinkedHashMap<String,Integer> sortByKey(AbstractMap<String,Integer> unsortedMap){

       return  unsortedMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                //.sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1, // merge function, should not be needed in this context
                        LinkedHashMap::new // keep order
                ));

    }
}
