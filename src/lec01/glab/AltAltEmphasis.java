package lec01.glab;

import java.util.Scanner;
//import  java.lang.*;

/**
 * Created by Adam on 9/26/2016.
 */
public class AltAltEmphasis {


    /*

    //next
//replace any two spaces with one space
//trim any spaces on ends of String
//define a boolean flag
//for each char in sentence
	//if space
		//flip flag

	//if flag
		//print the char upper
	//else
		//print the char lower
     */


    public static void main(String[] args) {






        Scanner in = new Scanner(System.in);
        System.out.println("Enter your sentence:");
        String strSentence = in.nextLine();

        strSentence = strSentence.replace("  ", " ");

        boolean bSpace = false;
        char cChar;
        for (int nC = 0; nC < strSentence.length(); nC++) {
            cChar = strSentence.charAt(nC);
            if (cChar == ' '){
                bSpace = !bSpace;
            }

            if(bSpace){
                System.out.print(String.valueOf(cChar).toUpperCase());
            }

            else {
                System.out.print(String.valueOf(cChar).toLowerCase());


            }


        }

    }
}
