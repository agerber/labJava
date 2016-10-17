package lec03.glab.simplepoly;

import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.awt.Rectangle;

public class PolySimple {

	/**
	 * @param args
	 */

    //Cntrl-H for class hierarchy on PC
	public static void main(String[] args) {
		
		
		//very simple polymorphism
        //first rule of polymorphism:
            //you can store a subclass object in a superclass reference
        //second rule of polymorphism
            //you can store an implementing object in an interface reference

	
		Object[] objObjects = new Object[6];
		
		objObjects[0] = new Double(89.3);
		objObjects[1] = new String("Hello");
		objObjects[2] = new Boolean(true);
		objObjects[3] = new Character('H');
		objObjects[4] = new Rectangle(5,8,9,12);
		objObjects[5] = new MyClass();
		
		for (Object obj : objObjects){
			System.out.println(obj.getClass() + " : " + obj.toString());


        }

		//O b rectangle = new Rectangle(4,5,7,8);

				
		System.out.println("-----------------------------------");
		
				//illeagal
			//	Double dubMe = new Object();
			//	Integer intMe = new Rectangle();
	
			//	Comparable comVal1 = new Double(85.0);
			//	Comparable comVal2 = new Integer(85);


		//an example using instanceof to determine the the type of the object reference
		ArrayList<Number> numTemps = new ArrayList<Number>();

		numTemps.add(new Double(121.6));
		numTemps.add(new Integer(95));
		numTemps.add(new Integer(219));
		numTemps.add(new Double(15.8));
		numTemps.add(new Integer(-60));
		numTemps.add(new Double(-1.8));
		numTemps.add(new Double(3.1));

       for (Number num : numTemps) {
		
    	   if (num instanceof Double){
    		   System.out.println("At " + num + " degrees Celcius, water is a " +getStateCel(num.doubleValue()) );
    		
    	   }
    	   else if (num instanceof Integer){
    		   System.out.println("At " + num + " degrees Fahrenheit, water is a " +getStateFar(num.intValue()) );
    	   }
    	   else {
    		   System.out.println("Can not determine the state of water for this number.");
    	   }
	   }
		

	}
	
	private static String getStateCel(double dTemp){
		
		if(dTemp <=0.0){
			return "SOLID";
		}
		else if (dTemp <100.0){
			return "LIQUID";
		}
		else {
			return "GAS";
		}
		
	}
	
	private static String getStateFar(int nTemp){
		
		if(nTemp <=32){
			return "SOLID";
		}
		else if (nTemp <212){
			return "LIQUID";
		}
		else {
			return "GAS";
		}
		
	}
	

}
