package lec04.glab.deepcopy;
import lec04.glab.realestate.Asciify;
import lec04.glab.realestate.House;


public class DeepCopy {

	/**
	 * @param args
	 */
	public static void main(String[] args) {



		House houOrig = new House(
				"5519 Dorchester Ave.",
				101.25,
				Asciify.getAsciiChars(
						"http://us.123rf.com/400wm/400/400/sannare/sannare1012/sannare101200032/8466121-model-of-three-dimensions-family-house.jpg",
						100), false);

		House houAssigned = houOrig;
		System.out.println("houOrig and houCloned point the same instantiated object in memory space? " + (houOrig == houAssigned));
		houAssigned.setMarketValue(21.00);
		
		System.out.println(houOrig.getMarketValue());
		System.out.println(houAssigned.getMarketValue());
		
		System.out.println("##############################");
		

		
		House houCloned = null;
		try {
			houCloned = houOrig.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("houOrig and houCloned point the same instantiated object in memory space? " + (houOrig == houCloned));
		
		houCloned.setMarketValue(57.00);
	
		
		System.out.println("market value: " + houOrig.getMarketValue() + " : time stamp " +  houOrig.getDatInstantiated().getTime());
		System.out.println("market value: " + houCloned.getMarketValue()  + " : time stamp " +  houCloned.getDatInstantiated().getTime());
		
		
		//deep copy or not; depends if House deep copies the mutable fields of House or not. 
		System.out.println("houOrig.getDatInstantiated() and houCloned.getDatInstantiated() point the same instantiated object in memory space? " + (houOrig.getDatInstantiated() == houCloned.getDatInstantiated()));
		


	}

}
