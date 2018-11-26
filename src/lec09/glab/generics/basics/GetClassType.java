package lec09.glab.generics.basics;

import java.util.ArrayList;
import java.util.List;

public class GetClassType {

    public static void main(String[] args) {

        //thse will be Strings stored in Object references at Runtime
        List<String> lst1 = new ArrayList<>();
        lst1.add("Adam");

        //thse will be Integers stored in Object references at Runtime
        List<Integer> lst2 = new ArrayList<>();
        lst2.add(100);

        //these are just ArrayList of Objects. The Parameteriziation helps to limit what can go in what comes out objects or data structures.
        System.out.println(lst1.getClass());
        System.out.println(lst2.getClass());


        System.out.println(lst1.get(0).getClass());
        System.out.println(lst2.get(0).getClass());





    }
}
