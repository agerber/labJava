package edu.uchicago.gerber.labjava.lec04._overloading;

public class ComprehensiveOverloadingDemo {

    public static void main(String[] args) {
        MathOperation operation = new MathOperation();

        System.out.println(operation.multiply(5, 4));          // Outputs: 20 (int, int)
        System.out.println(operation.multiply(5.0, 4));        // Outputs: 20.0 (double, int)
        System.out.println(operation.multiply(5, 4.0));        // Outputs: 20.0 (int, double)
        System.out.println(operation.multiply(5.0, 4.0));      // Outputs: 20.0 (double, double)
        System.out.println(operation.multiply(5));             // Outputs: 10 (single int parameter)
        System.out.println(operation.multiply(5, 4, 3));       // Outputs: 60 (int, int, int)
    }

    static class MathOperation {

        // Multiply two integers
        public int multiply(int a, int b) {
            return a * b;
        }

        // Multiply a double and an int
        public double multiply(double a, int b) {
            return a * b;
        }

        // Multiply an int and a double
        public double multiply(int a, double b) {
            return a * b;
        }

        // Multiply two doubles
        public double multiply(double a, double b) {
            return a * b;
        }


        // Multiply three integers (Overloading by number of parameters)
        public int multiply(int a, int b, int c) {
            return a * b * c;
        }


        // Multiply a single int (Overloading by number of parameters)
        public int multiply(int a) {
            return a * 2;
        }

        // simply changing the return type is not sufficient to
        //overload a method

//        public double multiply(int a) {
//            return (double) ( a * 2);
//        }



    }
}
