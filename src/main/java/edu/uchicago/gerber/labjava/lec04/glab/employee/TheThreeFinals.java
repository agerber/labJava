package edu.uchicago.gerber.labjava.lec04.glab.employee;

public class TheThreeFinals {




    public static void main(String[] args) {

        //1. the first meaning of final is "the buck stops here", you can not extend this class.
        //a good example is Executive. Try to extend Executive to create Ceo

        //2. The second example is final with primitives
        final int total = 500;
        //total += 60;

        //3. the third is final with objects. You may mutate, but you can not re-assign
        final Student student = new Student("Adam", "Economics");
        student.setSchool("Computer Science");
        System.out.println(student.getDescription());
        //student = new Student("Bart", "Poli Sci");



    }
}
