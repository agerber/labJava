package edu.uchicago.gerber.labjava.lec05.inner;

import edu.uchicago.gerber.labjava.lec05.reflection.Reflector;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class _EventModelDriver {

	public static void main(String[] args) {

		Timer timer = new Timer(1000,
				new ActionListener() {
					public void actionPerformed(ActionEvent evn) {
						System.out.println(this.getClass().getName() +  " -> at the tone, the time is " + new Date());
						Toolkit.getDefaultToolkit().beep();
						Reflector.printClass(this.getClass());
					}
				}
		);


		timer.start();

		JOptionPane.showMessageDialog(null, "Quit?");
		System.exit(0);

	}

}//end class

