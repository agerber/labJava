package edu.uchicago.gerber.labjava.lec06.generics.basics;
import java.awt.*;
import java.util.*;
import java.util.List;

public class TypeSafetyDriver {
    public static void main(String[] args) {

        //no type safety
        List objObjects = new ArrayList();

        objObjects.add("Adam");
        objObjects.add(2018);
        objObjects.add(new Object());
        objObjects.add(new Rectangle(1,2,3,4));


        //dangerous!!!
        String s1 = (String) objObjects.get(0);
        System.out.println(s1.toUpperCase());





        //with type safety (diamond notation)
        List<String> strNames = new ArrayList<>();
        strNames.add("Adam");
        strNames.add("Bobby");
        strNames.add("Charlie");

        // strNames.add(2018);  //compile time type checking - nope!


        String s2 = strNames.get(2);
        System.out.println(s2.toUpperCase());

        //with type safety (diamond notation)
        List<Number> numNumbers = new ArrayList<>();
        numNumbers.add(20145);
        numNumbers.add(new Double(67.8));
        numNumbers.add(78.44556F);

        for (Number numNumber : numNumbers) {
            System.out.println(numNumber.doubleValue());
        }



        //polymorphism works as well,
        List<Number> numNums = new LinkedList<>();
        numNums.add(new Double(45.67));
        numNums.add(new Integer(12));
        numNums.add(new Float(12.98));

        Collections.sort(numNums, new Comparator<Number>() {
            @Override
            public int compare(Number num1, Number num2) {
                if (num1.doubleValue() < num2.doubleValue()){
                    return -1;
                } else if (num1.doubleValue() > num2.doubleValue()){
                    return 1;

                } else {
                    return 0;
                }}}
        );


        for (Number numNum : numNums) {
            System.out.println(numNum.toString());
        }
    }


}
