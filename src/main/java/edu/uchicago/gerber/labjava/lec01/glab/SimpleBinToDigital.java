package edu.uchicago.gerber.labjava.lec01.glab;

/**
 * Created by Adam on 9/26/2016.
 */
public class SimpleBinToDigital {

    //get binary number from user
    //initialize an int nPow to zero; and nResult to zero
    //for each char in string (iterate over the string backwards) exclude the sign bit
        //if the char is 1
            //increment the nResult by 2^nPow
        //increment nPow
    //return nResul

    public static void main(String[] args) {


     //   String strBinary = "0001 0011"; //19
        //String strBinary = "0000 1011"; // 11
       // String strBinary = "0111 1111"; //127
        String strBinary = "1000 0000"; //-128
       // String strBinary = "1111 1111"; //-1
       // String strBinary = "1111 0111"; //-9

                            //2^2     //2^1      // 2^0

        //strip out any spaces
        strBinary = strBinary.replace(" ", "");

        int power =0;
        int result = 0;

        char[] chars = new StringBuilder(strBinary).reverse().toString().toCharArray();

        for (int nC = 0; nC < chars.length -1; nC++) {
            if (chars[nC] == '1') {
                result += Math.pow(2, power);
            }
            power++;
        }
        //the sign bit
        if (chars[chars.length-1] == '1'){
            result = result - 128;
        }

        System.out.println(result);

    }
}
