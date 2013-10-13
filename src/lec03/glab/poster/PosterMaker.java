package lec03.glab.poster;





public class PosterMaker {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		
		PosterElement posE = 
				new PosterElement(
				  "//src//lec03//glab//resources//pos_lennon.jpg");

		System.out.println(posE.display());

		Banner banBottom = new Banner(
                "//src//lec03//glab//resources//pos_banner.jpg",
				PosterElement.ZOO_DIM + 4, 20);
	
		System.out.println(banBottom.display());
	}//end main

}
