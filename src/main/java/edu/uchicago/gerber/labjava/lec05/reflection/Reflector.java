package edu.uchicago.gerber.labjava.lec05.reflection;

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

        String strClass = "";
        Scanner scan = new Scanner(System.in);
        Class cls = null;
        while (true) {
            try {
                System.out.println("Enter \"exit\" to quit, or a fully qualified class name (e.g. java.util.Date): ");
                strClass = scan.next();
                if (strClass.equalsIgnoreCase("exit")){
                    System.exit(0);
                }
                printClass(strClass);


            } catch (ClassNotFoundException e) {
               // e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                System.out.println("That's now a valid class name, try again.");
                continue;
            }
        }

    }

    public static void printClass(Class cls)  {
        //create a stack and push the original class onto it
        Stack<Class> clsStacks = new Stack<>();
        clsStacks.push(cls);

        //keep pushing its superclass until superclass is null (I've reached grand-daddy Object)
        while (clsStacks.peek().getSuperclass() != null) {
            clsStacks.push(clsStacks.peek().getSuperclass());
        }



        while (!clsStacks.empty()) {
            cls = clsStacks.pop();
            System.out.println("###############CLASS###############\n" +cls.toString() + "\n###############CLASS###############\n");
            System.out.println("//INTERFACES");
            printInterfaces(cls);
            System.out.println("//FIELDS");
            printFields(cls);
            System.out.println();
            System.out.println("//CONSTRUCTORS");
            printConstructors(cls);
            System.out.println();
            System.out.println("//METHODS");
            printMethods(cls);
            System.out.println();

        }
    }

    //overlaoded to take string
    public static void printClass(String strClass) throws ClassNotFoundException {
        Class cls;//the following line could throw an exception
        cls = Class.forName(strClass);
        printClass(cls);

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
