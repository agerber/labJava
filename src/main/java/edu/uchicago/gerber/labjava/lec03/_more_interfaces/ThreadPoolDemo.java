package edu.uchicago.gerber.labjava.lec03._more_interfaces;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class TaskOne implements Runnable {
    @Override
    public void run() {
        System.out.println("Executing Task One");
    }
}

class TaskTwo implements Runnable {
    @Override
    public void run() {
        System.out.println("Executing Task Two");
    }
}

public class ThreadPoolDemo {
    public static void main(String[] args) {
        // Create a thread pool with 2 threads
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // Submit tasks to the thread pool
        executor.submit(new TaskOne());
        executor.submit(new TaskTwo());

        // Shutdown the executor to stop accepting new tasks and
        // finish all existing tasks
        executor.shutdown();
    }
}
