package lec05.glab.reflection;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by ag on 10/27/2014.
 */
public class ReferenceAnonDriver {

    public static void main(String[] args) {


        List<Integer> list = new ArrayList<>();

        //here we are adding reference-anonymous objects to our ArrayList.
        list.add(new Integer(3));
        list.add(new Integer(5));
        list.add(new Integer(8));
        list.add(new Integer(56));


        //here we are adding a reference anonymous Date to or println method
        //try pressing Cntrl-Alt-V to extract variable here to give or reference a name
        System.out.println(new Date());

        




    }
}
