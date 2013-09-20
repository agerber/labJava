package lec04.realestate;


import java.util.ArrayList;

public class RealEstate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {


		ArrayList<House> houHydeParks = new ArrayList<House>();
		
		houHydeParks.add(new House("5519 Dorchester Ave.", 
									151123.13, 
		                            Asciify.getAsciiChars("http://www.bradfitzpatrick.com/stock_illustration/images/cartoon_house_001.gif", 100),
		                            false));
		
		houHydeParks.add(new House("5914 Ellis Ave.", 
				800150.35, 
                Asciify.getAsciiChars("http://www.princegeorgeva.org/Modules/ShowImage.aspx?imageid=314", 100),
                true));
		

		
		houHydeParks.add(new House("1513 53rd Street", 
				520300.85, 
                Asciify.getAsciiChars("http://image.shutterstock.com/display_pic_with_logo/525955/525955,1264001517,30/stock-vector-cartoon-vector-illustration-house-44906851.jpg", 100),
                false));
		
		
		
		
		
		
		for (House hou : houHydeParks) {
			hou.setMarketValue(hou.getMarketValue() * 0.93);
			
		}
		
		
		
		for (House hou : houHydeParks) {
			hou.dispaly();
			System.out.println();
			
		}
		

		House houMostExpensive;
		House houTest;
		
	    houMostExpensive = houHydeParks.get(0);
		
		for (int nC = 1; nC < houHydeParks.size(); nC++) {
			houTest = houHydeParks.get(nC);
			if(houTest.getMarketValue() > houMostExpensive.getMarketValue())
				houMostExpensive = houTest;
		}
			
		System.out.println();
		System.out.println("The most expensive house in Hyde Park: ");
		houMostExpensive.dispaly();

		
		
		
		
	}

}
