
/****************************************************************
 * 
 *  Program:    SimpleThread                                   
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
package edu.uchicago.gerber.labjava.lec10.more;

public class SimpleThreadMain {

    public static void main(String args[]){
          
        for(int i = 0; i < 1000; i++){
           new Thread(new SimplePrimeFactor()).start();
        }
        
    }
       
}
