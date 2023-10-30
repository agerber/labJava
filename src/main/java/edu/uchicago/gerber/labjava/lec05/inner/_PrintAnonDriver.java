package edu.uchicago.gerber.labjava.lec05.inner;

import edu.uchicago.gerber.labjava.lec05.reflection.Reflector;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class _PrintAnonDriver {

	public static void main(String[] args) {

			Thread thread = new Thread(new Runnable() {
				@Override
				public void run() {
					Reflector.printClass(this.getClass());
				}
			});

			thread.start();

	}

}//end class

