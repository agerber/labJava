package lec04.glab.realestate;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: ag
 * Date: 10/20/13
 * Time: 11:11 PM
 * To change this template use File | Settings | File Templates.
 */
public class CloneTestDriver {




    public static void main(String[] args) {

        House houOrig = new House("5519 Dorchester Ave.",
                1_151_500.00,  //with Java7, I can put an underscore in place of a comma to give my number some separation!
                Asciify.getAsciiChars("http://us.123rf.com/400wm/400/400/sannare/sannare1012/sannare101200032/8466121-model-of-three-dimensions-family-house.jpg", 20),
                false);

        //when you clone, you copy over the values stored in the fields
        //if those fields are primitives, no problem
        //if those fields are Objects, then you're just copying the memory address (see figure on board)
        //so you need to make a deep-copy, by overriding the clone() mehtod and deep-copy the objects!
        House houCloned = null;
        try {
            houCloned = houOrig.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        houCloned.getDatInstantiated().setTime(132165464645L);

        houOrig.display();
        houCloned.display();


    }


}
