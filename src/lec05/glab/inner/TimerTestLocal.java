package lec05.glab.inner;

import lec05.glab.reflection.Reflector;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class TimerTestLocal {

	public static void main(String[] args) {

		
		//uncomment and see what happens; you can't instantiate an interface
		//UNLESS you implement all of its contracted methods inline
	    // ActionListener lis2 = new ActionListener();
		
		ActionListener lis = new ActionListener() {
				public void actionPerformed(ActionEvent evn){
					Date datNow = new Date();
					System.out.println("type-anonymous > At the tone, the time is " + datNow);
					Toolkit.getDefaultToolkit().beep();
					//Reflector.printClass(this.getClass());
				}
		};


        //You can't instantiate an interface, so what is the type (class) of the object act above?
       //Reflector.printClass(lis.getClass());

        Timer tim = new Timer(1000, lis);
		tim.start();
		
		JOptionPane.showMessageDialog(null, "Quit?");
		System.exit(0);
		

	}
	


}//end class




