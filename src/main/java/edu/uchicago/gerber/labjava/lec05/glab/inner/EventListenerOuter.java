package edu.uchicago.gerber.labjava.lec05.glab.inner;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;


public class EventListenerOuter implements ActionListener {
		
		public void actionPerformed(ActionEvent evn){
			Date datNow = new Date();
			System.out.println("outer -> at the tone, the time is " + datNow);
			Toolkit.getDefaultToolkit().beep();
		}
}
