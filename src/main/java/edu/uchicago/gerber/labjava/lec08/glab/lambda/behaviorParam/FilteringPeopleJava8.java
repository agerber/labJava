package edu.uchicago.gerber.labjava.lec08.glab.lambda.behaviorParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class FilteringPeopleJava8 {

    public static void main(String... args) {


        //using java8 to filter poeple

        List<Person> sample = Arrays.asList(
                new Person(280, "usa"),
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


        List<String> myStringList = Arrays.asList("charlie", "adam1", "bob", "adam2");



        //this is simlar to the strategy pattern

        Predicate<Person> chinaPeeps = p -> p.getOrigin().equals("china");
        Predicate<Person> smartPeeps = p -> p.getIq() > 150;
      //  List<Person> chinaPeople1 = filterSomething(sample, chinaPeeps);
        Consumer<Person> printPeeps = p -> System.out.println(p);

     //   List<String> adamResult = filterSomething(myStringList, s -> s.startsWith("adam"));

        List<Person> smartChinaPeople = filterSomething(sample, p -> p.getOrigin().equals("china") && p.getIq() > 150);

//       sample.stream()
//                .filter(chinaPeeps)
//                .filter(smartPeeps)
//                .forEach(System.out::println);

        sample.stream()
                .filter(chinaPeeps)
                .filter(smartPeeps)
                .forEach(printPeeps);



//        for (String person : adamResult) {
//            System.out.println(person);
//        }




    }


   //similar to the strategy pattern

    public static <T> List<T> filterSomething(List<T> sample, Predicate<T> p){
        List<T> result = new ArrayList<>();
        for(T person : sample){
            if(p.test(person)){
                result.add(person);
            }
        }
        return result;
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
