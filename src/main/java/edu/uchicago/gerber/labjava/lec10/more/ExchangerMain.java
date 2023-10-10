
/*******************************************************************************
 * 
 * Program:     ExchangerMain
 * 
 * Purpose:     To provide a very simple example of how the Exchanger class
 *              works to allow threads to exchange object information at
 *              a central synchronization point.
 * 
 *              Put simply, this program creates an Exchanger object and passes
 *              it to two ExchangerParticpant objects, each of which sleeps
 *              for a random amount of time (between 5 and 15 seconds) before
 *              they attempt to exchange some data with the other.  
 * 
 *              In this way, the Exchanger facilitates the communication of data
 *              across threads in a synchronized fashion when two threads need to
 *              exchange data but may be ready to do so at different times.  Also,
 *              each ExchangerParticipant thread doesn't need to know anything about
 *              the other ExchangerParticipant thread, it only needs to know the
 *              Exchanger object.
 * 
 * Source:      Code adapted from example found at 
 *              http://www.javacodex.com/Concurrency/Exchanger-Example
 * 
 *******************************************************************************/

package edu.uchicago.gerber.labjava.lec10.more;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExchangerMain {
    
    public static void main(String args[]){
        
        Exchanger<String> exchanger = new Exchanger<String>();
        ExchangerParticipant a1 = new ExchangerParticipant(exchanger,"I like chocolate!");
        ExchangerParticipant b1 = new ExchangerParticipant(exchanger,"I like peanut butter!");
   
        ExecutorService executor = (ExecutorService)Executors.newFixedThreadPool(2);
        
        executor.execute(a1);
        executor.execute(b1);
        
        executor.shutdown();
        
    }
    
}
