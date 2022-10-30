package edu.uchicago.gerber.labjava.lec05.glab.inner;

import edu.uchicago.gerber.labjava.lec05.glab.reflection.Reflector;




public class PrintNumbersDriver {



    public static void main(String[] args) {

        //we can also inline an abstract class in Java, if you have a need for this. less common.

        //Will use autoboxing to box-up these primitives to objects.
        Number[] numbers = {
                (byte)1,
                (short)2,
                3,
                4.5555f,
                1001.6666,
                20000000000000001L,

//                new Number() {
//                    @Override
//                    public int intValue() {
//                        return 0;
//                    }
//
//                    @Override
//                    public long longValue() {
//                        return 0;
//                    }
//
//                    @Override
//                    public float floatValue() {
//                        return 0;
//                    }
//
//                    @Override
//                    public double doubleValue() {
//                        return 0;
//                    }
//                },
//                new Number() {
//                    @Override
//                    public int intValue() {
//                        return 0;
//                    }
//
//                    @Override
//                    public long longValue() {
//                        return 0;
//                    }
//
//                    @Override
//                    public float floatValue() {
//                        return 0;
//                    }
//
//                    @Override
//                    public double doubleValue() {
//                        return 0;
//                    }
//                }

        };

        for (Number number : numbers) {
            System.out.println(number.getClass().getName() + " : " + number );
            //Reflector.printClass(number.getClass());
        }

    }
}
