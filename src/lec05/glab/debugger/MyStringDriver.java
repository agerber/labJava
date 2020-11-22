package lec05.glab.debugger;

import java.awt.*;
import java.util.Date;

public class MyStringDriver {

    public static void main(String[] args) {


        System.out.println("My name is " + args[0]);
        System.out.println("My age is " + Integer.parseInt( args[1]));


//        Object[] myArray = { new Rectangle(1,2,3,4), 78, 5.4, new Date()};
//        printMyArray(6, myArray);
        printMyArray(2, new Rectangle(1,2,3,4),78, 5.4, new Date(), 334, 34354, new Object(), new Date());



    }

    private static void printMyArray(int n, Object... objects){

        System.out.println(" this is my number: "+ n);
        for (int nC = 0; nC < objects.length; nC++) {
            System.out.println(objects[nC]);

        }
    }


}
