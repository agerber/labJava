package lec08.glab.stream.operations.reduce;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;
//  w  w  w  .j a v  a  2 s.c  o m
public class Ex3 {
    public static void main(String[] args) {
        double sum = Employee.persons()
                .stream()
                .reduce(0.0, (partialSum, person) -> partialSum + person.getIncome(), Double::sum);
        System.out.println(sum);

    }
}
