
/*
 * This class is used in conjunction with the ExchangeMain.java class.
 * This class shows use a runnable class can use the Exchanger class to 
 * swap information with another thread without knowing anything about that thread.
 *
 */

package edu.uchicago.gerber.labjava.lec10.glab.more;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExchangerParticipant implements Runnable {

    // When this object is initialized, it receives both an Exchanger object
    // and a message.
    
    Exchanger<String> exchanger;
    String message;
    
    public ExchangerParticipant(Exchanger<String> exchanger, String message){
        this.exchanger = exchanger;
        this.message = message;
    }
        
    @Override
    public void run() {
        
        // >> This is where you would put in your actionable code << 
        
        // We disclose the message we were given initially
        
        System.out.println("Thread ID# " + Thread.currentThread().getId() + " message: " + message);
        
        // We then rest for some time between 5 and 15 seconds.
        
        try {
            long duration = 5 + (long)(Math.random() * 10);
            System.out.println("Thread ID# " + Thread.currentThread().getId() + " will now sleep " + duration + " seconds before attempting an exchange ...");
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException ex) {
            Logger.getLogger(ExchangerParticipant.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        // We then try to exchange a message with the other thread
        // Note that the exchanger.exchange method is really the key function here, in that
        // the thread will wait until the other thread is ready to complete the exchange.
        
        // We could use a different version of the exchange method which allows for a timeout
        // to be put in place, so that if the other thread is not ready to exchange data within X seconds
        // (or milliseconds or minutes), we time out and can take other action.
        
        try {
            System.out.println("Thread ID# " + Thread.currentThread().getId() + " will now attempt to exchange data with other thread ...");
            message = exchanger.exchange(message);
        } catch (InterruptedException ex) {
            Logger.getLogger(ExchangerParticipant.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Finally, we print out the result of the exchange.
        
        System.out.println("Thread ID# " + Thread.currentThread().getId() + " message: " + message);
                
    }
    
}
