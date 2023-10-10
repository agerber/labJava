package edu.uchicago.gerber.labjava.lec10._03_util_concurrent;

import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ForkJoinPool;

public class ForkJoinExample {

    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        long number = 20;
        long result = pool.invoke(new FactorialTask(number));
        System.out.println("Factorial of " + number + " = " + result);
    }

    static class FactorialTask extends RecursiveTask<Long> {
        private final long number;

        public FactorialTask(long number) {
            this.number = number;
        }

        @Override
        protected Long compute() {
            if (number <= 1) {
                return 1L;
            } else {
                FactorialTask subTask = new FactorialTask(number - 1);
                subTask.fork(); // Asynchronously execute the subtask
                return number * subTask.join(); // join the result when it's done
            }
        }
    }
}
