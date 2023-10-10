package edu.uchicago.gerber.labjava.lec02.glab.casting;

/**
 * Created by Adam on 10/3/2016.
 */
public class PrimitiveCastingDriver {
    public static void main(String[] args) {


        System.out.println("UPCASTING PRIMITIVES IS PERFECTLY SAFE.");
        System.out.println();
        System.out.println();

        //upcasting primitive ints is perfectly safe
        byte yAge = 45;
        short sAge = (short) yAge;
        System.out.println(yAge + " UPCASTING from Byte to Short " + sAge);
        System.out.println(intToString(sAge, Short.SIZE));
        System.out.print(spitBlanks(Byte.SIZE));
        System.out.println(intToString(yAge, Byte.SIZE));


        System.out.println();
        System.out.println();

        //upcasting primitive ints is perfectly safe
        short sFan = Short.MAX_VALUE;
        int nFan = (short) sFan;
        System.out.println(sFan + " UPCASTING from Short to Int " + nFan);
        System.out.println(intToString(nFan, Integer.SIZE));
        System.out.print(spitBlanks(Short.SIZE));
        System.out.println(intToString(sFan, Short.SIZE));

        System.out.println();
        System.out.println();

        System.out.println("DOWNCASTING PRIMITIVES IS HIGHLY UNPREDUCTABLE. Make sure the value can be held in the variable");

        System.out.println();
        System.out.println();

        //downcasting primitive ints is dangerous
        short sNum = 385;
        byte yNum = (byte) sNum;
        System.out.println(sNum + " DOWNCASTING from Short to Byte " + yNum);
        System.out.println(intToString(sNum, Short.SIZE));
        System.out.print(spitBlanks(Byte.SIZE));
        System.out.println(intToString(yNum, Byte.SIZE));

        System.out.println();
        System.out.println();

        //downcasting primitive ints is dangerours
        int nAmerica = 350_000_001;
        short sAmerica = (short) nAmerica;
        System.out.println(nAmerica + " DOWNCASTING from Integer to Short " + sAmerica);

        System.out.println(intToString(nAmerica, Integer.SIZE));
        System.out.print(spitBlanks(Short.SIZE));
        System.out.println(intToString(sAmerica, Short.SIZE));




    }

    //http://stackoverflow.com/questions/5263187/print-an-integer-in-binary-format-in-java
    private static String intToString(long number, int bitsInType) {
        StringBuilder result = new StringBuilder();

        for(long i = bitsInType-1; i >= 0 ; i--) {
            long mask = 1 << i;
            result.append((number & mask) != 0 ? "1" : "0");

            if (i % 4 == 0)
                result.append(" ");
        }
        result.replace(result.length() - 1, result.length(), "");

        return result.toString();
    }

    private static String spitBlanks( int bitsInType) {
        StringBuilder result = new StringBuilder();

        for(int i = bitsInType-1; i >= 0 ; i--) {

                result.append(" ");

            if (i % 4 == 0)
                result.append(" ");
        }


        return result.toString();
    }
}
