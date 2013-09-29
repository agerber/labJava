package lec01.glab;

import java.util.Scanner;


public class AlternateEmphasis {

    /**
     Write a program that asks the user for a sentence and then splits the sentence into words, and then
     displays alternating words as UPPERCASE.


     Write the same program, but don't split the setence, rather detect a space and flip a boolean flag
     */
	public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        //ask the user for input
        System.out.println("Enter a sentence please:");
        String[] strWords =  in.nextLine().split(" ");
        int nCount = 0;
        for (String strWord : strWords) {
            if (nCount % 2 == 0){
                System.out.print(strWord.toUpperCase() + " ");
            }
            else {
                System.out.print(strWord.toLowerCase() + " ");
            }
            nCount++;
        }

    }
		


	
	
}
