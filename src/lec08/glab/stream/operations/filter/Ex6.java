package lec08.glab.stream.operations.filter;



public class Ex6 {
    public static void main(String[] args) {
        Employee.persons()
                .stream()
                .filter(p ->  p.isMale() &&   p.getIncome() > 5000.0)
                .map(Employee::getName)
                .forEach(System.out::println);
    }
}
