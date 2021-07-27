package edu.uchicago.gerber.labjava.lec08.glab.lambda.behavior_param;

/**
 * Created by Adam on 6/3/2016.
 */
public class BPDriver {

    public static void main(String[] args) {


        //anonymous inner class
     Thread thread = new Thread(new Runnable() {
         @Override
         public void run() {

             for (int nC = 0; nC < 10; nC++) {
                 System.out.println("Hello " +nC);
                 try {
                     Thread.sleep(1000);
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
             }

         }
     });

        thread.start();








    }
}
