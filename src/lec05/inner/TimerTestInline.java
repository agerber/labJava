package lec05.inner;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class TimerTestInline {

	public static void main(String[] args) {

		
		//uncomment and see what happens; you can't instantiate an interface
		//UNLESS you implement all of its contracted methods inline
	    // ActionListener lis2 = new ActionListener();
		
		ActionListener lis = new ActionListener() {

			
				public void actionPerformed(ActionEvent evn){
					Date datNow = new Date();
					System.out.println("type-anonymous > At the tone, the time is " + datNow);
					Toolkit.getDefaultToolkit().beep();
				}
		};
			
      // ActionListener lis1 = new ActionListener();  //can't instantiate, EXCEPT anonymously like above
		
		
		Class cls = lis.getClass();
		System.out.println(cls.getName());
       
		
		Timer tim = new Timer(1000, lis);
		tim.start();
		
		JOptionPane.showMessageDialog(null, "Quit?");
		System.exit(0);
		

	}
	


}//end class




