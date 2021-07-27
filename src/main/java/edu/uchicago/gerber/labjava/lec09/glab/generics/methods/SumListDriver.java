package edu.uchicago.gerber.labjava.lec09.glab.generics.methods;
import java.util.ArrayList;

public class SumListDriver {
    public static void main(String args[]) {
        Integer[] integers = { 1, 2, 3, 4, 5 };
        ArrayList<Integer> integerList = new ArrayList<Integer>();

        for (Integer element : integers)
            integerList.add(element);

        System.out.printf("integerList contains: %s\n", integerList);
        System.out.printf("Total of the elements in integerList: %.0f\n\n", sum(integerList));

        Double[] doubles = { 1.1, 3.3, 5.5 };
        ArrayList<Double> doubleList = new ArrayList<Double>();

        for (Double element : doubles)
            doubleList.add(element);

        System.out.printf("doubleList contains: %s\n", doubleList);
        System.out.printf("Total of the elements in doubleList: %.1f\n\n", sum(doubleList));

        Number[] numbers = { 1, 2.4, 3, 4.1 }; // Integers and Doubles
        ArrayList<Number> numberList = new ArrayList<Number>();

        for (Number element : numbers)
            numberList.add(element);

        System.out.printf("numberList contains: %s\n", numberList);
        System.out.printf("Total of the elements in numberList: %.1f\n", sum(numberList));

        System.out.printf("Total of the elements in numberList: %.1f\n",   sum(putAll(numberList)));

    }

    //producer which gets the items in the list, uses extends.
    public static double sum(ArrayList<? extends Number> list) {
        double total = 0;

        for (Number element : list)
            total += element.doubleValue();

        return total;
    }

    //consumer which puts the items into the list - notice the user of super
    public static  ArrayList<Number> putAll(ArrayList<? super Number> list, Number... nums) {

        for (Object o : list) {
            list.add(((Number)o));
        }

        list.add(new Double(5.6));
        list.add(new Double(5.7));
        list.add(new Integer(99));

        return (ArrayList<Number>) list;


    }






    //normal producer
    public static double sumNormal(ArrayList<Number> list) {
        double total = 0;

        for (Number element : list)
            total += element.doubleValue();

        return total;
    }

    //normal consumer
    public static  ArrayList<Number> putAllNormal(ArrayList<Number> list, Number... nums) {


        for (Number number : list) {
            list.add(number);
        }

        list.add(new Double(5.6));
        list.add(new Double(5.7));
        list.add(new Integer(99));

        return  list;


    }




}