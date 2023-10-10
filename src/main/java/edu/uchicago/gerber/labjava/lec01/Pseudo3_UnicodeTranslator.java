package edu.uchicago.gerber.labjava.lec01;

import java.util.Scanner;

public class Pseudo3_UnicodeTranslator {



    public static void main(String[] args) {

    /*

//get input-string from user
//print “your message in unicode-integer is:”
//for each char in input-string
    //extract the char
    //cast char (unicode) to an int
    //print the int as String within brackets
    //print a space
  */

            Scanner in = new Scanner(System.in);
            System.out.println("Enter your sentence:");
            String sentence = in.nextLine();

            char[] myChars = sentence.toCharArray();

            for (char myChar : myChars) {
                short shortValue = (short) myChar;
                System.out.print("[" + Integer.toHexString(shortValue) + "]" );
                System.out.print(" ");
            }




        }


}
