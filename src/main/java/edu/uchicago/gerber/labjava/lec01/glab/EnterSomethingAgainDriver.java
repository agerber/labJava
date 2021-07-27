package edu.uchicago.gerber.labjava.lec01.glab;

import java.util.Scanner;

public class EnterSomethingAgainDriver {


    //declare a string to hold input
    //while input != exit
        //ask for input and give instructions
        //print integer-values of chars

    public static void main(String[] args) {


        System.out.println("What is your input or type exit to quit:");
        Scanner in = new Scanner(System.in);
        String strInput = in.nextLine();

        do {

            StringBuilder stringBuilder = new StringBuilder();

            for (int nCounter = 0; nCounter < strInput.length(); nCounter++) {
                stringBuilder.append("[" + Character.getNumericValue(strInput.charAt(nCounter)) + "]");
            }


        } while (!strInput.equals("exit"));

    }
}
