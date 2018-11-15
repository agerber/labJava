package lec01.glab;

import java.util.Scanner;

public class BinaryToDigitalSimple {

    public static void main(String[] args) {

        String strValue = "";
        Scanner in = new Scanner(System.in);
        System.out.println("Enter an string that represents a byte in binary" +
                " : (or type exit to quit.)");
        strValue = in.nextLine();

        strValue = strValue.replaceAll("[^0-1]", "");


        int nPow = 0;
        long lResult = 0;

        for (int nC = strValue.length() - 1; nC >= 0; nC--) {

            if (strValue.charAt(nC) == '1') {
                lResult += (long) Math.pow(2, nPow);
            }
            nPow++;

        }

        System.out.println(lResult);



    }
}
