/*
 * This example shows the utility of using the 'synchronized' keyword to
 * protect the integrity of a variable that is accessed by multiple threads.
 *
 * This program does one simple task - it sets up an initial balance of 100 and then
 * adds and subtracts 100 an equal number of times until completion.  Consequently,
 * the ending balance should be 100.
 * 
 * To test this code, run it first in its present form, and see that the beginning and 
 * ending balances are different, although the amounts added and subtracted are equal.
 * Next, activate the "synchronized" keyword between 'public' and 'class' in the SynchBalance
 * class and re-run the program.  The beginning balance and ending balance will equal.
 *
 * This code is adapted from examples found in the tutorial "Java 101: Understanding
 * Threads, Part 2: Java Synchronization" by Jeff Friesen, located at:
 * http://www.javaworld.com/article/2074318/java-concurrency/java-101--understanding-java-threads--part-2--thread-synchronization.html
 * as well as the book "Java 7 Concurrency Cookbook" by Javier Fernandez Gonzalez (pg. 46).
*/

package edu.uchicago.gerber.labjava.lec10.more;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SynchMain {
     
    public static void main (String args[]) {
        
        SynchBalance balance = new SynchBalance(100);
        ArrayList<Thread> threadList = new ArrayList<>();
        
        System.out.println("Beginning amount = 100");
        
        for(int i = 0; i < 10; i++){
            
            SynchAdder adder = new SynchAdder(balance);
            SynchSubtractor subtractor = new SynchSubtractor(balance);

            Thread addThread = new Thread(adder);
            Thread subThread = new Thread(subtractor);
            
            threadList.add(addThread);
            threadList.add(subThread);
            
            addThread.start();
            subThread.start();
           
        }
        
        // After we have launched all of our threads, we call the "join" method
        // so that the program's flow will wait until all of the threads are completed.
        // At this point, we can present the ending balance.
        
        for (Thread thread : threadList) {
            
            try {
                thread.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(SynchMain.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        System.out.println("Ending amount = " + balance.currentAmount());
        
    }
    
}
