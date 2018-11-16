package lec08.glab.stream.operations.filter;

import lec08.glab.stream.ops.Employee;

public class Ex5 {
    public static void main(String[] args) {
        Employee.persons()
                .stream()
                .filter(Employee::isMale)
                .filter(p ->  p.getIncome() > 5000.0)
                .map(Employee::getName)
                .forEach(System.out::println);
    }
}
