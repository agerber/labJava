package lec07.glab.recursion;

public class RecurseAgainDriver {

    public static void main(String[] args) {


        System.out.println(reverso("abcdefghijklmnopqrstuvwxyz"));
        System.out.println(yodaString("speak no evil jedi"));
        System.out.println(factorial(5));
        System.out.println(replaceChar("This is so cool isn't it?", 'i', 'j'));

    }

    private static String reverso(String chars){

        //base case
        if (chars.length() ==1 ){
            return String.valueOf(chars.charAt(0));
            //recruseiv ecase
        } else {
            return chars.charAt(chars.length() -1) + reverso(chars.substring(0, chars.length() -1));
        }

    }


    private static String yodaString(String wiseWords){

        //base case(s)
        if (wiseWords.lastIndexOf(' ') < 1){
            return wiseWords;
        }
        //recursive case(s)
        else {
            return  wiseWords.substring(wiseWords.lastIndexOf(' ') + 1, wiseWords.length())  + " " + yodaString(wiseWords.substring(0, wiseWords.lastIndexOf(' ')));
        }

    }

    private static int factorial(int factor){

        //base case
        if (factor < 1){
            throw  new ArithmeticException("not a valid factor");
        }
        //base case
        else if (factor == 1){
            return factor;
        }
        //recursive case
        else {
            return  factor * factorial(factor -1);
        }

    }

    private static String replaceChar(String sentence, char cOrig, char cNew){

        //base case
        if (sentence.length() == 1){
            return sentence;
        }
        //recursive case
        else {
            char cFirst = sentence.charAt(0);
            cFirst =  (cFirst == cOrig) ? cNew : cFirst;
            return cFirst + replaceChar(sentence.substring(1), cOrig, cNew);
        }
    }




}
