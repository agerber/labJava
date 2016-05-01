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

        //A: A REFERENCE IS A Aperture

        //When you observe your object, you're doing so through the aperature of the reference type.
        //Keep in mind that both the object has a type AND the reference has a type.
        //when you apply the aperture you are restricting (sometimes severely) the range of methods you may
        //call on that reference. That penalty of restriction is compensated by the power of polymorphism

        //B: WHEN YOU CAST AN OBJECT, YOU ARE NOT CHANGING THE OBJECT, JUST THE FILTER
        //Let's take some examples
        Double dubMe = new Double(41.25);
        //above, the reference is of type Double, and the object is of type Double.
        //we can check this with reflection
        System.out.println("Double reference pointing to a Double object");
        System.out.println(dubMe.getClass().toString());
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");


        //once instantiated, this object's type will NEVER change
        //however, the aperture (the reference) through which you can look at this object can change so
        //long as it adheres to the rules of polymorphism which state that you may store an object in
        //(1) a superlcass reference, or (2) an implementing interface reference

        //Let's apply the first rule of polymorphism and cast this Double object to a Number
        //When we apply the cast, we are NOT changing the object at all, rather, all we are doing is changing the aperture (the reference type)
        //With reflection, we can see that we are NOT changing the object's type, it's still a Double, only now it's
        //being stored in a superlcass reference which restricts the of methods we can call on the reference
        //This is an automatic promotion, so the cast here is redundant
        Number numMe = (Number) dubMe;
        System.out.println("A Number reference pointing to same Double object:");
        System.out.println(numMe.getClass().toString());
        //one of the methods we can call from the Number reference
        System.out.println(numMe.intValue());
        System.out.println("numMe and dubMe both point to the same object in memory space: " + (numMe == dubMe));
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //Let's cast again to a Comparable reference
        //again, we are NOT changing the underlying object type
        //All we are doing is changing the filter (reference type) through which we can see this object
        Comparable<Double> comMe = (Comparable<Double>) numMe;
        System.out.println("The same Double object stored in Comparable<Double> reference:");
        System.out.println(comMe.getClass().toString());
        //Let's call the compareTo method()
        System.out.println("Our Double value (implicit parameter) is less than that of the explicit parameter: "
                + (comMe.compareTo(new Double(88.84)) < 0));
        System.out.println("comMe and dubMe both point to the same object in memory space: " + (comMe == dubMe));
        System.out.println("comMe and numMe both point to the same object in memory space: " + (comMe == numMe));
        System.out.println("numMe and dubMe both point to the same object in memory space: " + (numMe == dubMe));
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");


        //Now let's cast this to an Object
        //This is an automatic promotion, so the cast here is redundant
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


        //lets try to cast the Double object stored in numMe to an Integer
        //since the object stored in numMe is a Double, trying to cast it to an Integer will choke at runtime
        //because Integer is not in the class hierarchy of Double
        //however, the compiler will not complain at compile-time because numMe could very well point to an Integer object
        //toggle uncomment/comment this code below to throw a ClassCastException
        //Integer intMe = (Integer)numMe;

        //Let's try to cast our underlying object(of type Double) to an interface that it does not implement
        //Again, the compiler will not complain at compile-time because an Object reference could very well
        // point to an object which implements the Runnable interface
        //toggle uncomment/comment this code below to throw a ClassCastException
       // Runnable runMe = (Runnable) objMe;

        //let's try to cast our underlying object(of type Double) to an reference type that is not on its (Double's) class hierarchy
        //This time, the compiler will complain at compile-time since there is no way a Number reference could store a Rectangle object
        //toggle uncomment/comment to show compile-time error
      //  Rectangle recMe = (Rectangle) numMe;


        //However, if we try to cast comMe to a Rectangle (Rectangle implements Comparable) the compiler will NOT complain, but of course, we will still throw ClassCastException
        //because the underlying object stored in comMe is still of type Double, and Rectangle is not in Double's class hierarchy.
        //toggle uncomment/comment this code below to throw a ClassCastException
        //Rectangle recMeAgain = (Rectangle) comMe;

        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        //Let's go full circle. Casting-down is trivial.
        //The underlying object that objMe points to is of type Double.  If it weren't of type Double, we would get a ClassCastException
        //We are effectively widening the filter to see all the methods of the original Double object
        Double dubMeDown = (Double) objMe;
        System.out.println("Double reference pointing to a Double object");
        System.out.println(dubMeDown.getClass().toString());
        System.out.println("dubMeDown and dubMe both point to the same object in memory space: " + (dubMeDown == dubMe));


        //Now let's try to do something similar to what we did above. The difference here is that the underlying object that we instantiate is of type Object
        //The compiler won't complain at compile-time because objYou could very well point to a Double (as it does above)
        //but after we compile, it will choke at runtime, even though Double and Object are on the same class hierarchy.
        //Going back to the filter metaphor, you're trying to apply a filter that is way too wide, so the light will just stream through.
        //How do we know Double is "wider" than Object? Because class hierarchies are like pyramids-- they get wider (more complex) as you go down
        //Ask yourself this? What should the Double value be after the cast anyway?  It can't have a value.
        //This will cause a ClassCastException at runtime
        Object objYou = new Object();
        //toggle uncomment/comment this code below to throw a ClassCastException
      // Double dubYouDown = (Double) objYou;



        //It seems like a game of hide-and-seek! If the reference type is is just a filter, then the filter is obscuring the underlying object type, right?
        //Yes, that's correct. However, this hiding/abstracting is what allows for polymorphism which is the most powerful feature of OO languages.

        //There is a way to check the underlying object type using the instanceof keyword. instanceof is not a method,
        //rather it is a binary operator (takes two operands, one of right side of the expression, and one on the left)  in Java.
        //Here, the cast will only take place if the underlying object is of type Double, which it isn't
        if (objYou instanceof Double){
            Double dubYouDown = (Double)objYou;
        }














    }
}
