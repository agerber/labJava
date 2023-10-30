package edu.uchicago.gerber.labjava.lec04._instanceof;
public class ExceptionInstanceOfDemo {

    public static void main(String[] args) {
        RuntimeException[] exceptions = {
                new NullPointerException(),
                new IllegalArgumentException(),
                new IndexOutOfBoundsException(),
                new ArithmeticException()
        };

        for (RuntimeException ex : exceptions) {
            if (ex instanceof NullPointerException) {
                System.out.println("This is a NullPointerException");
            } else if (ex instanceof IllegalArgumentException) {
                System.out.println("This is an IllegalArgumentException");
            } else if (ex instanceof IndexOutOfBoundsException) {
                System.out.println("This is an IndexOutOfBoundsException");
            } else if (ex instanceof ArithmeticException) {
                System.out.println("This is an ArithmeticException");
            } else {
                System.out.println("This is an unrecognized subclass of RuntimeException");
            }
        }
    }
}
