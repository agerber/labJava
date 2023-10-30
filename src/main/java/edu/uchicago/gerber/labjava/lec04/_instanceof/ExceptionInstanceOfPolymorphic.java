package edu.uchicago.gerber.labjava.lec04._instanceof;

import java.io.EOFException;
import java.io.IOException;

public class ExceptionInstanceOfPolymorphic {

    public static void main(String[] args) {
        Exception[] exceptions = {
                new NullPointerException(),
                new EOFException()
        };

        //InstanceOf is also polymorphic
        for (Exception ex : exceptions) {
            if (ex instanceof RuntimeException) {
                System.out.println("This is a RuntimeException - and is unchecked");
            } else if (ex instanceof IOException) {
                System.out.println("This is an IOException - and is checked");
            }

        }
    }
}
