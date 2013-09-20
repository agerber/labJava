package lec02;

public class StringManipulation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		//this is a String literal  "Hello World";
		//a String literal has no object reference, so unless it's assined to
		   //a reference or a passed into a method, and then assined, it's unfindable
		
		//strResult refers to "Hello World." now. 
		String strResult1 = "Hello " + "World.";
		System.out.println(strResult1);
		
		String strOne = "CSPP";
		String strTwo = strOne; //sometimes this will copy references, and sometimes values
		                        //so you must assume values

		
		String strState = "Mississippi";
		System.out.println(strState);
		strState = strState.replaceFirst("issipp", "our");
		System.out.println(strState);
		System.out.println(strState.length());
		
		System.out.println("Pardon me " + strState.substring(0,4));
		
		String strNeedsTrim = "    some string     ";
		System.out.println(strNeedsTrim);
		strNeedsTrim = strNeedsTrim.trim();
		System.out.println(strNeedsTrim);
		
		System.out.println(strOne.compareTo(strTwo));
		
		System.out.println("Hello".compareTo("Hello"));
		
		int nPos = strNeedsTrim.indexOf(' ');
		System.out.println(nPos);
		
		System.out.println(strState.endsWith("i"));
		
		
		
	}
	
	
	
	

}
