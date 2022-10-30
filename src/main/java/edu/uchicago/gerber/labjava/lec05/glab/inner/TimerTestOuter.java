package edu.uchicago.gerber.labjava.lec05.glab.inner;

import edu.uchicago.gerber.labjava.lec05.glab.reflection.Reflector;

import javax.swing.*;
import java.awt.event.ActionListener;


public class TimerTestOuter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {


		ActionListener listener = new EventListenerOuter();
        //EventListenerOuter lis = new EventListenerOuter();   //this is legal as well

		//kick-off the timer event every second
        Timer timer = new Timer(1000, listener);
		timer.start();

		//this just allows me to terminate
		JOptionPane.showMessageDialog(null, "Quit?");
		System.exit(0);
		

	}
	


}//end TimerTest class





