package edu.uchicago.gerber.labjava.lec04.glab.phone;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adam on 10/17/2016.
 */
public class PhoneDriver {
    public static void main(String[] args) {
        Phone applePhone = new ApplePhone("iphone");
        Phone samPhone = new SamsungPhone("samsung phone");
        Phone googPhone = new GooglePhone("goog phone");

        List<Phone> phoneList = new ArrayList<>();
        phoneList.add(applePhone);
        phoneList.add(samPhone);
        phoneList.add(googPhone);

        for (Phone phone : phoneList) {
            System.out.println(phone.charge());
        }

    }
}
