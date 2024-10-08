package edu.uchicago.gerber.labjava.lec07.stream.behaviorparam;

import edu.uchicago.gerber.labjava.lec03.employee.Employee;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SumAllEmployees {

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee("Jack", 28000.01, 3, 4, 1999));
        employees.add(new Employee("Bill", 218000, 3, 4, 1999));
        employees.add(new Employee("John", 88000, 3, 4, 1999));
        employees.add(new Employee("Jane", 198000, 3, 4, 1999));
        employees.add(new Employee("Jody", 18000, 3, 4, 2001));
        employees.add(new Employee("Jason", 21000, 3, 4, 1999));


        //sum the salaries of all employees whose name starts with J and whose hire date year is less than 2000

      double sumOfSalaries =  employees.stream()
                //filter out those employees we don't want
                .filter((Employee employee) -> employee.getName().charAt(0) == 'J')
                .mapToDouble(employee -> employee.getSalary())
                .sum();

        System.out.println("The sum of employee salaries is: " + sumOfSalaries);





    }
}
