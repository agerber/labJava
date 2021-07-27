package edu.uchicago.gerber.labjava.lec08.glab.lambda.supplier;
import java.util.function.Supplier;
public class Example3 {
    public static void main(String[] args) {
        System.out.println(maker(Employee::new));
    }

    private static Employee maker(Supplier<Employee> fx) {
        return fx.get();
    }
}

class Employee {
    @Override
    public String toString() {
        return "A EMPLOYEE";
    }
}
