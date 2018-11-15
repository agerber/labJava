package lec01.glab;

import java.util.Scanner;


public class SimpleBinary {


    public static void main(String[] args) {

        //get a string from the user that represents a binary number
        //replace anything that's not a 1 or a 0
        //int nPow = 0
        // long lResult = 0

        //for each value in my string from right to left
            //if the value is 1
                // increment the result by 2^nPow

           //increment nPow

        //output the result


        Double dubMe;

        String strValue = "";
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a string that represents a binary number");

        strValue = in.nextLine();
        strValue = strValue.replaceAll("[^0-1]", "");

        int nPow = 0;
        long lResult = 0;

        for (int nC = strValue.length() - 1; nC >= 0; nC--) {

            if (strValue.charAt(nC) == '1'){
                lResult = lResult + (long) Math.pow(2, nPow);
            }


            nPow++;

        }

        System.out.println(lResult);








    }

}
