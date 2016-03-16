
/*
 * This class should be reviewed in conjunction with the CallableMain.java class.
 */

package lec10.glab.more;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

// This simple class sleeps for a pre-determined number of milliseconds
// and then return a random integer between 0 and 99.

// Because this class implements the Callable<Integer> interface, it must
// override the call() method and return an integer.

public class CallableGenerator implements Callable<Integer> {

    private final Integer sleepNumber;
    
    public CallableGenerator(Integer number){
        this.sleepNumber = number;        
    }
  
    @Override
    public Integer call() {

        // >> This is where you would put in your actionable code << 
        
        // We first try to sleep for the assigned number of milliseconds.
        // However, we look to check whether we are cancelled in the process
        
        // You can imaginethat this class could be doing something
        // instead of sleeping, like download a resource from the Internet,
        // calculating a complex equation or converting one file to another.
        
        try {
            TimeUnit.MILLISECONDS.sleep(this.sleepNumber);
        } catch (InterruptedException e) {
            System.out.println("Darn, I've been cancelled!");
            return 0;
        }

        // If we haven't been cancelled, we return our random number.
        
        Random random = new Random();
        return random.nextInt(100);
 
    }
    
}
