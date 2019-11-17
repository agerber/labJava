package lec07.glab.stream.operations.reduce;

import java.util.Optional;
//www.ja  v a  2  s  . c om
public class Ex6 {
    public static void main(String[] args) {
        Optional<Employee> person = Employee
                .persons()
                .stream()
                .reduce((p1, p2) -> p1.getIncome() > p2.getIncome() ? p1 : p2);
        if (person.isPresent()) {
            System.out.println("Highest earner: " + person.get());
        } else {
            System.out.println("Could not  get   the   highest earner.");
        }
    }
}