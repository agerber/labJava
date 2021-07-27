package edu.uchicago.gerber.labjava.lec08.glab.lambda.syntax;

public class ReturningLambdas {
    public static void main(String[] argv) {

        System.out.println(create().calculate(2, 2));

    }
    //We can also return Lambdas
    private static MyReturned create() {
        return (x, y) -> x / y;
    }
}

@FunctionalInterface
interface MyReturned {
    long calculate(long x, long y);
}