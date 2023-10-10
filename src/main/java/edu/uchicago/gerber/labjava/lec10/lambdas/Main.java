package edu.uchicago.gerber.labjava.lec10.lambdas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.LongPredicate;
import java.util.stream.Collectors;
import java.util.stream.LongStream;


public class Main {


    public static void main(String... args) {

        ArrayList<Circle> theseCircles = new ArrayList<Circle>();

//        Instantiate the Circles and put them in an array list
        theseCircles.add(new Circle(200, 200, 23, "Jim"));
        theseCircles.add(new Circle(25, 25, 15, "Bob"));
        theseCircles.add(new Circle(430, 450, 29, "Batman"));

        theseCircles.add(new Circle(180, 190, 30, "AntiJim"));
        theseCircles.add(new Circle(20, 25, 20, "AntiBob"));
        theseCircles.add(new Circle(425, 440, 40, "AntiBatman"));

////        Java 7
//        System.out.println("Java 7 Results: ");
////        Clone
//        ArrayList<Circle> j7Circles = new ArrayList<Circle>();
//        for (Circle c: theseCircles){
//            try {
//                j7Circles.add(c.clone());
//            } catch (CloneNotSupportedException cnse) {
//                System.out.println(cnse.getStackTrace());
//            }
//
//        }


        //Behavior Parameterization

        Collections.sort(theseCircles, new Comparator<Circle>() {
            @Override
            public int compare(Circle o1, Circle o2) {
                return Double.compare(o1.getArea(), o2.getArea());
            }
        });


        Collections.sort(theseCircles, new Java7Comparator());

        Collections.sort(theseCircles, (Circle o1, Circle o2) -> Double.compare(o1.getArea(), o2.getArea()));
        Collections.sort(theseCircles, (Circle o1, Circle o2) -> o1.getName().compareTo(o2.getName()));


        //Create a stream and filter it.
        System.out.println("FILTER");
        theseCircles
                .stream()
                .filter(c -> c.getName().contains("Anti"))
                .forEach(c -> System.out.println(c));


        System.out.println();
        System.out.println("MAP");
        theseCircles
                .stream()
                .map(c -> c.toString().toUpperCase())
                .forEach(s -> System.out.println(s));


        System.out.println();
        System.out.println("FILTER+MAP");
        theseCircles
                .stream()
                .filter(c -> c.getName().contains("Anti"))
                .map(c -> c.toString().toUpperCase())
                .forEach(s -> System.out.println(s));



        System.out.println();
        System.out.println("FILTER+MAP+COUNTER");

        AtomicInteger atomicInteger = new AtomicInteger(0);
     // final  int  nCount = 0;
        theseCircles
                .stream()
                .filter(c -> c.getName().contains("Anti"))
                .map(s -> s.toString().toUpperCase())
                .sorted()
                .forEach(
                     s ->
                     {
                         System.out.println(s);
                         atomicInteger.getAndIncrement();
                       //  nCount++;
                     }
                );

        System.out.println("number of s " + atomicInteger);




        //Create parraellel stream

        List<Integer> intVals = new ArrayList<>();

        for (int i = 0; i < Short.MAX_VALUE ; i++) {
            intVals.add(i);
        }

        //will not respect the sort as this is done in parellel.

        intVals
                .parallelStream()
                .filter(l -> isPrime(l))

                //this will kill your parellelism
                //.forEachOrdered(l -> System.out.println(l));
                .forEach(l -> System.out.println(l));















        //Consume



//        for (Circle circle : theseCircles) {
//            System.out.println(circle);
//        }

        theseCircles.forEach(c -> System.out.println(c.getArea()));

        theseCircles.forEach(System.out::println);

        //filter, map, reduce





//        Java 8
//        System.out.println("\n\nJava 8 Results: ");
////        Clone
//        ArrayList<Circle> j8Circles = new ArrayList<Circle>();

//        In theory (line will not compile!)
       // theseCircles.forEach(c -> j8Circles.add(c.clone()));

////        Practical
//        theseCircles.forEach( c -> {
//            try {
//                j8Circles.add(c.clone());
//            } catch (CloneNotSupportedException cnse) {
//                System.out.println(cnse.getStackTrace());
//            }
//        });
//
////        Print Results
//        for (Circle c : theseCircles){
//            System.out.println(c.toString());
//        }


//        Parameters Type Free Comparator
//        Comparator<Circle> customComparator = (c1, c2) -> Double.compare(c1.getArea(), c2.getArea());
//        Collections.sort(j8Circles, customComparator);

//        Lambda Expressions that to the same thing
//        j8Circles.forEach(c -> System.out.println(c));


//        Java 8 - Map Reduce Filter Collect
     //   System.out.println("\n\nJava 8 Streams: ");

//        We want to know the average area of our circles
        double average = theseCircles
                        .stream()
                        .mapToDouble(Circle::getArea)
                        .average()
                        .getAsDouble();

        System.out.println("\nAverage Area of all Circles: " + average);


//        Lets now print the name of all circles whose are is above 2000
        System.out.println("\nAll circles whose area is above 2000");
        theseCircles
        .stream()
        .filter(c -> c.getArea() > 2000)
        .forEach(System.out::println);


//        Now we want to gather all the circles whose name begins with 'Anti'
        System.out.println("\nAll whose name begins with 'Anti' ");
        List<Circle> antiCircles = theseCircles
                                        .stream()
                                        .filter(c -> c.getName().startsWith("Anti"))
                                        .collect(Collectors.toList());
        antiCircles.forEach(System.out::println);

//        Lets now print the circumference for each of the circles, along with their names
//        Also sort by the circumference
        System.out.println("\nCircle Circumferences");
        theseCircles
        .stream()
        .sorted((c1, c2) -> Integer.compare(c1.getRadius(), c2.getRadius()))
        .map(c -> c.getName() + ", circumference: " + c.getRadius() * 2 * Math.PI)
        .forEach(System.out::println);


//        We will emulate the functionality of collision detection in game using stream
//        and in parallel
        System.out.println("\n\nCollides");
        Circle collisionCircle = new Circle(200, 400, 200, "Falcon");
        theseCircles
        .parallelStream()
        .filter(c -> {
            double radius2 = Math.pow((collisionCircle.getRadius() + c.getRadius()), 2);
            double deltaX2 = Math.pow(Math.abs((collisionCircle.getX() - c.getX())), 2);
            double deltaY2 = Math.pow(Math.abs((collisionCircle.getY() - c.getY())), 2);
            return radius2 >= deltaX2 + deltaY2;
        })
        .forEach(c -> System.out.println("I " + c.getName() + " collided with " + collisionCircle.getName()));
    }

 //http://www.java2s.com/Tutorials/Java/Stream_How_to/IntStream/Use_lambda_to_check_if_a_integer_is_a_prime_number.htm
    private static  boolean isPrime(long number) {
        LongPredicate isDivisible = index -> number % index == 0;
        return number > 1 && LongStream.range(2, number - 1).noneMatch(isDivisible);
    }
}
