package edu.uchicago.gerber.labjava.lec01.glab;

import java.util.Scanner;

/**
 * Created by Adam on 9/26/2016.
 //ask the user for a sentence
 //split the sentence into words and store in String[]
 //for each word in array
    //if word is even
        //print upper-case
    //else
        //print lower case

    //print space

 */





public class AltEmphasis {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Enter your sentence:");
        String[] strWords = in.nextLine().split(" ");
        int nCount = 0;

        for (String strWord : strWords) {

            if (nCount % 2 == 0){
                System.out.print(strWord.toUpperCase());
            }

            else {
                System.out.print(strWord.toLowerCase());


            }
            nCount = nCount + 1;
            System.out.print(" ");
        }

        System.out.println("");



    }
}
