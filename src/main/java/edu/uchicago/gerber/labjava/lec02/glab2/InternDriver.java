package edu.uchicago.gerber.labjava.lec02.glab2;

public class InternDriver {

    public static void main(String[] args) {

        System.out.println(new Intern("David"));

        Intern intOne = new Intern("Joe");
        Intern intTwo = intOne;

        System.out.println(intTwo);

        System.out.println(intOne == intTwo);


    }
}
