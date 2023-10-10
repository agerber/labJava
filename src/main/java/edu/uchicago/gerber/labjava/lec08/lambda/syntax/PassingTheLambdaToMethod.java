package edu.uchicago.gerber.labjava.lec08.lambda.syntax;

//http://www.java2s.com/Tutorials/Java/Java_Lambda/0050__Java_Lambda_Behaviour_Parameter.htm
public class PassingTheLambdaToMethod {

    public static void main(String[] argv) {
        engine((x,y)-> x + y);
        engine((x,y)-> x * y);
        engine((x,y)-> x / y);
        engine((x,y)-> x % y);
    }

    //We can define methods that take Functional interfaces as well.
    private static void engine(Calculator calculator){
        int x = 2, y = 4;
        int result = calculator.calculate(x,y);
        System.out.println(result);
    }
}

@FunctionalInterface
interface Calculator{
    int calculate(int x, int y);
}
