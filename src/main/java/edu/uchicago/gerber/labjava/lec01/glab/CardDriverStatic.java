package edu.uchicago.gerber.labjava.lec01.glab;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class CardDriverStatic {
    public static void main(String[] args) throws IllegalAccessException {


        System.out.println("METHODS ==========================");
        Method[] methods = Card.class.getDeclaredMethods();
        for (Method method : methods) {


            System.out.print(method);
            if (Modifier.isStatic(method.getModifiers())) {
                System.out.print(":::::::::STATIC ");
            }
            System.out.println();
        }

        System.out.println("FIELDS ==========================");
        Field[] fields = Card.class.getDeclaredFields();
        for (Field field : fields) {

            System.out.print(field);
            if (Modifier.isStatic(field.getModifiers())){
                System.out.print(":::::::::STATIC with value of ");
                field.setAccessible(true);
                //in the case of static, pass in null rather than a reference to the instance
                System.out.print(field.get(null).toString());
            }
            System.out.println();
        }

        System.out.println("CONSTRUCTORS ==========================");
        Constructor<?>[] constructors = Card.class.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }

    }
}
