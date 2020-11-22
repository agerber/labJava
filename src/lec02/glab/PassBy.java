package lec02.glab;

import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: ag
 * Date: 10/6/13
 * Time: 3:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class PassBy  {

    public static void main(String[] args) {

        int nNumber = 5;
        multByFive(nNumber);
        System.out.println("nNumber: " + nNumber);


        Rectangle recSquare = new Rectangle(1,1,10,10);
        //Ox67AB
        doubleRec(recSquare);
        System.out.println("recSquare: " + recSquare);

    }


    //when you pass primitives into methods in Java, the are passed by value, in other words - they are copied.
    private static void multByFive(int nParam){
        nParam  = nParam * 5;
        System.out.println(nParam);

    }


    //when you pass an Object into a method, you are passing by reference, which means you're giving the method the
    //memory address of the object
    private static void doubleRec(Rectangle recParam){
        recParam.setSize(recParam.width * 2, recParam.height * 2);

    }


}
