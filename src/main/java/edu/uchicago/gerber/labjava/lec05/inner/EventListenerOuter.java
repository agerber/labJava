package edu.uchicago.gerber.labjava.lec05.inner;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.Timer;


public class EventListenerOuter implements ActionListener {
		
		public void actionPerformed(ActionEvent evn){

			ActionListener[] actionListeners = ( (Timer) evn.getSource()).getActionListeners();
			System.out.println(actionListeners[0].getClass().getName() +  " -> at the tone, the time is " + new Date());
			Toolkit.getDefaultToolkit().beep();
		}
}
