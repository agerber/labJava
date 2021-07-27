package edu.uchicago.gerber.labjava.lec03.glab.boxing;

import edu.uchicago.gerber.labjava.lec03.glab.ascii.Asciify;


public abstract class Animal {
	

	
	// #################################################
	// ##### INSTANCE FIELDS
	// #################################################

	
	private char[][] cAsciis;
	
	
	
	// #################################################
	// ##### CONSTRUCTORS
	// #################################################


	
	public Animal(String strUrlAscii, int nDim) {
		
		
		cAsciis = Asciify.getAsciiChars(strUrlAscii, nDim, nDim);
		//the distanced is automatically set to zero
		
	}

	
	// #################################################
	// ##### GETTERS/SETTERS
	// #################################################


	public char[][] getAsciis() {
		return cAsciis;
	}

	public void setAsciis(char[][] asciis) {
		cAsciis = asciis;
	}
	
	



	
	// #################################################
	// ##### METHODS
	// #################################################

	


	public String display(int nIndent) {
		
		StringBuilder stb = new StringBuilder();
		
		//for each row of the ascii
			//for counter = 0; counter < distance ; counter++
				//print a space
			//for each col of the current row
				//print the char in the char[][]
			//print newline
		//return a string
		
		for (int nRow = 0; nRow < cAsciis.length; nRow++) {
			
			for(int nSpaces = 0; nSpaces < nIndent; nSpaces++)
				stb.append(' ');
			
			for(int nCol = 0; nCol < cAsciis[nRow].length; nCol++)
			     stb.append(cAsciis[nRow][nCol]);
			
			stb.append('\n');
		}
		
		return stb.toString();
		
		
	}//end display
	
	
		
		

	
}