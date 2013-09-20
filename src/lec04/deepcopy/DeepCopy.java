package lec04.deepcopy;
import edu.uchicago.cs.java.lec04.realestate.Asciify;
import edu.uchicago.cs.java.lec04.realestate.House;


public class DeepCopy {

	/**
	 * @param args
	 */
	public static void main(String[] args) {



		House houOne = new House(
				"5519 Dorchester Ave.",
				101.25,
				Asciify.getAsciiChars(
						"http://www.bradfitzpatrick.com/stock_illustration/images/cartoon_house_001.gif",
						100), false);

		House houSame = houOne;
		System.out.println("houOne and houSame point the same instantiated object in memory space? " + (houOne == houSame));
		houSame.setMarketValue(21.00);
		
		System.out.println(houOne.getMarketValue());
		System.out.println(houSame.getMarketValue());
		
		System.out.println("##############################");
		

		
		House houTwo = null;
		try {
			houTwo = houOne.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("houOne and houTwo point the same instantiated object in memory space? " + (houOne == houTwo));
		
		houTwo.setMarketValue(57.00);
	
		
		System.out.println("market value: " + houOne.getMarketValue() + " : time stamp " +  houOne.getDatInstantiated().getTime());
		System.out.println("market value: " + houTwo.getMarketValue()  + " : time stamp " +  houTwo.getDatInstantiated().getTime());
		
		
		//deep copy or not; depends if House deep copies the mutable fields of House or not. 
		System.out.println("houOne.getDatInstantiated() and houTwo.getDatInstantiated() point the same instantiated object in memory space? " + (houOne.getDatInstantiated() == houTwo.getDatInstantiated()));
		


	}

}
