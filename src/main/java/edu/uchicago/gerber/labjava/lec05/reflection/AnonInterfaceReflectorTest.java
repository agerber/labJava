package edu.uchicago.gerber.labjava.lec05.reflection;

/**
 * Created by ag on 10/27/2014.
 */
public class AnonInterfaceReflectorTest {


    //create an anonymous inner class such as runnable

    public static void main(String[] args) {


        //there are two kinds of anonymity, referende anonymous. This happens all the time when we use the new keyword
           //without a reference when passing objects into constructors for example, or into data-structures.


        //what is the difference between an reference-anonymous and type-anonymous


        //try selecting the anon inteface and selecting Refactor || Extract || Variable
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Reflector.printClass(this.getClass());
            }
        });
        thread.start();

    }
}
