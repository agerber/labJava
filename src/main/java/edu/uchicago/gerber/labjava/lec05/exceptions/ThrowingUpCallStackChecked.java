package edu.uchicago.gerber.labjava.lec05.exceptions;

import java.io.IOException;
import java.util.Scanner;

public class ThrowingUpCallStackChecked {
    public static void main(String[] args) {

       // method1();

        while (true){
            try {
                method1();
                break;
            } catch (IOException e) {
                System.out.print("Sorry, try again. ");
            }
        }


    }


    private static void method1() throws IOException{

        method2();

    }
    private static void method2() throws IOException{
        method3();
    }

    private static void method3() throws IOException {
        Scanner in = new Scanner(System.in);
        int num;
        System.out.println("Enter your integer:");
        //this threatens to throw an unchecked exception
        try {
            num =  Integer.parseInt(in.nextLine());
        } catch (NumberFormatException e) {
            //wrap unchecked exception in a checked Exception
            throw new IOException(e);
        }
        System.out.println("Well done, " + num + " is an integer." );
    }


}
