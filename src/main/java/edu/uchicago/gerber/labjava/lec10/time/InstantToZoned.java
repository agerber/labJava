package edu.uchicago.gerber.labjava.lec10.time;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

public class InstantToZoned {
    public static void main(String[] args) {
        long epoch = System.currentTimeMillis();
        Instant instant = Instant.ofEpochSecond(epoch);

        //this is consistent on any server
        ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(instant, ZoneOffset.UTC);




    }
}
