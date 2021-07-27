package edu.uchicago.gerber.labjava.lec04.glab.construct_me;

/**
 * Created by ag on 10/20/2014.
 */
public class PersonFactory {

    //can not instantiate this now
    private PersonFactory() {
    }

    //factory methods
    public static Person getInstance() {
        return new Person("Adam", 100.0);
    }

    public static Person getInstance(String name){
        return new Person(name, 100.0);
    }

    public static Person getInstance(String name, double dLb){
        return new Person(name, dLb);
    }


}
