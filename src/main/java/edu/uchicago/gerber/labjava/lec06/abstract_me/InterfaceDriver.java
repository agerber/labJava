package edu.uchicago.gerber.labjava.lec06.abstract_me;

/**
 * Created by ag on 11/3/2014.
 */
public class InterfaceDriver {


    public static void main(String[] args) {
        Runnable runner = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello from runner, my type is: " + this.getClass().getName());
            }
        };

        Thread thread = new Thread(runner);
        thread.start();

    }



}




