package edu.uchicago.gerber.labjava.lec08.lambda.methodrefs;

import java.util.Arrays;

public class VariableCapture {
    public static void main(String[] args) {

        final String name = "Adam";  //capture this variable inside a lamba - no problem
        Arrays.asList(1,2,3,4).forEach(element -> System.out.println( element.toString() + name));

    }
}
