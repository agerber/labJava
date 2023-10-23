package edu.uchicago.gerber.labjava.lec03._employee;

import java.util.LinkedList;

class Employee {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee [Name: " + name + ", Salary: " + salary + "]";
    }
}

class Manager extends Employee {
    private String department;

    public Manager(String name, double salary, String department) {
        super(name, salary);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return "Manager [Name: " + getName() + ", Salary: " + getSalary() + ", Department: " + department + "]";
    }
}

// a final class means that we can not extend this class (and therefore we can not override its methods)
 final class Executive extends Manager {
    private double bonus;

    public Executive(String name, double salary, String department, double bonus) {
        super(name, salary, department);
        this.bonus = bonus;
    }

    //final means we can NOT override this method
    public final void sayTitle(String title){
        System.out.println("Hello, my name is " + getName() + " and I'm a " + title);
    }

    public double getBonus() {
        return bonus;
    }

    @Override
    public String toString() {
        return "Executive [Name: " + getName() + ", Salary: " + getSalary() + ", Department: " + getDepartment() + ", Bonus: " + bonus + "]";
    }
}

public class InheritanceDemo {
    public static void main(String[] args) {
        LinkedList<Employee> employees = new LinkedList<>();

        // Generate 20 Employees
        for (int i = 1; i <= 20; i++) {
            employees.add(new Employee("Employee" + i, 50000 + i * 1000));
        }

        // Generate 10 Managers
        for (int i = 1; i <= 10; i++) {
            employees.add(new Manager("Manager" + i, 70000 + i * 1500, "Department" + i));
        }

        // Generate 3 Executives
        for (int i = 1; i <= 3; i++) {
            employees.add(new Executive("Executive" + i, 90000 + i * 2000, "Department" + (10 + i), 5000 + i * 500));
        }

        // Iterate and call toString() method
        for (Employee emp : employees) {
            System.out.println(emp.toString());
            if (emp instanceof Executive)
                ((Executive) emp).sayTitle("CIO");
        }
    }
}
