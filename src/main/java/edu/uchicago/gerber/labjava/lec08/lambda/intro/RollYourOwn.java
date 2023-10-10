package edu.uchicago.gerber.labjava.lec08.lambda.intro;





public class RollYourOwn {


// Here we are rolling our own lamba expressions

//    A lambda expression is an unnamed function with parameters and a body.
//
//    The lambda expression body can be a block statement or an expression.

   //         -> separates the parameters and the body.


    public static void main(String[] args) {


        MyFirstLambda my1 = (int u) -> u + 1;  //takes an int parameter and returns the parameter value incremented by 1.
        MyFirstLambda my2 = (x) -> x + 1;  //takes an int and returns an int.
        MyFirstLambda my3 = x -> ++x;  //takes an int and returns an int.

        System.out.println("My First Lambda : " + my3.calcMe(12));



        MySecondLambda ms1 = (String s) -> s.length();
        MySecondLambda ms2 = (s) -> s.length();
        MySecondLambda ms3 = s -> s.length();


        System.out.println("My Second Lambda : " + ms3.getLen("Hello there"));




        MyThirdLambda mt1 = (int x, int y) -> {
                    int max = x  > y  ?  x  : y;
                    return max;
        };

        MyThirdLambda mt2 = (x, y) -> {
            int max = x  > y  ?  x  : y;
            return max;
        };

        MyThirdLambda mt3 = (x, y) -> x > y ? x : y;


        System.out.println("My Third Lambda : " + mt3.getMax(67, 123));

        My4 my4 = () -> System.out.println("Howdy");
        my4.nothing();


    }



}

@FunctionalInterface
interface MyFirstLambda {
     int calcMe(int n);
}


@FunctionalInterface
interface MySecondLambda {
    int getLen(String string);
}

@FunctionalInterface
interface MyThirdLambda {
    int getMax(int x, int y);
}

@FunctionalInterface
interface My4 {
    void nothing();
}
