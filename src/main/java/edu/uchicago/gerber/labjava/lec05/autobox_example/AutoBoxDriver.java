package edu.uchicago.gerber.labjava.lec05.autobox_example;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ag on 10/27/2014.
 */
public class AutoBoxDriver {




    public static void main(String[] args) {

        //Auto UnBoxing
        int nNum = new Integer(12);


        //Auto Boxing
        Double dubNum = 56.87;
        double dDub = dubNum;

        System.out.println(" this is my dubNum" + dubNum.getClass().getCanonicalName());

        List<Character> chrChars = new ArrayList<>();
        //Auto-boxing
        chrChars.add(new Character('A'));
        chrChars.add('d');
        chrChars.add('a');
        chrChars.add('m');


        //Auto-unboxing
        char mVar = chrChars.get(3);


        System.out.print("The number stored in nNum is " + nNum + " and the number stored in dubNum is " + dubNum + " and the Characters stored in chrChars are: ");

        for (Character chrChar : chrChars) {
            System.out.print(chrChar);
        }



    }


}
