package edu.uchicago.gerber.labjava.lec02;

public class PossibleStringPool {

    public static void main(String[] args) {

        String str1 = "Adam";
        String str2 = "Adam";
        String str3 = "Adam";
        String str4 = "Adam";
        String str5 = "Adam";
        String str6 = "Adam";

        //it is possible that all object references point to the same object, but
        //we can't guarantee that, and we don't care. Assume they all point to
        //different objects.

        //in practice, this means you should always check the values like so:
        //should print zoer
        System.out.println(str1.compareTo(str6));

        //unreliable in java, could be TRUE!!!!
        System.out.println(str1 == str5);

    }
}
