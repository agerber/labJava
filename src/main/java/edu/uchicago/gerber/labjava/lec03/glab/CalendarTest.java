package edu.uchicago.gerber.labjava.lec03.glab;

import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.GregorianCalendar;


/**
  <pre>
 		        // instantiate a date with today's date called greToday
				// create a greCount set at some earlier date
				// while greCount.year < some arbitrary end year,  loop and increment greCount by one day
					  //if dayOfMonth == 1
						//print out year & month & newline
						//print out the days of the week Sun Mon Tue etc. & newline
						//determine the ordinal day of the week 1 through 7  Sun through Sat
						//init counter to ordinalDay and for each day greater than 1 (Sunday)
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
	</pre>
*/

public class CalendarTest {


    public static void main(String[] args) {


        // ===============================================
        // ==CONSTANTS
        // ===============================================

        final int SUNDAY = 1;
        final int SATURDAY = 7;
        final int RETROJECT_YEARS = 1;
        final int PROJECT_YEARS = 9;
        final String[] SHORT_WEEK_NAMES = new DateFormatSymbols()
                .getShortWeekdays();
        final String[] MONTH_NAMES = new DateFormatSymbols().getMonths();

        //GregorianCalendar greHire = new GregorianCalendar(nYear, nMonth -1, nDay);

        //the month in a GregCalendar is from 0-11, so October is 9
        GregorianCalendar greToday = new GregorianCalendar(2013, 9, 14);

        final int CURRENT_YEAR = greToday.get(Calendar.YEAR);

        GregorianCalendar greCount = new GregorianCalendar(CURRENT_YEAR
                - RETROJECT_YEARS, Calendar.JANUARY, 1);

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
                for (String strDay : SHORT_WEEK_NAMES){
                    System.out.print(strDay + " ");
                }
                System.out.println();

                // determine the weekday of first day of the month; a number from 1 to 7 where 1 is sunday and 7 is saturday
                int nWeekdayOfFirstDay = greCount.get(Calendar.DAY_OF_WEEK);

                //build the an indent string for first row of month matrix
                StringBuilder stb = new StringBuilder();
                while (nWeekdayOfFirstDay > SUNDAY) {
                    //four spaces for each date is the correct indent
                    stb.append("    ");
                    nWeekdayOfFirstDay--;
                }
                //print indent no line-break
                System.out.print(stb.toString());

            }

            //print out the day occupying three spaces
            System.out.printf("%3d", nDay);

            // mark today day with asterix, otherwise just space

            if (greCount.compareTo(greToday)==0)     {
                System.out.print("*");
            }
             else {
                System.out.print(" ");
            }

            //print new line if saturday
            if (greCount.get(Calendar.DAY_OF_WEEK) == SATURDAY){
                System.out.println();
            }

            //add one day
            greCount.add(Calendar.DAY_OF_MONTH, 1);

        } while (greCount.get(Calendar.YEAR) < CURRENT_YEAR + PROJECT_YEARS);

    }//end main

}//end class
