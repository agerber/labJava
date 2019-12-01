package lec08.glab.lambda.predicate;

import java.util.*;

public class MyTypeSafety {

    public static void main(String[] args) {

        Map map = new TreeMap();



        List<Number> obs = new LinkedList<>();

        obs.add(9019.00);
        obs.add(new Byte((byte)89));
        obs.add(9019);

        for (Number ob : obs) {
            ob.doubleValue();
        }

    }
}
