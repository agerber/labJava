package lec05.casting;

import java.awt.*;

public class CastingObjects {


	public static void main(String[] args) {
	
		//will use this for reflection
		Class clsSome;
		
		System.out.println("Cast-down examples");
		// ===============================================
		// ==Assign a subclass object to a superclass reference
		// ===============================================
		//when considering the use of a cast, you must cast down the class hierarchy
		Object objSome = new Integer(17);
		System.out.print("an Integer object stored in an Object reference: ");
		System.out.print(objSome);
		
		//simple reflection
	    clsSome = objSome.getClass();
		System.out.println(" and the class is " + clsSome.getName());
		
		// ===============================================
		// ==cast down to Number
		// ===============================================
		//notice that when uncommented, this compiler complains
		//Number numSome = objSome;
		
		Number numSome = (Number)objSome;
		System.out.print("cast down; now an Integer object stored in an Number reference: ");
		System.out.print(numSome);
		System.out.print(" : numSome == objSome " + (numSome == objSome) );

		//simple reflection
	    clsSome = numSome.getClass();
		System.out.println(" and the class is " + clsSome.getName());
		
		
		// ===============================================
		// ==cast down to Integer
		// ===============================================
		
		Integer intSome = (Integer) numSome;
		System.out.print("cast down; now an Integer object stored in an Integer reference: ");
		System.out.print(intSome);
		System.out.print(" : numSome == intSome " + (numSome == intSome) );
		
		//simple reflection
	    clsSome = intSome.getClass();
		System.out.println(" and the class is " + clsSome.getName());
		
		
		
	
		
		//"casting up" the class hierarchy is not required, just assign
		System.out.println("'Cast-up' examples: casting up is not required, just assign");
		
		Number numAnother = intSome;
		Object objAnother = intSome;
		
		System.out.print("An Integer object stored in an Integer reference: ");
		System.out.println(intSome);
		System.out.print("An Integer object stored in a Number reference: ");
		System.out.println(numAnother);
		System.out.print("An Integer object stored in an Object reference: ");
		System.out.println(objAnother);
		
		
		
		//why would you want to cast?
		//implicit parameters passed as arguments to methods aren't automatically converted 
		//so you must cast them
		//example:
		Object objDimension = new Dimension(5,8);
		
		//notice that this complains when uncommented
	    //Rectangle recOne = new Rectangle(objDimension);
		
		
		//it's possible (because of polymorphism) that the object
		//stored in objDimension is not a dimension and so Java
		//imposes this casting discipline on the programmer to ensure the correct type is used
		
		//try to uncomment this and cast
		//objDimension = new Double(45.23);
		
		//however a cast-down solves the problem
		Rectangle recOne = new Rectangle((Dimension)objDimension);
		System.out.println(recOne);
		

	}

}
