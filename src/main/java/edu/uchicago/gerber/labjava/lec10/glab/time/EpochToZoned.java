package edu.uchicago.gerber.labjava.lec10.glab.time;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

public class EpochToZoned {
    public static void main (String[] args) {

        String epochValue = "1573543685000";
        //330 minutes/ 5:30 hours (client/UI is on GMT IST timezone)
        System.out.println("ZoneId : " + epochMilliSToZDT(epochValue));
        System.out.println("ZoneOffset : " + epochMilliSToZDT(epochValue, 330));

    }

    // Case i) ZoneId
    private static ZonedDateTime epochMilliSToZDT(String  epochMilliSeconds) {
        Long lEpochMilliSeconds = Long.parseLong(epochMilliSeconds);
        return ZonedDateTime.ofInstant(
                Instant.ofEpochMilli(lEpochMilliSeconds), ZoneId.systemDefault());
    }


    //Case ii) ZoneOffset - Adjusting timezone between client and server
    private static ZonedDateTime epochMilliSToZDT(String  epochMilliSeconds, int utcOffsetVal) {
        Long lEpochMilliSeconds = Long.parseLong(epochMilliSeconds);
        ZoneOffset zoneOffSet= ZoneOffset.ofTotalSeconds(utcOffsetVal * 60);
        return ZonedDateTime.ofInstant(
                Instant.ofEpochMilli(lEpochMilliSeconds), zoneOffSet);
    }

}
