package edu.uchicago.gerber.labjava.lec08.lambda.syntax;

public class TyperInference {
    public static void main(String[] argv) {
        Processor stringProcessor = (String str) -> str.length();
        SecondProcessor secondProcessor = (String str) -> str.length();
        //from w  w  w. ja  va 2s . c  o  m
        //stringProcessor = secondProcessor; //compile error
        String name = "Java Lambda";
        int length = stringProcessor.getStringLength(name);
        System.out.println(length);

    }
}

@FunctionalInterface
interface Processor {
    int getStringLength(String str);
}

@FunctionalInterface
interface SecondProcessor {
    int noName(String str);
}
