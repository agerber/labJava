package lec04.glab.realestate;


import java.util.ArrayList;

public class RealEstate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {


		ArrayList<House> houHydeParks = new ArrayList<House>();
		
		houHydeParks.add(new House("5519 Dorchester Ave.", 
									151123.13, 
		                            Asciify.getAsciiChars("http://us.123rf.com/400wm/400/400/sannare/sannare1012/sannare101200032/8466121-model-of-three-dimensions-family-house.jpg", 20),
		                            false));
		
		houHydeParks.add(new House("5914 Ellis Ave.", 
				800150.35, 
                Asciify.getAsciiChars("http://www.princegeorgeva.org/Modules/ShowImage.aspx?imageid=314", 20),
                true));
		

		
		houHydeParks.add(new House("1513 53rd Street", 
				520300.85, 
                Asciify.getAsciiChars("http://image.shutterstock.com/display_pic_with_logo/525955/525955,1264001517,30/stock-vector-cartoon-vector-illustration-house-44906851.jpg", 20),
                false));
		
		
		
		
		

        //subprime-crash!
		for (House hou : houHydeParks) {
			hou.setMarketValue(hou.getMarketValue() * 0.75);
			
		}
		
		
		
		for (House hou : houHydeParks) {
			hou.display();
			System.out.println();
			
		}
		

		House houMostExpensive;
		House houTest;
		
	    houMostExpensive = houHydeParks.get(0);
		
		for (int nC = 1; nC < houHydeParks.size(); nC++) {
			houTest = houHydeParks.get(nC);
			if(houTest.getMarketValue() > houMostExpensive.getMarketValue()) {
				houMostExpensive = houTest;
            }
		}
			
		System.out.println();
		System.out.println("The most expensive house in Hyde Park: ");
		houMostExpensive.display();


        //when you clone, you copy over the values stored in the fields
        //if those fields are primitives, no problem
        //if those fields are Objects, then you're just copying the memory address (see figure on board)
        //so you need to make a deep-copy, by overriding the clone() mehtod and deep-copy the objects!
        House houTemp = null;
        try {
            houTemp  = houMostExpensive.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        System.out.println("clone below ->");
        houTemp.display();


    }

}
