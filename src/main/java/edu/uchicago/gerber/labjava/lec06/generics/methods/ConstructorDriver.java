package edu.uchicago.gerber.labjava.lec06.generics.methods;

class GenericClass {
    private double val;

    <T extends Number> GenericClass(T arg) {
        val = arg.doubleValue();
    }

    void showValue() {
        System.out.println("val: " + val);
    }
}

public class ConstructorDriver {
    public static void main(String args[]) {

        GenericClass test = new GenericClass(100);
        GenericClass test2 = new GenericClass(123.5F);

        test.showValue();
        test2.showValue();
    }
}
