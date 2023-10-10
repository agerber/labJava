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



       //Stream<Employee> employeeStream = Arrays.stream(employees);



        List<Employee> accumulator = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getSalary() < 30000){
                accumulator.add(employee);
            }
        }


        //let's try to do this with java8



        List<Employee> poorEmployees =
                Arrays.stream(employees)
                .filter(e -> e.getSalary() < 30_000)  //Stream<Employee>
                .collect(Collectors.toList());





        //1/ limit by salary,
        //2/  convert the collection of Employees to a collection of String

        for (Employee employee : employees) {
            if (employee.getSalary() < 30_000 && employee.getName().charAt(1) == 'o'){
                System.out.println(employee.getName().toUpperCase());
            }
        }


        //in one statement, we use functional programming (declarative) we do the same thing
        Arrays.stream(employees)
                .filter(employee -> employee.getSalary() < 30_000)  //Stream<Employee>
                .map(employee -> employee.getName())  //Stream<String>
                .filter(name -> name.charAt(1) == 'o') //Stream<String>
                .forEach(name -> System.out.println(name.toUpperCase())); //Terminal operation






    }

}
