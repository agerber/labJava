package lec01.glab;

/**
 * Created by Adam on 10/4/2015.
 */
public class MoreDownCasting {

    public static void main(String[] args) {


        System.out.println("integer values");
        //try the following 259, 132, 128
        short sResult = 132;
        byte yResult = (byte) sResult;
        System.out.println(yResult);

        System.out.println("float values");

        //double to float downcasting
        double dValue1 = 0.000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000012;
        double dValue2 = 101.6546465465464321351654313465123168768546134650646546546546546545645645646545646546546546545646546654564654646546540303212;
        float fValue1 = (float)dValue1;
        float fValue2 = (float)dValue2;


        System.out.println("As float " + String.valueOf(fValue1));
        System.out.println("As double " + String.valueOf(dValue1));

        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&");

        System.out.println("As float " + String.valueOf(fValue2));
        System.out.println("As double " + String.valueOf(dValue2));


        System.out.println("truncate and then round");
        //truncate by casting to int
        System.out.println((int)  dValue2);
        //round by rounding
        System.out.println(Math.round(dValue2));



    }
}
