package edu.uchicago.gerber.labjava.lec09.generics.bounded;

import java.util.ArrayList;
import java.util.List;

//PECS stands for Producer Extends Consumer Super
// AKA GET and PUT principle.



class Fruit {
    @Override
    public String toString() {
        return "I am a Fruit !!";
    }
}

 class Apple extends Fruit {
    @Override
    public String toString() {
        return "I am an Apple !!";
    }
}

 class AsianApple extends Apple {
    @Override
    public String toString() {
        return "I am an AsianApple !!";
    }
}

public class ConsumerDriver
{
    public static void main(String[] args)
    {
        //List of apples
        List<Object> objects = new ArrayList<Object>();
        objects.add(new Object());
        objects.add(new Fruit());

        //We can assign a list of apples to a basket of apples
        List<? super Apple> basket = objects;

        //however as this is a consumer (we are putting objects into it) we must use Apple or one of its subclasses
        basket.add(new Apple());      //Successful
        basket.add(new AsianApple()); //Successful
        //basket.add(new Fruit());      //Compile time error
       // Object object =   basket.get(1);

        for (Object o : basket) {
            System.out.println(o);
        }

//        basket
//                .stream()
//                .forEach(System.out::println);
    }
}
