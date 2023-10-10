package edu.uchicago.gerber.labjava.lec10.time;

import java.time.*;

public class DateTimeDriver {
    public static void main(String[] args) {
        //simple output
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println(localTime);
        System.out.println(localDateTime);


        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt.toLocalTime());

        //to local system default - this is dangerous
        ZonedDateTime ldtZoned = ldt.atZone(ZoneId.systemDefault());


        ZonedDateTime utcZoned = ldtZoned.withZoneSameInstant(ZoneId.of("UTC"));

        LocalDateTime myLocalDt = LocalDateTime.now(ZoneOffset.UTC);


        /*
        EST - -05:00
        HST - -10:00
        MST - -07:00
        ACT - Australia/Darwin
        AET - Australia/Sydney
        AGT - America/Argentina/Buenos_Aires
        ART - Africa/Cairo
        AST - America/Anchorage
        BET - America/Sao_Paulo
        BST - Asia/Dhaka
        CAT - Africa/Harare
        CNT - America/St_Johns
        CST - America/Chicago
        CTT - Asia/Shanghai
        EAT - Africa/Addis_Ababa
        ECT - Europe/Paris
        IET - America/Indiana/Indianapolis
        IST - Asia/Kolkata
        JST - Asia/Tokyo
        MIT - Pacific/Apia
        NET - Asia/Yerevan
        NST - Pacific/Auckland
        PLT - Asia/Karachi
        PNT - America/Phoenix
        PRT - America/Puerto_Rico
        PST - America/Los_Angeles
        SST - Pacific/Guadalcanal
        VST - Asia/Ho_Chi_Minh
         */

        System.out.println(utcZoned.toLocalTime());

    }
}
