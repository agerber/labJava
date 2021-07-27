package edu.uchicago.gerber.labjava.lec10.glab.join;

/**
 * Created with IntelliJ IDEA.
 * User: ag
 * Date: 11/30/13
 * Time: 8:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class JoinDriver {

    public static void main(String[] args) {
        Thread thrOne = new Thread(new MyRunner1());
        thrOne.start();
        Thread thrTwo = new Thread(new MyRunner2());
        thrTwo.start();

        //try commenting-out this try block
//        try {
//            thrOne.join();
//            thrTwo.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
//        }

        System.out.println("Main thread done");
    }


    private static class MyRunner1 implements  Runnable {
        @Override
        public void run() {
            for (int nC = 0; nC < Short.MAX_VALUE * 10 ; nC++) {
                 nC++;
            }
            System.out.println("MyRunner1 done");
        }
    }

    private static class MyRunner2 implements  Runnable {
        @Override
        public void run() {
            for (int nC = 0; nC < Short.MAX_VALUE * 20 ; nC++) {
                nC++;
            }
            System.out.println("MyRunner2 done");
        }
    }

}
