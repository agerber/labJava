package edu.uchicago.gerber.labjava.lec01.glab;

public class PrefixPostfixDriver {
    public static void main(String[] args) {

        //postfix
        int numPost = 0;
        System.out.println(numPost++);
        //numPost is incremented after the expression above is evaluated
        System.out.println(numPost);

        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");

        //prefix
        int numPre = 0;
        System.out.println(++numPre); //numPre is incremented then the expression is evaluated
        System.out.println(numPre);








    }
}
