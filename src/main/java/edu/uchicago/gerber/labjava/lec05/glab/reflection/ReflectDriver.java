package edu.uchicago.gerber.labjava.lec05.glab.reflection;

/**
 * Created with IntelliJ IDEA.
 * User: ag
 * Date: 11/18/13
 * Time: 11:20 AM
 * To change this template use File | Settings | File Templates.
 */
public class ReflectDriver {

    public static void main(String[] args) {

        Double dub = new Double(56.7);
        Reflector.printClass(dub.getClass());


    }

}
