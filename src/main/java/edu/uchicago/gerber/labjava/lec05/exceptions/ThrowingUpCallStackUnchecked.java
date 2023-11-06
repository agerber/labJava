package edu.uchicago.gerber.labjava.lec05.exceptions;

import java.util.Scanner;

public class ThrowingUpCallStackUnchecked {
    public static void main(String[] args) {

       // method1();

        try {
            method1();
        } catch (NumberFormatException e) {
            System.out.print("Sorry, try again. ");
            method1();
        }
    }


    private static void method1() throws NumberFormatException{

        method2();

    }
    private static void method2() throws NumberFormatException{
        method3();
    }

    private static void method3() throws NumberFormatException{
        Scanner in = new Scanner(System.in);
        int num;
        System.out.println("Enter your integer:");
        //this threatens to throw an unchecked exception
        num =  Integer.parseInt(in.nextLine());
        System.out.println("Well done, " + num + " is an integer." );
    }


}
