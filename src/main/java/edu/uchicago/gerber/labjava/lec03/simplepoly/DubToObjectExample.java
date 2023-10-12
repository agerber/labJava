package edu.uchicago.gerber.labjava.lec03.simplepoly;

import edu.uchicago.gerber.labjava.lec03.GodView;

import java.util.ArrayList;

public class DubToObjectExample {
    public static void main(String[] args) {

        //I'm creating a new object here
        Double dub =34.56;

        //up-cast (automatic casting)
        Number num = (Number) dub;


        //up-cast (automatic casting)
        Object obj = (Object) num;


        //down-casting (widening)
        Double anotherDub = (Double) obj;


        //up-cast (automatic casting)
        Number anotherNum = (Number) anotherDub;

        //how many objects are instantiated in this example?





    }
//
//    public static void printSuperclassesRecursive(Class<?> clazz) {
//        if (clazz == null || clazz.getSuperclass() == null) {
//            return;
//        }
//        printSuperclassesRecursive(clazz.getSuperclass());  // recursive call
//        System.out.println(clazz.getSuperclass().getName());
//    }
//
//    // Test
//
//    public static String printGodView(Class<?> classRef, int sizeRef ){
//
//        int side = 0, length=0;
//        switch (sizeRef){
//            case 6:
//                side = 0;
//                length = 30;
//                break;
//            case 4:
//                side = 5;
//                length = 20;
//                break;
//            case 2:
//                side = 10;
//                length = 10;
//                break;
//
//        }
//
//
//
//
//        StringBuilder sb = new StringBuilder();
//        //build side
//        for(int i = 0; i < side; i++){
//            sb.append("   ");
//        }
//        //build length
//        for(int i = 0; i < length; i++){
//            sb.append("===");
//        }
//        sb.append("\n");
//
//        for(int i = 0; i < side; i++){
//            sb.append("   ");
//        }
//        //add middle here
//        sb.append(classRef.getName() + "\n");
//
//        //build side
//        for(int i = 0; i < side; i++){
//            sb.append("   ");
//        }
//        //build length
//        for(int i = 0; i < length; i++){
//            sb.append("===");
//        }
//
//
//
//
//
//        return sb.toString();
//
//
//    }



}
