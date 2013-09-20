package lec03.poster;

import edu.uchicago.cs.java.lec03.boxing.Animal;


//this is not abstract
public class PosterElement extends Animal {

	public static final int ZOO_DIM = 150;
	
	public PosterElement(String strUrlAscii) {

		//call the superclass constructor to set the borderless asciis
		super(strUrlAscii, ZOO_DIM);
		
		    //reset the asciis with a border
		
		    char[][] cOrigs = getAsciis();
		    char[][] cResults =  new char[ZOO_DIM + 4][ZOO_DIM + 4];
		    
		    
		    for (int nRow = 0; nRow < cResults.length; nRow++){
		    	for (int nCol = 0; nCol < cResults[nRow].length; nCol++){
		    		if(nRow == 0 || nRow == 1 || nRow == cResults.length - 2 || nRow == cResults.length - 1){
		    			cResults[nRow][nCol] = '#';
		    		}
		    		else {
		    			if (nCol == 0 || nCol == 1 || nCol == cResults[nRow].length - 2 || nCol ==cResults[nRow].length - 1 ){
		    				cResults[nRow][nCol] = '#';
		    			}
		    			else {
		    				cResults[nRow][nCol] = cOrigs[nRow-2][nCol-2];
		    			}
		    		}
		    		     
		    		
		    	}
		    	
		    }
		    	
		    
		//call the setAsciis to reset the char[][] with border
		setAsciis(cResults);

	}

	//display just calls the suerclass with zero as argument
	public String display() {

         return   super.display(0);

		
		
	}

}
