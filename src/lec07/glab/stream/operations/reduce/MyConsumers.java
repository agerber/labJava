package lec07.glab.stream.operations.reduce;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

public class MyConsumers {

    public static void main(String[] args) {


        final Consumer<Student> studentConsumer = student -> System.out.println(student.toString());
        Stream.of("Adam", "Bobby", "Carla", "Danny", "Ellie", "Frank", "Gregg")
                .map((String name) ->
                {
                    if (name.contains("e"))
                        return new Student(name, "Electrical Engineering");
                    else
                        return new Student(name, "Computer Science");
                }) //this returns Stream<Student>
                .filter(student -> student.getMajor().contains("Computer")) // returns Stream<Student>
                .forEach(studentConsumer);


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
