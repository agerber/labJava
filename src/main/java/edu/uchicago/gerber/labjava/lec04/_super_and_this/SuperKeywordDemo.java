package edu.uchicago.gerber.labjava.lec04._super_and_this;

public class SuperKeywordDemo {

    public static void main(String[] args) {
        System.out.println("----- Creating an instance of SubClass -----");
        SubClass obj = new SubClass("Adam", 5);
        obj.display();
    }

    // Superclass with fields and a method
    static abstract class SuperClass {
        private String name;

        SuperClass(String name) {
            this.name = name;

        }

        void display() {
            System.out.println("Name from SuperClass: " + name);
        }

        protected String getName(){
            return this.name;
        }
    }

    // Subclass that extends the SuperClass and demonstrates the use of 'super'
    static class SubClass extends SuperClass {

        private int value;

        SubClass(String name, int value) {
            super(name);
            this.value = value;
        }

        @Override
        void display() {
            super.display();  // Use of 'super' to call the superclass's method
            System.out.println("The value from SubClass: " + value);
            System.out.println("Calling super.getName() : " + super.getName());
        }
    }
}
