package lec07.glab.stream.operations.reduce;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

public class MyConsumers {

    public static void main(String[] args) {






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
