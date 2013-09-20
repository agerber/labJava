package lec05.inner;

import javax.swing.*;
import java.awt.event.ActionListener;


public class TimerTestOuter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		
		ActionListener lis = new TimePrintOuter();
		
		Class cls = lis.getClass();
		System.out.println(cls.getName());
		
		Timer tim = new Timer(1000, lis);
		tim.start();
		
		JOptionPane.showMessageDialog(null, "Quit?");
		System.exit(0);
		

	}
	


}//end TimerTest class





