package lec03.glab.poster;





public class PosterMaker {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		
		PosterElement posE = 
				new PosterElement(
				  "file:\\\\\\C:\\dev\\lec03\\src\\edu\\uchicago\\cs\\java\\lec03\\resources\\pos_obama.jpg");


		System.out.println(posE.display());
		
		
		Banner banBottom = new Banner(
				"file:\\\\\\C:\\dev\\lec03\\src\\edu\\uchicago\\cs\\java\\lec03\\resources\\pos_banner.jpg",
				PosterElement.ZOO_DIM + 4, 20);
	
		System.out.println(banBottom.display());
	}//end main

}
