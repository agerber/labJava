package edu.uchicago.gerber.labjava.lec07.stream.behaviorparam;

import edu.uchicago.gerber.labjava.lec03.employee.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GetAllEmployees {


    public static void main(String[] args) {
        //create a method that returns a subset of
        //employees that make less that 30k

        // In Java7 we have to use an accumulator to accomplish this.
        // we must use an imperative approach. Imperative means descrbing
        //the algorithm in terms of how a computer processes data, in terms
        //of conditional and looping logic; think pseudo-code algorithm.

        Employee[] employees = {
                new Employee("Jack", 28000, 3, 4, 1999),
                new Employee("John", 88000, 3, 4, 1999),
                new Employee("Jane", 198000, 3, 4, 1999),
                new Employee("Jody", 18000, 3, 4, 1999),
                new Employee("Jason", 21000, 3, 4, 1999),

        };

        System.out.println("&&&&&&&&&&&&&&& with java7 &&&&&&&&&&&&&&&&&&&&&&");


        //before streams, we need to use an accumulator to do a filter operation
        List<Employee> accumulator = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getSalary() < 30000){
                if (employee.getName().charAt(1) == 'a')
                     accumulator.add(employee);
            }
        }

        for (Employee employee : accumulator) {
                String upperCaseName = employee.getName().toUpperCase();
                System.out.println(upperCaseName);
        }


        System.out.println("&&&&&&&&&&&&&&& with java8 streams &&&&&&&&&&&&&&&&&&&&&&");



        //in one statement, we use functional programming (declarative) we do the same thing
        Arrays.stream(employees)
                .filter(employee -> employee.getSalary() < 30_000)  //Stream<Employee>
                .map(employee -> employee.getName())  //Stream<String>
                .filter(name -> name.charAt(1) == 'a')
                .map(name -> name.toUpperCase())
                .forEach(name -> System.out.println(name)); //Terminal operation






    }

}
