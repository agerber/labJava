package edu.uchicago.gerber.labjava.lec10._03_util_concurrent;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapExample {
    public static void main(String[] args) {
        // Create a ConcurrentHashMap with String keys and Integer values
        ConcurrentHashMap<Integer, String> concurrentMap = new ConcurrentHashMap<>();

        // Number of threads
        int numThreads = 5;

        // Create and start multiple threads
        Thread[] threads = new Thread[numThreads];
        for (int i = 0; i < numThreads; i++) {
            threads[i] = new Thread(new Worker(concurrentMap));
            threads[i].setName("Worker" + i);
            threads[i].start();
        }

        // Wait for all threads to complete
        for (int i = 0; i < numThreads; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (Integer key : concurrentMap.keySet()) {
            System.out.println(key + ":" + concurrentMap.get(key));
        }
    }

    static class Worker implements Runnable {
        private ConcurrentHashMap<Integer, String> map;

        public Worker(ConcurrentHashMap<Integer, String> map) {
            this.map = map;
        }

        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                // Update the ConcurrentHashMap concurrently
                map.put(i,"Value" + i);
               // System.out.println("Getting value from " + Thread.currentThread().getName() + ":" + map.get(i));

            }
        }
    }
}
