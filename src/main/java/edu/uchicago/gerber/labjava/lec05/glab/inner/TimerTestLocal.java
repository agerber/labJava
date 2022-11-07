package edu.uchicago.gerber.labjava.lec05.glab.inner;

import edu.uchicago.gerber.labjava.lec05.glab.reflection.Reflector;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class TimerTestLocal {

	public static void main(String[] args) {



		ActionListener listener = new ActionListener() {
				public void actionPerformed(ActionEvent evn){
					ActionListener[] actionListeners = ( (Timer) evn.getSource()).getActionListeners();
					//You can't instantiate an interface, so what is the type (class) of the object act above?
					System.out.println(actionListeners[0].getClass().getName() +  " -> at the tone, the time is " + new Date());
					Toolkit.getDefaultToolkit().beep();

				}
		};



        Timer timer = new Timer(1000, listener);
		timer.start();
		
		JOptionPane.showMessageDialog(null, "Quit?");
		System.exit(0);
		

	}
	


}//end class




