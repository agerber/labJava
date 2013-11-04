package lec05.glab.inner;

import lec05.glab.reflection.Reflector;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;


public class TimerTestInner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		
		ActionListener lis = new EventListenerInner();
        //Reflector.printClass(lis.getClass());

		Timer tim = new Timer(1000, lis);
		tim.start();
		
		JOptionPane.showMessageDialog(null, "Quit?");
		System.exit(0);
		

	}

    static class EventListenerInner implements ActionListener {

        public void actionPerformed(ActionEvent evn){
            Date datNow = new Date();
            System.out.println("At the tone, the time is " + datNow);
            Toolkit.getDefaultToolkit().beep();
        }
    }

}//end TimerTest class





