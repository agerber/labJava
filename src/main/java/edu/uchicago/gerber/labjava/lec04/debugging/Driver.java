package edu.uchicago.gerber.labjava.lec04.debugging;

/**
 * Created with IntelliJ IDEA.
 * User: ag
 * Date: 11/18/13
 * Time: 11:05 AM
 * To change this template use File | Settings | File Templates.
 */
public class Driver {
    public static void main(String[] args) {

        for (int nC = 0; nC <20 ; nC++) {
            System.out.print("hello");
            doSomething(nC);
        }


    }


    private static void doSomething(int nNum){
        System.out.println(doSomeMore("goodbybe") + nNum);
    }

    private static String doSomeMore(String str){
        return "A" + str;
    }


}
