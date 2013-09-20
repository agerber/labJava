package lec03;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;


public class KeyboardInput_ {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		//just import from java.util and pass in System.in
		Scanner scnIn = new Scanner(System.in);

		//let's add our sentences to an arraylist
		ArrayList<String> strSentences = new ArrayList<String>();

		System.out.println("--------------------------");

		do {
			System.out
					.println("Type a sentence please (or type exit to quit):");
			String strTemp = scnIn.nextLine();
			if (strTemp.toUpperCase().equals("EXIT"))
				break;

			strSentences.add(strTemp);

		} while (true); //infinite loop -- must meet break condition

		System.out.println("--------------------------");
		System.out.println("ECHO >>>>>>>>>>>>>>>>>>>>>>>");
		for (String str : strSentences) {
			System.out.println(str);
		}

		
		
		
		//let's try it again, this time with a file
		
		strSentences.clear();

		boolean bSuccess = false;
		Scanner scnFile = null;
		do {

			System.out.println("Type the full path to your file to read:");
			String strFilePath = scnIn.nextLine();
			//get rid of all backslashes and replace with forward slashes
			strFilePath = strFilePath.replace('\\', '/');

			try {
				scnFile = new Scanner(new File(strFilePath));
				bSuccess = true;
			} catch (Exception e) {
				System.out.println("I can't find that file. "
						+ "Make sure to append the .txt on the end: "
						+ e.getMessage());
				bSuccess = false;
			}
		} while (!bSuccess);

		
		System.out.println("--------------------------");
		System.out.println("YOUR FILE >>>>>>>>>>>>>>>>>>>>>>>");
		//iterate over scnFile
		while (scnFile.hasNext()){
			String strLine = scnFile.nextLine();
			System.out.println(strLine);
		}
		

			

	


	}//end main

}
