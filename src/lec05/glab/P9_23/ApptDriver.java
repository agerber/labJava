package lec05.glab.P9_23;

import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * Created by Adam on 10/25/2016.
 */
public class ApptDriver {

    public static void main(String[] args) {

        Appointment[] appointments = {

            new Daily("Wake up", new GregorianCalendar(1999, 11, 31)),
            new Onetime("Dentist", new GregorianCalendar(2016, 0, 29)),
            new Onetime("Vote 2016", new GregorianCalendar(2016, 2, 18)),
            new Monthly("Pay Mortgage", new GregorianCalendar(2016, 10, 21))


        };

        Scanner scanner = new Scanner(System.in);
        GregorianCalendar gregorianCalendar;


        while (true) {
            try {
                System.out.println("What date did your occurance happen as YYYY/MM/DD ?");
                String input =  scanner.nextLine();
                gregorianCalendar = convertStringToGreg(input);
                break;
            } catch (IOException e) {
                System.out.println(e.getMessage() + ", try again!");
                continue;
            }
        }

        for (Appointment appointment : appointments) {
            if (appointment.getDate().compareTo(gregorianCalendar) == 0 ){
                System.out.println(appointment);
            }
        }

    }

    private static GregorianCalendar convertStringToGreg(String input) throws IOException{

        String[] splits = input.split("/");
        if ( splits.length != 3)
            throw new IOException("Too many or too few delimiters");


        int day, month, year;

        try {
            day = Integer.parseInt(splits[2]);
            month = Integer.parseInt(splits[1]);
            year = Integer.parseInt(splits[0]);
        } catch (NumberFormatException e) {
           throw new IOException("One of your values was not a number");
        }
        GregorianCalendar gregorianCalendar;
        try {
             gregorianCalendar =  new GregorianCalendar(year, month -1, day);
        } catch (Exception e) {
           throw new IOException("Your date is out of range");
        }

        return gregorianCalendar;


    }

}
