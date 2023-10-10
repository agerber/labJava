package edu.uchicago.gerber.labjava.lec08.lambda.behaviorParam2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Adam on 7/15/2015.
 */
public class UsingSort {


    public static void main(String[] args) {
        List<Person> sample = Arrays.asList(new Person(280, "usa"),
                new Person(189, "china"),
                new Person(155, "russia"),
                new Person(125, "canada"),
                new Person(120, "china"),
                new Person(185, "russia"),
                new Person(155, "china"),
                new Person(195, "usa"),
                new Person(155, "russia"),
                new Person(255, "usa"),
                new Person(155, "usa"),
                new Person(200, "china"));



        //using java7
        System.out.println("using Java7 &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        sample.sort(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getIq().compareTo(o2.getIq());
            }
        });

        for (Person person : sample) {
            System.out.println(person);
        }


        System.out.println("using Java8 &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        //using java8
        //we know that 1/ sort takes one interface called Comparator<T>, 2/ it has one method called compare(T,U)

        sample.sort((a, b) -> a.getOrigin().compareTo(b.getOrigin()));

        for (Person person : sample) {
            System.out.println(person);
        }


        //the difference between sort and sorted is that sort returns void and sorted returns a Stream.

        System.out.println("using Java8 streams &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        //using java8 streams
        //we know that 1/ sort takes one interface called Comparator<T>, 2/ it has one method called compare(T,U)
        sample.stream()
                .sorted((a, b) -> a.getOrigin().compareTo(b.getOrigin())) //intermmediate op
                .forEach(p -> System.out.println(p.toString())); //terminal operation



        System.out.println("using more Java8 streams &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        //using java8 streams
        sample.stream()
                .sorted((a, b) -> a.getOrigin().compareTo(b.getOrigin())) //intermediate op - stream
                .map(p -> new Person(p.getIq(), p.getOrigin().toUpperCase())) //inter stra
                .forEach(p -> System.out.println(p.toString())); //terminal op - consumes





        System.out.println("using yet more Java8 streams &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        //using java8 streams
        sample.stream()
                .filter(p -> p.getOrigin().equals("china") && p.getIq() > 150)
                .sorted((a, b) -> a.getIq().compareTo(b.getIq()))
                .map(p -> new Person(p.getIq(), p.getOrigin().toUpperCase()))
                .forEach(p -> System.out.println("smart chinese person: " + p.toString()));




        System.out.println("using Java8 parallel streams and method references &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        //using java8 stream
        sample.parallelStream()
                .filter(p -> p.getOrigin().equals("china") && p.getIq() > 150)
                .sorted((a, b) -> a.getIq().compareTo(b.getIq()))
                .map(p -> new Person(p.getIq(), p.getOrigin().toUpperCase()))
               // .forEach(p -> System.out.println(p));
                 .forEach(System.out::println);  //using a method reference which is the same as above.



    }





    //our POJO
    public static class Person {
        private int iq = 0;
        private String origin = "";

        public Person(int iq, String origin) {
            this.iq = iq;
            this.origin = origin;
        }

        public Integer getIq() {
            return iq;
        }

        public void setIq(Integer iq) {
            this.iq = iq;
        }

        public String getOrigin() {
            return origin;
        }

        public void setOrigin(String origin) {
            this.origin = origin;
        }

        public String toString() {
            return "Person{" +
                    "origin='" + origin + '\'' +
                    ", iq=" + iq +
                    '}';
        }
    }
}
