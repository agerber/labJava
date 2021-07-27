package edu.uchicago.gerber.labjava.lec07.glab.stream.operations.map;



import java.util.function.Function;
import java.util.stream.Stream;

public class MyFunctions {

    public static void main(String[] args) {


//        final Function<String, Student> studentFunction = name ->
//        {
//            if (name.contains("e"))
//                return new Student(name, "Electrical Engineering");
//            else
//                return new Student(name, "Computer Science");
//        };


        final Function<String, Student> stringStudentFunction = (n) ->
        {
            if (n.contains("e"))
                return new Student(n, "Electrical Engineering");
            else
                return new Student(n, "Computer Science");
        };

        Stream.of("Adam", "Bobby", "Carla", "Danny", "Ellie", "Frank", "Gregg")  //Stream<String>
                .map(stringStudentFunction) //this returns Stream<Student>
                .filter(student -> student.getMajor().contains("Computer")) // returns Stream<Student>
                .forEach(student -> System.out.println(student.toString()));


    }

}

class Student {
    private String name;
    private String major;

    public Student(String name, String major) {
        this.name = name;
        this.major = major;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", major='" + major + '\'' +
                '}';
    }
}
