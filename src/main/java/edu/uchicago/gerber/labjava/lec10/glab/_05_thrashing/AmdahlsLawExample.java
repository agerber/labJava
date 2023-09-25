package edu.uchicago.gerber.labjava.lec10.glab._05_thrashing;

public class AmdahlsLawExample {

    private static final int TASK_SIZE = 1_000_000;

    public static void main(String[] args) {
        // Sequential execution
        long startTime = System.currentTimeMillis();
        sequentialTask();
        long endTime = System.currentTimeMillis();
        long sequentialTime = endTime - startTime;

        // Parallel
        int processors = Runtime.getRuntime().availableProcessors();
        System.out.println("Number or processors is: " + processors);
        startTime = System.currentTimeMillis();
        parallelTask(processors);
        endTime = System.currentTimeMillis();
        long parallelTime = endTime - startTime;

        double observedSpeedup = (double) sequentialTime / parallelTime;
        //tweak this variable to see the speedup. a value of .05 means only 5 percent is parallelizable
        double amdahlsSpeedup = amdahlsSpeedup(0.875, processors);  // assuming 75% can be parallelized

        System.out.println("Sequential time: " + sequentialTime + "ms");
        System.out.println("Parallel time: " + parallelTime + "ms");
        System.out.println("Observed speedup: " + observedSpeedup);
        System.out.println("Amdahl's speedup: " + amdahlsSpeedup);
    }

    private static void sequentialTask() {
        // Simulating a task that's
        parallelizablePortion();
        parallelizablePortion();
        parallelizablePortion();
        parallelizablePortion();
        parallelizablePortion();
        parallelizablePortion();
        parallelizablePortion();
        nonParallelizablePortion();
    }

    private static void parallelTask(int processors) {
        Thread[] threads = new Thread[processors];
        for (int i = 0; i < processors - 1; i++) {
            threads[i] = new Thread(() -> parallelizablePortion());
            threads[i].start();
        }
        nonParallelizablePortion();  // this portion remains sequential

        for (int i = 0; i < processors - 1; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void parallelizablePortion() {
        for (int i = 0; i < TASK_SIZE; i++) {
            Math.sin(i);
        }
    }

    private static void nonParallelizablePortion() {
        for (int i = 0; i < TASK_SIZE; i++) {
            Math.cos(i);
        }
    }

    private static double amdahlsSpeedup(double parallelizableFraction, int processors) {
        return 1.0 / ((1 - parallelizableFraction) + (parallelizableFraction / processors));
    }
}
