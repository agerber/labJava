package lec05.glab.autobox_example;

import java.util.ArrayList;

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

        ArrayList<Character> chrChars = new ArrayList<>();
        chrChars.add('a');
        chrChars.add('d');
        chrChars.add('a');
        chrChars.add('m');


        char mVar = chrChars.get(3);


        System.out.print("The number stored in nNum is " + nNum + " and the number stored in dubNum is " + dubNum + " and the Characters stored in chrChars are: ");

        for (Character chrChar : chrChars) {
            System.out.print(chrChar);
        }



    }


}
