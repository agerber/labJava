package edu.uchicago.gerber.labjava.lec05.debug;

public class DebugDriver {

    public static void main(String[] args) {

        for (int nC = 0; nC < 10; nC++) {
            reportSquash(nC);


        }


    }

    private static void reportSquash(int nC) {
        System.out.println("Squash is fun" + nC);
    }


}
