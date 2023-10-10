package edu.uchicago.gerber.labjava.lec02.projects;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalendarDemo {

    public static void main(String[] args) {
        // Get today's date
        GregorianCalendar today = new GregorianCalendar();
        int currentMonth = today.get(Calendar.MONTH);
        int currentYear = today.get(Calendar.YEAR);
        int currentDay = today.get(Calendar.DAY_OF_MONTH);

        // Loop through each month
        for (int month = 0; month < 12; month++) {
            printMonthCalendar(currentYear, month, currentDay, month == currentMonth);
        }
    }

    public static void printMonthCalendar(int year, int month, int currentDay, boolean isCurrentMonth) {
        GregorianCalendar cal = new GregorianCalendar(year, month, 1);
        int startDay = cal.get(Calendar.DAY_OF_WEEK) - 1; // Sun=0, Mon=1, ..., Sat=6
        int daysInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

        // Print month header
        System.out.println("\n" + cal.getDisplayName(Calendar.MONTH, Calendar.LONG, java.util.Locale.getDefault()) + " " + year);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");

        // Print spaces for the starting days
        for (int i = 0; i < startDay; i++) {
            System.out.print("    ");
        }

        // Print days
        for (int day = 1; day <= daysInMonth; day++, startDay++) {
            if (isCurrentMonth && day == currentDay) {
                System.out.printf(" %2d*", day);
            } else {
                System.out.printf(" %2d ", day);
            }
            if (startDay % 7 == 6) {
                System.out.println();
            }
        }
        System.out.println();
    }
}
