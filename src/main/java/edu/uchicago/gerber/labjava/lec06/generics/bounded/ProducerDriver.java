package edu.uchicago.gerber.labjava.lec06.generics.bounded;


import java.util.ArrayList;
import java.util.List;

public class ProducerDriver
{
    public static void main(String[] args)
    {
        //List of apples
        List<Apple> apples = new ArrayList<>();
        apples.add(new Apple());
        apples.add(new AsianApple());

        //We can assign a list of apples to a basket of fruits;
        //because apple is subtype of fruit and this make sense.

        //this says that this list will hold one particiular subtype that extends Fruit.
        List<? extends Fruit> basket = apples;


        for (Fruit fruit : basket) {
            System.out.println(fruit);
        }


//        basket
//                .stream()
//                .forEach(System.out::println);


        //Here we know that in basket there is nothing but fruit only
        for (Fruit fruit : basket)
        {
            System.out.println(fruit);
        }

        //(You actually cannot add anything to a Collection<? extends Thing>, because you cannot know at runtime
        // which specific subtype of Thing the collection holds.)

      //  basket.add(new Apple()); //Compile time error
      //  basket.add(new Fruit()); //Compile time error
    }
}
