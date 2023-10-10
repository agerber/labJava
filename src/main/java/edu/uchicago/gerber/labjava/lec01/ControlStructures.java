package edu.uchicago.gerber.labjava.lec01;
import java.util.StringTokenizer;

public class ControlStructures {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//nestedLoops();
		
		
		String[] strPeeps = new String[] {"Gary", "Sally", "Aaron", "John", "Sue"};
		
		StringTokenizer stoPeeps = new StringTokenizer("Dan Xavier Jason Mary Brad");
		
		
		System.out.println(loopsFor(strPeeps));
		
		System.out.println(loopsWhile(stoPeeps));
		switchGradeComments('A');
		System.out.println(controlIfExample("Adam"));
		nestedLoops();

	}
	
	
	private static void switchGradeComments(char cGrade){
		
		switch (cGrade) {
		
	    case 'A' : System.out.print("Excellent"); 
	    break;  
	    
	    case 'B' : System.out.print("Good"); 
	    break;  
	    
	    case 'C' : System.out.print("Fair"); 
	    break;  
	    
	    case 'D' : System.out.print("Poor"); 
	    break;  
	    
	    case 'F' : System.out.print("Fail"); 
	    break;  
	    
	    default  : System.out.print("Incomplete");  
	        

		
		}//end switch
		
	}
	
	private static String controlIfExample(String strFirstName){
		
		if(strFirstName.equals("Adam"))
			return  "Hello" + strFirstName + "Great first name!";
		else
			return "Hello" + strFirstName;
			
	
	}
	
	private static String controlIfElseExample(int nEyeSight){
		
		if(nEyeSight > 2090)
			return  "Please sit in front rows.";
		else if (nEyeSight > 2050)
			return  "Please sit in middle rows.";
		else if (nEyeSight > 2030)
			return  "Please sit toward the back.";
		else
			return  "Please sit in the back row.";
	
	}
	
	private static String controlTernary(boolean bFanOfThaiFood){
		
		return (bFanOfThaiFood ? "Love the spread": "yuck");
	}
	
	
	private static String loopsFor(String[] strStudents){
		
		//find the person who is first on the roster
		//assume he/she is the first one. 
		String strFirst = strStudents[0];
		for (int nC = 1; nC < strStudents.length; nC++){
			if (strStudents[nC].compareTo(strFirst) <= 0)
				strFirst = strStudents[nC];
			
				
		}
		return strFirst;
	}
	
	
	private static String loopsWhile(StringTokenizer stoStudents){
		
		//last on roster
		String strLast = stoStudents.nextToken();
		String strNext;
	    while(stoStudents.hasMoreTokens()){
            strNext = stoStudents.nextToken();
			if (strNext.compareTo(strLast) >= 0)
				
				
				strLast = strNext;

		}
	    return strLast;
	
	}
	
	
	private static void loopsBreakContinue(){
		
		int nCount = 0;
		//infinite loop
		  while(true) {
		      nCount++;

		      if(nCount == 510)
		    	  break; // Out of loop
		      if(nCount % 10 != 0) 
		    	  continue; // Top of loop
		      System.out.println(nCount);
		   }
	
		  
	}
	
	private static void nestedLoops(){
		
		//odometer
		for(int nA = 0; nA < 10;  nA++)
			for(int nB = 0; nB < 10;  nB++)
				for(int nC = 0; nC < 10;  nC++)
		            System.out.println(nA + "|" + nB + "|" + nC);

	
	
	}

}
