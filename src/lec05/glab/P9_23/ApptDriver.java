package lec05.glab.P9_23;

import java.io.IOException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Adam on 10/25/2016.
 */
public class ApptDriver {
   static List<Appointment> appointments = new ArrayList<>();

    public static void main(String[] args) {



        appointments.add(new Daily("Wake up", new GregorianCalendar(1999, 11, 31)));
        appointments.add(new Onetime("Dentist", new GregorianCalendar(2016, 0, 29)));
        appointments.add(new Onetime("Vote 2016", new GregorianCalendar(2016, 2, 18)));
        appointments.add(new Monthly("Pay Mortgage", new GregorianCalendar(2016, 10, 21)));

        Scanner scanner = new Scanner(System.in);
        GregorianCalendar gregorianCalendar;

        outer:
        while (true){
            System.out.println("press 'A' to add appointment, or press Q to quit'");
            String input =  scanner.nextLine();

            switch (input.toUpperCase()){
                case "A":
                    System.out.println("What is your appointment in format on one of three formats Daily, Monthly, or Onctime e.g.: Daily|Brush teeth|YYYY/MM/DD ?");
                    String appointment = scanner.nextLine();
                    try {
                        appointments.add(convertStringToAppt(appointment));

                        reportAllAppointments();
                    } catch (IOException e) {
                        System.out.println(e.getMessage() + ", try again!");
                        continue;
                    }

                    break;
                case "Q":
                    break outer;
                default:
                    System.out.println("sorry, I didn't understand. Try again.");
                    continue  outer;
            }

        }


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


    private static void reportAllAppointments(){
        System.out.println("All Appointments:");
        for (Appointment appointment : appointments) {

                System.out.println(appointment);

        }
    }

    private static GregorianCalendar convertStringToGreg(String input) throws IOException{


        String[] splits = input.split("/");
        return getGregorianCalendar(splits);


    }


    private static Appointment convertStringToAppt(String input) throws IOException{

        String[] splits = input.split("\\|");
        if ( splits.length != 3)
            throw new IOException("Too many or too few delimiters");


        String type, desc, date;

        type = splits[0];
        desc = splits[1];
        date = splits[2];

      switch (type){
          case "Daily":
              return new Daily(desc, getGregorianCalendar(date.split("/")));

          case "Onetime":
              return new Onetime(desc, getGregorianCalendar(date.split("/")));

          case "Monthly":
              return new Monthly(desc, getGregorianCalendar(date.split("/")));

          default:
              throw new IOException("That's not an Appointment type");
      }

    }

    private static GregorianCalendar getGregorianCalendar(String[] splits) throws IOException {


        if ( splits.length != 3)
            throw new IOException("Too many or too few delimiters");

        int day;
        int month;
        int year;
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
