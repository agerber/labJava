package edu.uchicago.gerber.labjava.lec08.data_time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

//this is the replacement for java.util.Date
public class DateTimeDriver {

    public static void main(String[] args) {
        // Get the current date and time
        LocalDateTime currentTime = LocalDateTime.now();
        System.out.println("Current DateTime: " + currentTime);

        Month month = currentTime.getMonth();
        int day = currentTime.getDayOfMonth();
        int seconds = currentTime.getSecond();

        System.out.println("Month: " + month +"day: " + day +"seconds: " + seconds);


        LocalDate localDate = currentTime.toLocalDate();
        System.out.println("LocalDate: " + localDate);


        LocalDateTime localDateTimeShifted = currentTime.withDayOfMonth(25).withYear(2022);
        System.out.println("LocalDateShifted: " + localDateTimeShifted);


        LocalDate localDateNewYearsEve = LocalDate.of(2022, Month.DECEMBER, 31);
        System.out.println("New Year's Eve: " + localDateNewYearsEve);


        //22 hour 15 minutes
        LocalTime localTimeNew = LocalTime.of(22, 15);
        System.out.println("22Hours15min: " + localTimeNew);

        //parse a string to LocalTime
        LocalTime localTimeParsed = LocalTime.parse("20:15:30");
        System.out.println("localTimeParsed: " + localTimeParsed);
    }
}
