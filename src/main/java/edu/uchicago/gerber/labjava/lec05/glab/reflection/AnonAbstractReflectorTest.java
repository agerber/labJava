package edu.uchicago.gerber.labjava.lec05.glab.reflection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * Created by ag on 10/27/2014.
 */
public class AnonAbstractReflectorTest {
    public static void main(String[] args) {

        //uncomment and see what happens; you can't instantiate an interface
        //UNLESS you implement all of its contracted methods inline
        // ActionListener lis2 = new ActionListener();

        // ActionListener lis1 = new ActionListener();  //can't instantiate an abstract class, EXCEPT anonymously like above

        //try selecting the anon abstract class and selecting Refactor || Extract || Variable
        Timer tim = new Timer(1000,

                new ActionListener() {

                    public void actionPerformed(ActionEvent evn) {
                        Date datNow = new Date();
                        System.out.println();
                        System.out.println("type-anonymous and reference-anonymous > At the tone, the time is "
                                + datNow);
                        Reflector.printClass(this.getClass());
                        Toolkit.getDefaultToolkit().beep();

                    }
                }

        );





        tim.start();

        JOptionPane.showMessageDialog(null, "Quit?");
        System.exit(0);

    }
}
