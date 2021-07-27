package edu.uchicago.gerber.labjava.lec08.glab.lambda.behaviorParam2;


import java.util.stream.Stream;

public class MethodReferences {

    public static void main(String[] args) {


        Stream<String> names = Stream.of("Adam", "Bobby", "Charlie", "Derek", "Ellie", "Fred", "Georgiette", "Henry");

       // names = names.parallel();

        //int[] nC = {0};


        names
              //  .filter(n -> n.length() < 6)  //intermediate operation
                .sorted((a1, a2) -> -1 * a1.compareTo(a2))
                .map(s -> new Employee(s))
                .map(employee -> new String(employee.getName()))
                .map(str -> new Integer(str.length()))
                .forEach(System.out::println); //terminal operation

        Stream.of("Adam", "Bobby", "Charlie", "Derek", "Ellie", "Fred", "Georgiette", "Henry")

                .sorted((a1, a2) -> -1 * a1.compareTo(a2))
                .map(s -> new Employee(s))
                .map(employee -> new String(employee.getName()))
                .map(str -> new Integer(str.length()))
                .forEach(System.out::println); //terminal operation
    }


}

class Employee {

    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Employee(String name) {
        this.name = name;
        this.age = 21;
    }

    public Employee() {
        this.name = "John Doe";
        this.age = 21;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
