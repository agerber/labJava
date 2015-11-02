package lec05.glab.swing;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Adam on 11/2/2015.
 */
public class Painter {
    //define a frame
    private JFrame frm;

    //creaete a main method that insantiates the ecnlosing object
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Painter window = new Painter();
                    window.frm.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    //constructor calls init
    public Painter() {
        initialize();
    }

    //our init methhod
    private void initialize() {
        frm = new JFrame();
        frm.setBounds(100, 100, 450, 476);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


}
