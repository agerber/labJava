package lec08.glab.lambda.behaviorParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilteringPeopleJava7 {

    public static void main(String... args) {


        //using java7 to filter poeple

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


        System.out.println("&&&&&&&&&&&&&&&&&& people in china &&&&&&&&&&&&&&&&&&");
        List<Person> chinaPeople = filterChinaPeople(sample);

        for (Person person : chinaPeople) {
            System.out.println(person);
        }

        System.out.println("&&&&&&&&&&&&&&&&&& smart people in china &&&&&&&&&&&&&&&&&&");
        List<Person> smartChinaPeople = filterSmartChinaPeople(sample);

        for (Person person : smartChinaPeople) {
            System.out.println(person);
        }


    }


    private static List<Person> filterChinaPeople(List<Person> sample) {
        List<Person> result = new ArrayList<>();
        for (Person person : sample) {
            if (person.getOrigin().equals("china")) {
                result.add(person);
            }
        }
        return result;
    }


    private static List<Person> filterSmartChinaPeople(List<Person> sample) {
        List<Person> result = new ArrayList<>();
        for (Person person : sample) {
            if (person.getOrigin().equals("china") && person.getIq() > 150) {
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
