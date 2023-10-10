package edu.uchicago.gerber.labjava.lec08.lambda.behaviorParam;



import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.function.*;

/**
 * Created by Adam on 6/22/2016.
 */
public class UsingConsumers {

    public static void main(String[] args) {

        System.out.println("//Consumer");
        //Consumer
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s.toLowerCase());
            }
        };


        List<String> strings = Arrays.asList("hello", "goodbye");
        strings.stream()
                .forEach(consumer);


        System.out.println("//Bi Consumer");
        //BI Consumer
        BiConsumer<Integer, Date> biConsumer = new BiConsumer<Integer, Date>() {
            @Override
            public void accept(Integer integer, Date date) {
                for (int nC = 0; nC < integer; nC++) {
                    date.setTime(date.getTime() + (1 * 24 * 60 * 60 * 1000));
                }
                System.out.println(date);
            }
        };


        biConsumer.accept(8, new Date());

        System.out.println("//Int Consumer");
        //INT Consumer
        IntConsumer intConsumer = new IntConsumer() {
            @Override
            public void accept(int value) {
                System.out.println(value + ": " + (value % 2 == 0 ? "EVEN" : "ODD"));

            }
        };

        List<Integer> intList = Arrays.asList(54, 5, 8, 5, 5, 2, 85, 9954, 555, 4771, 6544);

        for (Integer integer : intList) {
            intConsumer.accept(integer);
        }


        System.out.println("//Double Consumer");
        //Double Consumer
        DoubleConsumer dubConsumer = new DoubleConsumer() {

            @Override
            public void accept(double value) {

                System.out.println(Math.pow(value, 2));
            }
        };

        List<Double> dubList = Arrays.asList(85.63, 9954.966, 555.32, 4771.1, 6544.587);

        for (Double aDouble : dubList) {
            dubConsumer.accept(aDouble);
        }


        System.out.println("//Long Consumer");
        //Long Consumer
        LongConsumer longConsumer = new LongConsumer() {

            @Override
            public void accept(long value) {

                System.out.println(value - 1);
            }
        };


        longConsumer.accept(55555);


        System.out.println("//Call method with function as parameter");
        //Call method with function as parameter

        printDayInAdvance(biConsumer, 3, new Date());


    }


    private static void printDayInAdvance(BiConsumer<Integer, Date> biConsumer, Integer integer, Date date){
        biConsumer.accept(integer, date);
    }


}
