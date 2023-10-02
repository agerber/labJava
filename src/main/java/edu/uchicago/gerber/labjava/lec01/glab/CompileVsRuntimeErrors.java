package edu.uchicago.gerber.labjava.lec01.glab;

import java.util.Random;

public class CompileVsRuntimeErrors {

    public static void main(String[] args) {

        //a compile time error is a code syntax error that will prevent you from compiling.
        //int random = Random.class.getName();


        //runtime error will manifest at runtime. These may not necessarily result in a crash, and they are
        //more incidious than compile-time errors.
        int ZERO = 0;
        System.out.println(100 / ZERO);

        //another runtime error
        Integer.parseInt("SeventyEight");


    }
}
