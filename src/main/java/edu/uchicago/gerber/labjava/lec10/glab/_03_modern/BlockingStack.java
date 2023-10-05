package edu.uchicago.gerber.labjava.lec10.glab._03_modern;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingStack<T> {
    private final BlockingQueue<T> queue;

    public BlockingStack(int capacity) {
        queue = new ArrayBlockingQueue<>(capacity);
    }

    public void push(T item) throws InterruptedException {
        queue.put(item); // Add an item to the blocking queue
    }

    public T pop() throws InterruptedException {
        return queue.take(); // Remove and return an item from the blocking queue
    }

    public int size() {
        return queue.size();
    }

    public static void main(String[] args) {

        final int TOTAL = 100;

        BlockingStack<Integer> stack = new BlockingStack<>(TOTAL);

        // Push items onto the stack concurrently
        Thread pushThread1 = new Thread(() -> {
            try {
                for (int i = 1; i <= TOTAL; i++) {
                    stack.push(i);
                    System.out.println("Pushed: " + i);
                    Thread.sleep(5);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // Pop items from the stack concurrently
        Thread popThread1 = new Thread(() -> {
            try {
                for (int i = 1; i <= TOTAL; i++) {
                    int item = stack.pop();
                    System.out.println("Popped: " + item);
                    Thread.sleep(5);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        popThread1.setPriority(Thread.MAX_PRIORITY);

        pushThread1.start();
        popThread1.start();

        try {
            pushThread1.join();
            popThread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("The size of the stack is " + stack.size());


    }
}
