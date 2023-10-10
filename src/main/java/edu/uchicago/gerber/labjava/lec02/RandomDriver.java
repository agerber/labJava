package edu.uchicago.gerber.labjava.lec02;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: ag
 * Date: 10/7/13
 * Time: 2:46 PM
 * To change this template use File | Settings | File Templates.
 */
public class RandomDriver {

    //Random is NOT static -- you need to instantiate an random object


    public static void main(String[] args) {
        Random random = new Random();
        //will generate a number between 0-0.999999999
        System.out.println(random.nextDouble());

        //will multiply the generated double 0-0.9999) by the param
        //then truncate it (not round)
        // 99.999999 will be truncated to 99
        // 0.99999 will be truncated to 0
        //will generate a number between 0 and 99
        System.out.println(random.nextInt(100));



    }

}
