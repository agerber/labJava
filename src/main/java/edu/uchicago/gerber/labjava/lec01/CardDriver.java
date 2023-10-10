package edu.uchicago.gerber.labjava.lec01;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class CardDriver {
    public static void main(String[] args) throws IllegalAccessException {


        //the instance values are stored on the heap.
        //the method definitions (including constructors) are stored on the .class object.
        Card cardKS = new Card('K', 'S', (byte)10);
        System.out.println(cardKS.getFace());
        System.out.println(cardKS.getSuit());
        System.out.println(cardKS.getValue());



        System.out.println("METHODS ==========================");
        Method[] methods = Card.class.getDeclaredMethods();
        for (Method method : methods) {
            if (Modifier.isStatic(method.getModifiers()))
                System.out.print(":::::::::STATIC ");

            System.out.println(method);
        }
        System.out.println("FIELOS ==========================");
        Field[] fields = Card.class.getDeclaredFields();
        for (Field field : fields) {

            if (Modifier.isStatic(field.getModifiers())){
                System.out.print(":::::::::STATIC ");
                field.setAccessible(true);
                System.out.print(field.get(null).toString() + ":::: ");

            }


            System.out.println(field);
        }
        System.out.println("CONSTRUCTORS ==========================");
        Constructor<?>[] constructors = Card.class.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }


        System.out.println();
        //cardKS.getClass().getDeclaredMethods()


       // Card cardQS = new Card('Q', 'S', (byte)10);
        //Card cardAS = new Card('A', 'S', (byte)1);
      //  System.out.println(cardKS.toString());
       // Player player1 = new Player("Adam", 50_000.09);
       // System.out.println(player1.getName());



    }
}
