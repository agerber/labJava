package edu.uchicago.gerber.labjava.lec01;

/**
 * Created by Adam on 9/26/2016.
 */
public class PrimeChecker {
    public static void main(String[] args) {

        for (int nC = 0; nC < 2054; nC++) {
            if (isPrime(nC)){
                System.out.println(nC);
            }
        }


    }


    //https://www.mkyong.com/java/how-to-determine-a-prime-number-in-java/
    private static boolean isPrime(int n) {
        for(int i=2;2*i<n;i++) {
            if(n%i==0)
                return false;
        }
        return true;
    }
}
