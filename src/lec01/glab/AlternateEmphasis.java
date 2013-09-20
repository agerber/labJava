package lec01.glab;

import java.util.Scanner;


public class AlternateEmphasis {

	/**
	 * @param args
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
