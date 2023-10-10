package edu.uchicago.gerber.labjava.lec05.inner;

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


		//use the EventListenerInner
		ActionListener listener = new EventListenerInner();

		Timer timer = new Timer(1000, listener);
		timer.start();
		
		JOptionPane.showMessageDialog(null, "Quit?");
		System.exit(0);
		

	}
	


}//end TimerTest class

class EventListenerInner implements ActionListener {
	
	public void actionPerformed(ActionEvent evn){
		ActionListener[] actionListeners = ( (Timer) evn.getSource()).getActionListeners();
		System.out.println(actionListeners[0].getClass().getName() +  " -> at the tone, the time is " + new Date());
		Toolkit.getDefaultToolkit().beep();
	}
}



