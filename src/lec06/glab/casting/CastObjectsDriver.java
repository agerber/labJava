package lec06.glab.casting;

import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: ag
 * Date: 11/7/13
 * Time: 9:20 AM
 * To change this template use File | Settings | File Templates.
 */
public class CastObjectsDriver {
    public static void main(String[] args) {

        //A: A REFERENCE IS A FILTER
        //A reference type is like a filter. See filter.jpg in same package.
        //When you observe your object, you're doing so through the filter of the reference type.
        //Keep in mind that both the object has a type AND the reference has a type.
        //when you apply the filter you are restricting (sometimes severely) the range of methods you may
        //call on that reference. That penalty of restriction is compensated by the power of polymorphism

        //B: WHEN YOU CAST AN OBJECT, YOU ARE NOT CHANGING THE OBJECT, JUST THE FILTER
        //Let's take some examples
        Double dubMe = new Double(41.25);
        //above, the reference is of type Double, and the object is of type Double.
        //we can check this with reflection
        System.out.println("Double reference pointing to a Double object");
        System.out.println(dubMe.getClass().toString());
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");


        //once instantiated, this object's type will not change
        //however, the filter (the reference) through which you can look at this object can change so
        //long as it adheres to the rules of polymorphism which state that you may store an object in
        //(1) a superlcass reference, or (2) an implementing interface reference

        //let apply the first rule of polymorphism and cast this Double object to a Number
        //When we apply the cast, we are NOT changing the object at all, rather, all we are doing is changing the filter (the reference type)
        //With reflection, we can see that we are NOT changing the object's type, it's still a double, only now it's
        //being stored in a superlcass reference which restricts the of methods we can call on the reference
        Number numMe = (Number) dubMe;
        System.out.println("A Number reference pointing to same Double object:");
        System.out.println(numMe.getClass().toString());
        //one of the methods we can call from the Number reference
        System.out.println(numMe.intValue());
        System.out.println("numMe and dubMe both point to the same object in memory space: " + (numMe == dubMe));
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //Let's cast again to a Comparagble reference
        //again, we are NOT changing the underlying object type
        //All we are doing is changing the filter (reference type) through which we can see this object
        Comparable<Double> comMe = (Comparable<Double>) numMe;
        System.out.println("The same Double object stored in Comparable<Double> reference:");
        System.out.println(comMe.getClass().toString());
        //Let's call the compareTo method()
        System.out.println("Our Double value (implicit parameter) is less that that of the explicit parameter " + (comMe.compareTo(new Double(88.84)) < 0));
        System.out.println("comMe and dubMe both point to the same object in memory space: " + (comMe == dubMe));
        System.out.println("comMe and numMe both point to the same object in memory space: " + (comMe == numMe));
        System.out.println("numMe and dubMe both point to the same object in memory space: " + (numMe == dubMe));
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");


        //Now let's cast this to an Object
        Object objMe = (Object) comMe;
        System.out.println("The same Double object stored in an Object reference:");
        System.out.println(objMe.getClass().toString());
        //one of the methods we can call from the Object reference
        System.out.println(objMe.toString());
        System.out.println("comMe and dubMe both point to the same object in memory space: " + (objMe == dubMe));
        System.out.println("comMe and dubMe both point to the same object in memory space: " + (comMe == dubMe));
        System.out.println("comMe and numMe both point to the same object in memory space: " + (comMe == numMe));
        System.out.println("numMe and dubMe both point to the same object in memory space: " + (numMe == dubMe));
        //"numMe == dubMe == comMe == objMe : TRUE - they all point to the same object in memory space


        //lets try to cast the Double ojbect stored in numMe to an Integer
        //since the object stored in numMe is a Double, trying to cast it to an Integer will choke the compiler
        //because Integer is not in the class hierarchy of Double
        //however, the compiler will not complain a compile-time because numMe could very well point to an Integer object
        //toggle uncomment/comment this code below to throw a ClassCastException
        //Integer intMe = (Integer)numMe;

        //let's try to cast our underlying object(of type Double) to an interface that it does not implement
        //again, the compiler will not complain at compile-time
        //toggle uncomment/comment this code below to throw a ClassCastException
        //Runnable runMe = (Runnable) objMe;

        //let's try to cast our underlying object(of type Double) to an reference type that is not on its (Double's) class hierarchy
        //This time, the compiler will complain at compile-time since there is no way a Number reference could store a Rectangle object
        //toggle uncomment/comment to show compile-time error
        //Rectangle recMe = (Rectangle) numMe;

        //however, if we try to cast comMe to a Rectangle (Rectangle implements Comparable) the compiler will NOT complain, but of course, we will still throw ClassCastException
        //because the underlying object stored in comMe is of type Double, and Rectangle is not in Double's class hiearchy.
        //toggle uncomment/comment this code below to throw a ClassCastException
       // Rectangle recMeAgain = (Rectangle) comMe;

        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        //Let's go full circle. Casting-down is trivial.
        //The underlying object that objMe points to is of type Double.
        //We are effectively widening the filter to see all the methods of the original object
        Double dubMeDown = (Double) objMe;
        System.out.println("Double reference pointing to a Double object");
        System.out.println(dubMeDown.getClass().toString());
        System.out.println("dubMeDown and dubMe both point to the same object in memory space: " + (dubMeDown == dubMe));















    }
}
