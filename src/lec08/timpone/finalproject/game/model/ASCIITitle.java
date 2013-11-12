package lec08.timpone.finalproject.game.model;

/**
 *  This is a utility class that prepares the ASCII art title "Missile Command" that appears on the home screen of the game
 *  where the instructions are displayed before and after each game.  The ASCII art has characters that are difficult
 *  to work with like '|' and '\', so I had to get creative with how to display it.  I created another small Java program 
 *  that reformatted the text with a comma separating each char and wrapped each char in apostrophes.  This allowed the text 
 *  to be hard coded into char arrays. 
 *  
 *  The only method in this class is makeASCIITitle, which loads the ASCII text "Missile Command" into a String[] and returns it.  The 
 *  GamePanel class uses this method to display the text in the game window.  
 *  
 *  The ASCII art was prepared using the site http://bigtext.org
 */
public class ASCIITitle {
	
	// Loads the ASCII art into char arrays which are turned into Strings and returned in a String array
	public static String[] makeASCIITitle(){
		
		// Each of the 6 ASCII text lines are hard coded as a char array to avoid escape sequence problems (like '\' and '|')
		// Some rows still had to have the '\' symbol casted as a char to get this to work correctly:
		
		char[] cRow0 = {'_','_','_',' ',' ','_','_','_','_','_','_','_','_',' ','_','_','_','_','_',' ','_','_','_',
				        '_','_',' ','_','_','_','_','_',' ','_',' ',' ',' ',' ',' ',' ','_','_','_','_','_',' ',' ',
				        ' ',' ','_','_','_','_','_',' ','_','_','_','_','_','_','_','_',' ',' ','_','_','_','_','_',
				        '_',' ',' ','_','_','_',' ',' ','_','_','_',' ',' ',' ','_',' ',' ',' ','_','_','_','_','_',
				        '_','_',' '};
		
		char[] cRow1 = {'|',' ',' ',(char)92,'/',' ',' ','|','_',' ',' ',' ','_','/',' ',' ','_','_','_','/',' ',' ',
				        '_','_','_','|','_',' ',' ',' ','_','|',' ','|',' ',' ',' ',' ','|',' ',' ','_','_','_','|',
				        ' ',' ','/',' ',' ','_','_',' ',(char)92,' ',' ','_',' ',' ','|',' ',' ',(char)92,'/',' ',' ',
				        '|','|',' ',' ',(char)92,'/',' ',' ','|',' ','/',' ','_',' ',(char)92,' ','|',' ',(char)92,' ',
				        '|',' ','|',' ',' ','_',' ',' ',(char)92};
		
		char[] cRow2 = {'|',' ','.',' ',' ','.',' ','|',' ','|',' ','|',' ',(char)92,' ','`','-','-','.',(char)92,' ',
				        '`','-','-','.',' ',' ','|',' ','|',' ','|',' ','|',' ',' ',' ',' ','|',' ','|','_','_',' ',
				        ' ',' ',' ','|',' ','/',' ',' ',(char)92,'/',' ','|',' ','|',' ','|',' ','.',' ',' ','.',' ',
				        '|','|',' ','.',' ',' ','.',' ','|','/',' ','/','_',(char)92,' ',(char)92,'|',' ',' ',(char)92,
				        '|',' ','|',' ','|',' ','|',' ','|'};
		
		char[] cRow3 = {'|',' ','|',(char)92,'/','|',' ','|',' ','|',' ','|',' ',' ','`','-','-','.',' ',(char)92,
				        '`','-','-','.',' ',(char)92,' ','|',' ','|',' ','|',' ','|',' ',' ',' ',' ','|',' ',' ','_',
				        '_','|',' ',' ',' ','|',' ','|',' ',' ',' ','|',' ','|',' ','|',' ','|',' ','|',(char)92,'/',
				        '|',' ','|','|',' ','|',(char)92,'/','|',' ','|','|',' ',' ','_',' ',' ','|','|',' ','.',' ',
				        '`',' ','|',' ','|',' ','|',' ','|'};
		
		char[] cRow4 = {'|',' ','|',' ',' ','|',' ','|','_','|',' ','|','_','/',(char)92,'_','_','/',' ','/',(char)92,
				        '_','_','/',' ','/','_','|',' ','|','_','|',' ','|','_','_','_','_','|',' ','|','_','_','_',
				        ' ',' ',' ','|',' ',(char)92,'_','_','/',(char)92,' ',(char)92,'_','/',' ','/',' ','|',' ',' ',
				        '|',' ','|','|',' ','|',' ',' ','|',' ','|','|',' ','|',' ','|',' ','|','|',' ','|',(char)92,
				        ' ',' ','|',' ','|','/',' ','/',' '};

		char[] cRow5 = {(char)92,'_','|',' ',' ','|','_','/',(char)92,'_','_','_','/',(char)92,'_','_','_','_','/',
				        (char)92,'_','_','_','_','/',' ',(char)92,'_','_','_','/',(char)92,'_','_','_','_','_','/',
				        (char)92,'_','_','_','_','/',' ',' ',' ',' ',(char)92,'_','_','_','_','/',(char)92,'_','_',
				        '_','/',(char)92,'_','|',' ',' ','|','_','/',(char)92,'_','|',' ',' ','|','_','/',(char)92,
				        '_','|',' ','|','_','/',(char)92,'_','|',' ',(char)92,'_','/','_','_','_','/',' ',' '};
		
		String[] lines = new String[6];			// String array that will hold each line of the ASCII art title
		
		lines[0] = new String(cRow0);			// making each of the 6 char arrays a String and adding to an array
		lines[1] = new String(cRow1);
		lines[2] = new String(cRow2);
		lines[3] = new String(cRow3);
		lines[4] = new String(cRow4);
		lines[5] = new String(cRow5);
		
		return lines;
	}
}
