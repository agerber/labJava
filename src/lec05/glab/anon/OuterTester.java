package lec05.glab.anon;

import lec05.glab.reflection.Reflector;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class OuterTester {

    public static void main(String[] args) {




//        ActionListener lis = new ActionListener() {
//            public void actionPerformed(ActionEvent evn){
//                Date datNow = new Date();
//                System.out.println("type-anonymous > At the tone, the time is " + datNow);
//                Toolkit.getDefaultToolkit().beep();
//                //Reflector.printClass(this.getClass());
//            }
//        };


       // ActionListener lis = new EventListenerOuter();
        //Reflector.printClass(lis.getClass());
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date datNow = new Date();
                System.out.println("type-anonymous > At the tone, the time is " + datNow);
               Toolkit.getDefaultToolkit().beep();
               Reflector.printClass(this.getClass());
            }
        });
        timer.start();

    }
}
