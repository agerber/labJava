package lec05.glab.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;
import java.util.Stack;


//originally found here: http://www.hackchina.com/en/r/18861/Reflector.java__html  and grossly modified
//using Reflector and Horstmann as search params

public class Reflector {
    public static void main(String[] args) {
        // read class name from command line args or user input

//        printClass(java.util.Date.class);
//        return;



    }





    public static void printConstructors(Class cl) {
        Constructor[] constructors = cl.getDeclaredConstructors();

        for (Constructor c : constructors) {
            String name = c.getName();
            System.out.print("   " + Modifier.toString(c.getModifiers()));
            System.out.print(" " + name + "(");

            // print parameter types
            Class[] paramTypes = c.getParameterTypes();
            for (int j = 0; j < paramTypes.length; j++) {
                if (j > 0) System.out.print(", ");
                System.out.print(paramTypes[j].getName());
            }
            System.out.println("); //no-arg constructor");
        }
    }


    public static void printInterfaces(Class cl) {
        System.out.print("   ");
        Class[] interfaces = cl.getInterfaces();
        for (int nC = 0; nC < interfaces.length; nC++) {
                if (nC > 0) System.out.print(", ");
                System.out.print(interfaces[nC].getName());
            }
        System.out.println();
        System.out.println();
    }





    public static void printMethods(Class cl) {
        Method[] methods = cl.getDeclaredMethods();

        for (Method m : methods) {
            Class retType = m.getReturnType();
            String name = m.getName();

            // print modifiers, return type and method name
            System.out.print("   " + Modifier.toString(m.getModifiers()));
            System.out.print(" " + retType.getName() + " " + name + "(");

            // print parameter types
            Class[] paramTypes = m.getParameterTypes();
            for (int j = 0; j < paramTypes.length; j++) {
                if (j > 0) System.out.print(", ");
                System.out.print(paramTypes[j].getName());
            }
            System.out.println(");");
        }
    }

    public static void printFields(Class cl) {
        Field[] fields = cl.getDeclaredFields();


        for (Field f : fields) {

            String strMods = Modifier.toString(f.getModifiers());
            Class type = f.getType();
            String name = f.getName();

            System.out.print("   " + Modifier.toString(f.getModifiers()));
            System.out.println(" " + type.getName() + " " + name + ";");


        }
    }
}