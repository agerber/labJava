package lec03.glab;

import java.awt.*;

public class MoreStringManipulation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {


//        String strName = "John";
//        (strName stores an object reference [memory address] to "John" in memory. It points to "John".)
//
//        strName = strName + "Doe";
//        (A new object is created "JohnDoe" in an entirely different part of memory, then the memory address of the newly created object "JohnDoe" is returned and assigned to strName. strName now contains a new memory address, which is the address to the newly created "JohnDoe". Since the original "John" no longer has any references pointing to it, the garbage collector will eventually reclaim that memory for you automatically.)
//
//        Let's take another example:
//
//        String strShakespeare =  "Deny thy father and refuse thy name.";
//        strShakespeare = strShakespeare.replace("thy", "your");
//
//        In this case, again, a new string is created "Deny your father and refuse your name." in an entirely different memory location. Then the memory address of this newly created string is returned and assigned to strShakespeare.
//                The original string containing the olde English will be reclaimed by the garbage collector.
//
//
//                To understand why this is different, take an example of a mutable object (and almost all objects are mutable)
//        Rectangle recMe = new Rectangle(2,2,2,2);
//        recMe.setWidth(50);
//
//        In the above example, recMe (an object reference) still points to the same memory address AND the field  which stores width is mutated to 50.  [2,2,50,2]

        String strName = "John";
        strName = strName + "Doe";
        System.out.println(strName);

        String strShakespeare =  "Deny thy father and refuse thy name.";
        strShakespeare = strShakespeare.replace("thy", "your");
        System.out.println(strShakespeare);

        Rectangle recMe = new Rectangle(2,2,2,2);
        recMe.setBounds((int)recMe.getX(),(int) recMe.getY(), 50, (int)recMe.getHeight());
        System.out.println(recMe);



    }
	
	
	
	

}
