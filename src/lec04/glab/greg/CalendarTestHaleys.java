package lec04.glab.greg;

import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;


/**
  
 		        // instantiate a date with today's date called datToday
				// create a datCount set at some earlier date
				// datCount = datHaleys (year, month, 1) loop and increment datCount by one day
					  //if dayOfMonth == 1  
						//print out year plus month
						//print out the days of the week Sun Mon Tue etc. 
						//determine the ordinal day of the week 1 through 7  Sun through Sat
						//init counter to ordinalDay and for each day greater than 1
							//build a string for an indent
							//decrement ordinalDay
						//print out the indent -- no line break
					
						
					  //print out the day of the month e.g. 18
					  //if startDate == today
					     //add an asterix
					  //else
						 //just add another space
					  //if the day of week is saturday
						 //print line break
					  //add one day to the startDate
	
*/		



public class CalendarTestHaleys {

	public static void main(String[] args) {

		// ===============================================
		// ==  PSEUDOCODE
		// ===============================================

		// ===============================================
		// ==CONSTANTS
		// ===============================================

		final int SUNDAY = 1;
		final int SATURDAY = 7;
		final String[] SHORT_NAMES = new DateFormatSymbols().getShortWeekdays();  //MON TUE WED, etc
		final String[] MONTH_NAMES = new DateFormatSymbols().getMonths();  //January February etc.

		//create a data structure to hold greg dates and add them manually
		ArrayList<GregorianCalendar> greAppears = new ArrayList<GregorianCalendar>();
		greAppears.add(new GregorianCalendar(1617, 5, 3));
		greAppears.add(new GregorianCalendar(1852, 1, 2));
		greAppears.add(new GregorianCalendar(1987, 11, 21));
		greAppears.add(new GregorianCalendar(2061, 6, 18));



	}//end main

}//end class
