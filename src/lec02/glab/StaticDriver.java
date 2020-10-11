package lec02.glab;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: ag
 * Date: 10/7/13
 * Time: 1:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class StaticDriver {

    public static void main(String[] args) {


        //non-static rectangle object which is the implicit parameter

        Rectangle rectangle = new Rectangle(1,2,3,4);
        System.out.println(rectangle.getCenterX());


        //with static methods, there is more initial overhead. They need to be loaded in memory when the program starts up
        //the compiler will only load those classes that are referenced in code

        //In Java, you can recognize the static context immediately because
        // 1/ We call the method from the Class e.g. Math.pow(), and 2/ there is NO implicit parameter

        //why shouldn't you just create all methods this way, and never allocated memory on the heap using the new keyword

        System.out.println(Convert.tempToImperial(100.0));
        System.out.println(rectangle.getCenterX());



        System.out.println(Math.pow(2,3));

        Math.round(8.909999);

        new Student("ADam", 2020).getGraduate();


        ArrayList<Student> stuStudents = new ArrayList<>();
        Student stu;
        for (int nC = 0; nC < 100 ; nC++) {
            stu =  new Student(String.valueOf( Student.SCHOOL  + " name: " + nC), 2000+ nC);
            stuStudents.add(stu);
            System.out.println(stu);
        }

        System.out.println(Student.getNumStudent());





    }
}
