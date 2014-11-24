package lec09.glab.simpledatastructs.hashtable;

import java.util.Date;

/**
 * Created by ag on 11/24/2014.
 */
public class HashDriver {

    public static void main(String[] args) {


        //highly deterministic. The hash code will ALWAYS be the same

        String strAdam1 = "Adam";
        String strAdam2 = "Adam";

        Date date1 = new Date("11/12/2014");
        Date date2 = new Date("11/12/2014");

        //this is deterministic.
        System.out.println(strAdam1.hashCode());
        System.out.println(strAdam2.hashCode());

        System.out.println(date1.hashCode());
        System.out.println(date2.hashCode());


       // System.out.println(new Object().hashCode());
    }
}
