package edu.uchicago.gerber.labjava.lec01;

import java.util.Scanner;

/**
 * Created by Adam on 9/26/2016.
 */
public class LettersToNumbers {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String strInput;
        do
        {
            System.out.println("\n\nEnter something: (or exit to quit)");
            strInput = in.nextLine();

            char cChar;
            for (int nC = 0; nC < strInput.length(); nC++) {
                cChar = strInput.charAt(nC);
                System.out.print("[" + Integer.valueOf(cChar) + "] ");
            }



        } while(!strInput.equals("exit"));
    }
}
