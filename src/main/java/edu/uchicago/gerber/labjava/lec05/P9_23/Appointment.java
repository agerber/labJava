package edu.uchicago.gerber.labjava.lec05.P9_23;

import java.util.GregorianCalendar;

/**
 * Created by Adam on 10/25/2016.
 */
public abstract class Appointment {

    private String description;
    private GregorianCalendar date;

    public Appointment(String description, GregorianCalendar date) {
        this.description = description;
        this.date = date;
    }



    public boolean occursOn(int year, int month,
                            int day){
       return this.getDate().compareTo(new GregorianCalendar(year,month,day)) == 0;

    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public GregorianCalendar getDate() {
        return date;
    }

    public void setDate(GregorianCalendar date) {
        this.date = date;
    }


    @Override
    public String toString() {
        return  this.getClass().getSimpleName() + "{" +
                "description=" + description + '|' +
                "date=" + date.getTimeInMillis() +
                '}';
    }







}
