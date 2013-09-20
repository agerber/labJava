package lec05.inner;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class TimeTestAnon {

	public static void main(String[] args) {

		//uncomment and see what happens; you can't instantiate an interface
		//UNLESS you implement all of its contracted methods inline
		// ActionListener lis2 = new ActionListener();

		// ActionListener lis1 = new ActionListener();  //can't instantiate, EXCEPT anonymously like above

		Timer tim = new Timer(1000,

		new ActionListener() {

			public void actionPerformed(ActionEvent evn) {
				Date datNow = new Date();
				System.out.println("type-anonymous and reference-anonymous > At the tone, the time is "
						+ datNow);
				Toolkit.getDefaultToolkit().beep();
			}
		}

		);
		tim.start();

		JOptionPane.showMessageDialog(null, "Quit?");
		System.exit(0);

	}

}//end class

