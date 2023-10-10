package edu.uchicago.gerber.labjava.lec10.wait_notify;

/**
    Typical producer/consumer example
 */


public class BlockingQueueDriver {
    private static BlockingQueue<String> blockingQueue;
    public static void main(String[] args) {
      blockingQueue = new BlockingQueue<>(5);

      Thread thrPutter = new Thread (new Putter());
      thrPutter.start();

      Thread thrTaker = new Thread (new Taker());
      thrTaker.start();


    }


    private static class Putter implements Runnable {

        @Override
        public void run() {
            //To change body of implemented methods use File | Settings | File Templates.
            for (int nC = 0; nC < 100 ; nC++) {
                try {
                    blockingQueue.put("Element " + String.valueOf(nC));
                } catch (InterruptedException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
            }
        }
    }


    private static class Taker implements Runnable {

        @Override
        public void run() {
            //To change body of implemented methods use File | Settings | File Templates.
            for (int nC = 0; nC < 100 ; nC++) {
                try {
                    System.out.println(blockingQueue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
            }
        }
    }


}
