package lec07.glab.finals;

import java.awt.*;

public final class TheThreeFinals {

    public static void main(String[] args) {
        //there are three meanings of final in Java.

        // 1/ The first is in the class definition. If a class is declared as
        // final, it cannot be extended. See above.

        // 2/ any primitive variable defined as final can not be changed once assigned.


        final int nNumber = 100;



        // 3/ any object-reference declared final means that the memory address stored in that reference cannot be
        // changed.

        final Rectangle rectangle = new Rectangle(1,1,1,1);

        rectangle.setSize(5,5);
        System.out.println(rectangle);





    }
}
