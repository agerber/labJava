package edu.uchicago.gerber.labjava.lec10.time;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class LocalAndZonedConversions {

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

    public static void main(String[] args) {

        //local to zoned
        LocalDateTime ldt = LocalDateTime.now(); //Local date time

        ZoneId zoneId = ZoneId.of( "CST" );  //Zone information

        ZonedDateTime zdtAtAsia = ldt.atZone( zoneId );

        ZonedDateTime zdtAtET = zdtAtAsia
                .withZoneSameInstant( ZoneId.of( "America/New_York" ) ); //Sama time in ET timezone


        //UTC universal time coordinated

        //zoned to local
        ZonedDateTime zdtAtET2 = ZonedDateTime.now(ZoneId.of("UTC"));

        LocalDateTime ldt2 = zdtAtET2.toLocalDateTime();

        System.out.println(zdtAtET2);
        System.out.println(ldt2);


    }


}
