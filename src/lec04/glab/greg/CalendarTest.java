package lec04.glab.greg;

import java.text.DateFormatSymbols;
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
	
public class CalendarTest {


	public static void main(String[] args) {

		// ===============================================
		// ==  PSEUDOCODE
		// ===============================================

		
		


		// ===============================================
		// ==CONSTANTS
		// ===============================================

		final int SUNDAY = 1;
		final int SATURDAY = 7;
		final int RETROJECT_YEARS = 1;
		final int PROJECT_YEARS = 9;
		final String[] SHORT_NAMES = new DateFormatSymbols()
				.getShortWeekdays();
		final String[] MONTH_NAMES = new DateFormatSymbols().getMonths();

		GregorianCalendar greToday = new GregorianCalendar();

		final int CURRENT_YEAR = greToday.get(Calendar.YEAR);

		GregorianCalendar greCount = new GregorianCalendar(CURRENT_YEAR
				- RETROJECT_YEARS, Calendar.JANUARY, 1);



	}//end main

}//end class
