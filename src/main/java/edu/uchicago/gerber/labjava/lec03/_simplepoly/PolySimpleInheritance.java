package edu.uchicago.gerber.labjava.lec03._simplepoly;

import java.util.ArrayList;
import java.awt.Rectangle;

public class PolySimpleInheritance {


    //Cntrl-H for class hierarchy on PC
	public static void main(String[] args) {

        //first rule of polymorphism:
            //you can store a subclass object in a superclass reference

		ArrayList<Object> objObjects = new ArrayList<>();
		
		objObjects.add(89.3);
		objObjects.add("Hello");
		objObjects.add(true);
		objObjects.add('H');
		objObjects.add(new Rectangle(5,8,9,12));
		objObjects.add(new MyClass());

		for (Object objObject : objObjects) {
			System.out.println(objObject.toString());
		}

		System.out.println("-----------------------------------");

		//an example using instanceof to determine the the type of the object reference
		ArrayList<Number> numTemps = new ArrayList<Number>();

		numTemps.add(121.6f);
		numTemps.add((byte)95);
		numTemps.add(217);
		numTemps.add(15.9);
		numTemps.add(-80);
		numTemps.add(1.08);
		numTemps.add(0.22574);
		numTemps.add((short) 12);
		numTemps.add(6546546546541651L);

		for (Number numTemp : numTemps) {
			Class clazz = numTemp.getClass();
			String clazzName = clazz.getSimpleName();
			System.out.println(clazzName + " : " + numTemp.toString());

		}


	}


}
