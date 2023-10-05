package edu.uchicago.gerber.labjava.lec10.glab._03_modern.fork_join;

import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ForkJoinPool;
import java.util.Arrays;

public class ForkJoinQuickSortExample {

    // RecursiveTask to perform parallel quicksort
    static class ParallelQuickSortTask extends RecursiveTask<int[]> {
        private final int[] numbers;
        private final int left;
        private final int right;

        ParallelQuickSortTask(int[] numbers, int left, int right) {
            this.numbers = numbers;
            this.left = left;
            this.right = right;
        }

        @Override
        protected int[] compute() {
            if (left < right) {
                int pivotIndex = partition(numbers, left, right);

                // Instead of recursion for both partitions, use fork for one and direct compute for the other.
                ParallelQuickSortTask leftTask = new ParallelQuickSortTask(numbers, left, pivotIndex - 1);
                ParallelQuickSortTask rightTask = new ParallelQuickSortTask(numbers, pivotIndex + 1, right);

                leftTask.fork();
                rightTask.compute();
                leftTask.join();
            }
            return numbers;
        }

        private int partition(int[] array, int low, int high) {
            int pivot = array[high];
            int i = (low - 1);
            for (int j = low; j < high; j++) {
                if (array[j] <= pivot) {
                    i++;
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
            int temp = array[i + 1];
            array[i + 1] = array[high];
            array[high] = temp;

            return i + 1;
        }
    }

    public static void main(String[] args) {
        int[] numbers = {29, 4, 94, 59, 34, 76, 23, 1, 45, 87, 83, 56, 38, 50, 72};

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ParallelQuickSortTask task = new ParallelQuickSortTask(numbers, 0, numbers.length - 1);
        forkJoinPool.invoke(task);

        System.out.println("Sorted array: " + Arrays.toString(numbers));
    }
}
