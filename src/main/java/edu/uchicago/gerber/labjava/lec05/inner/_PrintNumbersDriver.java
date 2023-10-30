package edu.uchicago.gerber.labjava.lec05.inner;


public class _PrintNumbersDriver {



    public static void main(String[] args) {

        //we can also inline an abstract class in Java, if you have a need for this. less common.

        //Will use autoboxing to box-up these primitives to objects.
        Number[] numbers = {
                (byte)1,
                (short)2,
                3,
                4.5555f,
                1001.6666,
                20000000000000001L

        };

        for (Number number : numbers) {
            System.out.println(number.getClass().getName() + " : " + number );
            //Reflector.printClass(number.getClass());
        }

    }
}
