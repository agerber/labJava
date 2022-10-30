package edu.uchicago.gerber.labjava.lec05.glab.inner;

import edu.uchicago.gerber.labjava.lec05.glab.reflection.Reflector;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class TimeTestAnon {

	public static void main(String[] args) {

		Timer timer = new Timer(1000,
				new ActionListener() {
					public void actionPerformed(ActionEvent evn) {
						ActionListener[] actionListeners = ( (Timer) evn.getSource()).getActionListeners();
						System.out.println(actionListeners[0].getClass().getName() +  " -> at the tone, the time is " + new Date());
						Toolkit.getDefaultToolkit().beep();
						//Reflector.printClass(actionListeners[0].getClass());
					}
				}
		);


		timer.start();

		JOptionPane.showMessageDialog(null, "Quit?");
		System.exit(0);

	}

}//end class

