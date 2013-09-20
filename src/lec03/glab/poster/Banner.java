package lec03.glab.poster;

import lec03.glab.ascii.Asciify;


public class Banner {
	

	
	// #################################################
	// ##### INSTANCE FIELDS
	// #################################################

	
	private char[][] cAsciis;
	
	
	
	// #################################################
	// ##### CONSTRUCTORS
	// #################################################


	
	public Banner(String strUrlAscii, int nDimW, int nDimH) {
		
		
		cAsciis = Asciify.getAsciiChars(strUrlAscii, nDimW, nDimH);
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
	
	

	public String display() {
		
		StringBuilder stb = new StringBuilder();
		
		//for each row of the ascii
			//for counter = 0; counter < distance ; counter++
				//print a space
			//for each col of the current row
				//print the char in the char[][]
			//print newline
		//return a string
		
		for (int nRow = 0; nRow < cAsciis.length; nRow++) {
			

			
			for(int nCol = 0; nCol < cAsciis[nRow].length; nCol++)
			     stb.append(cAsciis[nRow][nCol]);
			
			stb.append('\n');
		}
		
		return stb.toString();
		
		
	}//end display

	
		
		

	
}