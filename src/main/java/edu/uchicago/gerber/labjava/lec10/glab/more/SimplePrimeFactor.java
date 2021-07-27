
/****************************************************************
 * 
 *  Program:    SimpleThread (main method at SimpleThreadMain.java)                                   
 *                                                              
 *  Purpose:    To demonstrate how to launch multiple-threads   
 *              using Java's basic threading model.  This       
 *              particular program launches a thousand threads  
 *              which each take a random number between 500     
 *              million and a billion and calculate the prime
 *              factorization of that number.
 *                                                              
 * Code Source: The code for calculating the prime factorization is based
 *              on code found at:
 *              http://www.vogella.com/tutorials/JavaAlgorithmsPrimeFactorization/article.html
 * 
 ****************************************************************/

package edu.uchicago.gerber.labjava.lec10.glab.more;

import java.util.ArrayList;
import java.util.Random;  

// In order to run a class's methods using a thread, that class has to either
// implement the 'Runnable' interface or it has to extend the Thread class.

// If you take the route of extending the Thread class, your object can't extend any
// other classes (due to Java's single inheritance requirement).  However, if
// you decide to implement the Runnable interface, you have to create an object
// of the Thread class and pass the Runnable object as a parameter (see 'SimpleThreadMain.java').

public class SimplePrimeFactor implements Runnable {
   
    // These variable are used for the prime factorization function    
    
    int number;
    ArrayList<Integer> factors;
    
    // When creating our object, we seed it with a very large random number
    
    public SimplePrimeFactor(){
        Random rand = new Random();
        this.number = (500000000 + rand.nextInt(500000000));
    }
    
    // This is the function that will be run on its own, unique, thread
    
    @Override
    public void run() {
        
        // >> This is where you would put in your actionable code << 
        
        factors = new ArrayList<Integer>();
        int n = number;
        
        for (int i = 2; i <= n / i; i++) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }
        
        if (n > 1) {
            factors.add(n);
        }
        
        // Display the results when finished. Note that we have to use the 'synchronized' keyword to ensure that
        // we don't have threads printing out to the console at the same time, causing overlap
        
        // Note that this object will print out it's thread name once it is done with factoring its number.
        // Besides the name, you can get a thread's ID, priority (between 1 and 10) and status (new, runnable, waiting,
        // timewaiting, or terminated).

        
        synchronized (System.out){
            System.out.printf(Thread.currentThread().getName() + ": The prime factors for " + number + " are: ");
            for (int i = 0; i < factors.size(); i++){
                System.out.printf(factors.get(i) + ", ");
            }
           System.out.printf("\n");
        }
        
    }
       
}
