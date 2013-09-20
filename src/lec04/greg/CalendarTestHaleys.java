package lec04.greg;

import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;


/**
  
 		        // instantiate a date with today's date called datToday
				// create a datCount set at some earlier date
				// while datCount.year < some arbitrary end year,  loop and increment datCount by one day
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
		final String[] SHORT_NAMES = new DateFormatSymbols().getShortWeekdays();
		final String[] MONTH_NAMES = new DateFormatSymbols().getMonths();

		//create a data structure to hold greg dates and add them manually
		ArrayList<GregorianCalendar> greHaleyAppears = new ArrayList<GregorianCalendar>();
		greHaleyAppears.add(new GregorianCalendar(1617, 5, 3));
		greHaleyAppears.add(new GregorianCalendar(1852, 1, 2));
		greHaleyAppears.add(new GregorianCalendar(1987, 11, 21));
		greHaleyAppears.add(new GregorianCalendar(2061, 6, 18));



		GregorianCalendar greCount;

		for (GregorianCalendar greAppear : greHaleyAppears) {

			greCount = new GregorianCalendar(greAppear.get(Calendar.YEAR), 0, 1);

			//while 
			do {

				// day 1-31 etc.
				int nDay = greCount.get(Calendar.DAY_OF_MONTH);

				if (nDay == 1) {

					System.out.println();
					System.out.println();

					// print out Year + Month
					System.out.println(" " + greCount.get(Calendar.YEAR) + "  "
							+ MONTH_NAMES[greCount.get(Calendar.MONTH)]);

					// print out the days of the week Sun, Mon, etc.
					for (String strDay : SHORT_NAMES)
						System.out.print(strDay + " ");
					System.out.println();

					// determine the weekday of first day of the month; a number from 1 to 7 where 1 is sunday and 7 is saturday
					int nWeekdayOfFirstDay = greCount.get(Calendar.DAY_OF_WEEK);

					//build the an indent string for first row of month matrix
					StringBuilder stb = new StringBuilder();
					while (nWeekdayOfFirstDay > SUNDAY) {
						stb.append("    ");
						nWeekdayOfFirstDay--;
					}
					//print indent no line-break
					System.out.print(stb.toString());

				}

				//print out the day occupying three spaces
				System.out.printf("%3d", nDay);

				// mark today day with asterix, otherwise just space
				if (greCount.get(Calendar.DAY_OF_YEAR) == greAppear
						.get(Calendar.DAY_OF_YEAR))
					System.out.print("*");
				else
					System.out.print(" ");

				//print new line if saturday
				if (greCount.get(Calendar.DAY_OF_WEEK) == SATURDAY)
					System.out.println();

				//add one day
				greCount.add(Calendar.DAY_OF_MONTH, 1);

			} while (greCount.get(Calendar.YEAR) == greAppear
					.get(Calendar.YEAR));

		}//end foreach
	}//end main

}//end class
