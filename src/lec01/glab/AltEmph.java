package lec01.glab;

import java.util.Scanner;

public class AltEmph {


    //get input-message from user
    //Store input-message in String
    //Split the String using space as regex
    //for each word in input-message
        //if even word
             //print word all lower-case
        //else (word is odd)
            //print word all uppper-case

        //print space

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your sentence:");

        String[] words = scanner.nextLine().split(" ");
        int nCount = 0;

        for (String word : words) {
            if (nCount % 2 == 0) {
                System.out.print(word.toUpperCase());
            } else {
                System.out.print(word.toLowerCase());
            }
            nCount++;
            System.out.print(" ");

        }


    }
}
