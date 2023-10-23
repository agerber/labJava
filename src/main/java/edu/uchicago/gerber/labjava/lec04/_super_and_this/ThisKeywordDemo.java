package edu.uchicago.gerber.labjava.lec04._super_and_this;

public class ThisKeywordDemo {

    public static void main(String[] args) {
        System.out.println("----- Creating an instance of MyClass -----");
        Instructor instructor1 = new Instructor("Adam", 3);
        Instructor instructor2 = new Instructor("Charlie", 2);
        Instructor instructor3 = new Instructor("Mia", 5);

        instructor3
                .setNameChain("Mi Hyun")
                .setNumChain(6);

        System.out.println(instructor1);
        System.out.println(instructor2);
        System.out.println(instructor3);



    }

    // Demonstrates the use of 'this' in constructors and to differentiate instance variables
    static class Instructor {

        private String name;
        private int numOfClasses;




        // Constructor with one parameter
        Instructor(String name) {
            this.name = name;
        }

        // Constructor with two parameters
        Instructor(String name, int numOfClasses) {
            this(name);  // Use of 'this' to invoke another constructor
            this.numOfClasses = numOfClasses;
        }


        public Instructor setNumChain(int value) {
            this.numOfClasses = value;
            return this;

        }

        public Instructor setNameChain(String name) {
            this.name = name;
            return this;

        }


        @Override
        public String toString() {
            return "Instructor{" +
                    "name='" + name + '\'' +
                    ", numOfClasses=" + numOfClasses +
                    " : The class name is " + this.getClass().toGenericString() +
                    '}';
        }
    }



}
