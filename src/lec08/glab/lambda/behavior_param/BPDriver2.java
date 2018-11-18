package lec08.glab.lambda.behavior_param;

/**
 * Created by Adam on 6/3/2016.
 */
public class BPDriver2 {

    public static void main(String[] args) {


        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int nC = 0; nC < 10; nC++) {
                    System.out.println("store the runnable in reference " +nC);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };


        //anonymous inner class
        Thread thread = new Thread(runnable);

        thread.start();








    }
}
