package edu.uchicago.gerber.labjava.lec03.glab.poster;





public class PosterMaker {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		
		PosterElement posE = 
				new PosterElement(
				  "//src//edu.uchicago.gerber.labjava.lec03//glab//resources//pos_lennon.jpg");

		System.out.println(posE.display(0));

	}//end main

}
