package edu.uchicago.gerber.labjava.lec10.glab._01_basics.wait_notify;

class TaskManager {
    private int currentTask = 1;

    public synchronized void executeTask1() throws InterruptedException {
        while (currentTask != 1) {
            wait();
        }
        System.out.println("Task1 is executing");
        currentTask = 2;
        notifyAll();
    }

    public synchronized void executeTask2() throws InterruptedException {
        while (currentTask != 2) {
            wait();
        }
        System.out.println("Task2 is executing");
        currentTask = 3;
        notifyAll();
    }

    public synchronized void executeTask3() throws InterruptedException {
        while (currentTask != 3) {
            wait();
        }
        System.out.println("Task3 is executing");
        currentTask = 1;
        notifyAll();
    }
}

public class WaitNotifyAllExample {
    public static void main(String[] args) {
        final TaskManager taskManager = new TaskManager();

        Thread thread1 = new Thread(() -> {
            try {
                while (true) {
                    taskManager.executeTask1();
                    Thread.sleep(1000); // Simulate task execution time
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                while (true) {
                    taskManager.executeTask2();
                    Thread.sleep(1000); // Simulate task execution time
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread3 = new Thread(() -> {
            try {
                while (true) {
                    taskManager.executeTask3();
                    Thread.sleep(1000); // Simulate task execution time
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
