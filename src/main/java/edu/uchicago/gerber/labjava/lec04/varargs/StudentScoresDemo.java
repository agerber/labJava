package edu.uchicago.gerber.labjava.lec04.varargs;

import java.util.Arrays;

public class StudentScoresDemo {

    public static void main(String[] args) {
        StudentScoresDemo demo = new StudentScoresDemo();

        // Creating students with name and test scores
        demo.createStudent("John", 85, 90, 78);
        demo.createStudent("Alice", 72, 88, 91, 69, 85);
        demo.createStudent("Bob", 90, 93);
        demo.createStudent("Emma");
    }

    public class Student {
        private String name;
        private int[] scores;
        private int grade;

        public Student(String name, int... scores) {
            this.name = name;
            this.scores = scores;
            this.grade = calcGrade(scores);
        }

        private int calcGrade(int... scores) {
            double grade = 0.0;
            for (int score : scores) {
                grade += score;
            }
            return (int) Math.round(grade / scores.length);
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", scores=" + Arrays.toString(scores) +
                    ", grade=" + grade +
                    '}';
        }
    }

    public void createStudent(String name, int... scores) {
        Student student = new Student(name, scores);
        System.out.println(student);
    }
}
