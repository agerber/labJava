package edu.uchicago.gerber.labjava.lec06.glab.recursion;

public class RecurseMe {

    public static void main(String[] args) {
        System.out.println(facorial(5));
        System.out.println(replaceChar("Banana", 'a', 'o'));

    }

    private static int facorial(int factor){

        //base-case(s)
        if (factor < 1){
            throw  new ArithmeticException("not good!");
        }
        //base(s)
        else if(factor == 1){
            return  factor;
        }
        ////recursive-case(s) must converge towards the b
        else {
            return factor * facorial(factor-1);
        }

    }


    private static String replaceChar(String sentence, char cOrig, char cNew){

        //base-case
        if (sentence == null || sentence.length() == 0){
            throw  new RuntimeException("Sorry, your sentence must contain some data");
        }

        //base-case
        if (sentence.length() == 1){
            return  sentence;
        }

        //recursive-case
        else {
            char cFirst = sentence.charAt(0);
            cFirst = (cFirst == cOrig) ? cNew : cFirst;
            return cFirst +replaceChar(sentence.substring(1), cOrig, cNew);
        }
    }
}
