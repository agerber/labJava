package edu.uchicago.gerber.labjava.lec07.stream.operations.filter;


//w  w w  .ja v a 2 s .c o m
public class Ex4 {
    public static void main(String[] args) {
        Employee.persons()
                .stream()
                .filter(Employee::isFemale)
                .map(Employee::getName)
                .forEach(System.out::println);
    }
}

