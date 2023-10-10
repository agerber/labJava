package edu.uchicago.gerber.labjava.lec04.phone2;

import java.util.ArrayList;

/**
 * Created by Adam on 10/17/2016.
 */
public class PhoneDriver {

    public static void main(String[] args) {


        Phone applePhone = new ApplePhone("iPhone");
        Phone googlePhone = new GooglePhone("piexel");
        Phone samsungPhone = new SamsungPhone("gaxaxy7");

        ArrayList<Phone> phones = new ArrayList<>();

        phones.add(applePhone);
        phones.add(googlePhone);
        phones.add(samsungPhone);

        for (Phone phone : phones) {
            System.out.println(phone.getClass()
                    + ":" +phone.query());
        }





    }
}
