package lec10.glab.wait_notify;

import java.util.LinkedList;
import java.util.Queue;


//found here: http://stackoverflow.com/questions/2536692/a-simple-scenario-using-wait-and-notify-in-java
public class BlockingQueue<T> {

    private Queue<T> queue = new LinkedList<T>();
    private int capacity;

    public BlockingQueue(int capacity) {
        this.capacity = capacity;
    }

    public synchronized void put(T element) throws InterruptedException {
        while(queue.size() == capacity) {
            //Tells the calling thread to wait()
            this.wait();
        }

        //once it's no longer at capacity, then you can enqueue an element and notify that
        //it may no longer need to wait
        queue.add(element);
        //notifies the calling thread that it may proceed.
        this.notify();
    }

    public synchronized T take() throws InterruptedException {
        while(queue.isEmpty()) {

            this.wait();
        }

        //slow the taking down a bit
        Thread.sleep(10);

        T item = queue.remove();
        this.notify();
        return item;
    }

    public synchronized  T peek(){
        return queue.peek();
    }


}