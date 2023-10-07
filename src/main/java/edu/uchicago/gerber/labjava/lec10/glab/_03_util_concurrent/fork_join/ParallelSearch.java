package edu.uchicago.gerber.labjava.lec10.glab._03_util_concurrent.fork_join;

import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ForkJoinPool;

public class ParallelSearch extends RecursiveTask<Integer> {
    private static final int THRESHOLD = 100;
    private final int[] data;
    private final int start;
    private final int end;
    private final int target;

    public ParallelSearch(int[] data, int start, int end, int target) {
        this.data = data;
        this.start = start;
        this.end = end;
        this.target = target;
    }

    @Override
    protected Integer compute() {
        int length = end - start;
        if (length < THRESHOLD) {
            // Sequential search
            for (int i = start; i < end; i++) {
                if (data[i] == target) {
                    return i; // Found
                }
            }
            return -1; // Not found
        } else {
            // Divide and conquer
            int mid = start + length / 2;
            ParallelSearch leftSearch = new ParallelSearch(data, start, mid, target);
            ParallelSearch rightSearch = new ParallelSearch(data, mid, end, target);
            leftSearch.fork(); // Fork off the left-side search
            int rightResult = rightSearch.compute(); // Compute the right-side search directly
            int leftResult = leftSearch.join(); // Wait for the left-side search to complete

            if (leftResult != -1) return leftResult;
            return rightResult;
        }
    }

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        int[] data = new int[100_000];

        // Fill the array with some random numbers for demonstration
        for (int i = 0; i < data.length; i++) {
            data[i] = (int)(Math.random() * 1000);
        }

        int target = 500; // Number we're looking for

        ParallelSearch task = new ParallelSearch(data, 0, data.length, target);
        int result = forkJoinPool.invoke(task);

        if (result != -1) {
            System.out.println("Found " + target + " at index " + result);
        } else {
            System.out.println(target + " not found.");
        }
    }
}