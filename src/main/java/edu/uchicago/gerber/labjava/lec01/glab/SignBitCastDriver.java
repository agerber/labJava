package edu.uchicago.gerber.labjava.lec01.glab;

import java.util.ArrayList;

public class SignBitCastDriver {
    public static void main(String[] args) {
        //0000_0000_0000_0000_0000_0000_1000_0001
        int nNum = 129;
        byte yMe = (byte) nNum;
        System.out.println(yMe);
    }
}
