package edu.uchicago.gerber.labjava.lec10.glab._03_util_concurrent.orchestrate;



import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {

    public static void main(String args[])
    {

        // creating CyclicBarrier (checkPoint) with
        // 4 parties (Bikers) threads that need to call await()
        final CyclicBarrier checkPoint = new CyclicBarrier(4, new Runnable(){
            @Override
            public void run(){
                //This task will be executed once all biker threads will reach barrier
                System.out.println("\nAll bikers have arrived to checkpoint....pitstop\n");
            }
        });

        //starting each of thread
        Thread biker1 = new Thread(new Biker(checkPoint), "Biker 1");
        Thread biker2 = new Thread(new Biker(checkPoint), "Biker 2");
        Thread biker3 = new Thread(new Biker(checkPoint), "Biker 3");
        Thread biker4 = new Thread(new Biker(checkPoint), "Biker 4");

        biker1.start();
        biker2.start();
        biker3.start();
        biker4.start();


    }
}

class Biker implements Runnable
{

    private Random random = new Random();

    private CyclicBarrier checkPoint;

    public Biker(CyclicBarrier checkPoint) {
        this.checkPoint = checkPoint;
    }

    // Code to be executed by each biker
    @Override
    public void run()
    {
        try
        {
            System.out.println(Thread.currentThread().getName() + " Rally race begins");

            checkPoint.await();
            System.out.println(Thread.currentThread().getName() + " has left the first checkpoint / barrier");

            checkPoint.await();
            System.out.println(Thread.currentThread().getName() + " has left the second checkpoint / barrier");

            checkPoint.await();
            System.out.println(Thread.currentThread().getName() + " has reached the finish line");

        }
        catch (InterruptedException |  BrokenBarrierException ex)
        {
            ex.printStackTrace();
        }
    }
}
