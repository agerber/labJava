package lec06.glab.inner;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.Timer;
import javax.swing.JOptionPane;


public class TimerTestInner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		
		ActionListener lis = new TimePrintInner();
		
		Class cls = lis.getClass();
		System.out.println(cls.getName());
		
		Timer tim = new Timer(1000, lis);
		tim.start();
		
		JOptionPane.showMessageDialog(null, "Quit?");
		System.exit(0);
		

	}
	


}//end TimerTest class

//===============================================
//==INNER CLASS DEFINED WITHIN THE SAME JAVA FILE
//==ONLY THE ENCLOSING CLASS NEED KNOW ABOUT IT
//===============================================
class TimePrintInner implements ActionListener {
	
	public void actionPerformed(ActionEvent evn){
		Date datNow = new Date();
		System.out.println("At the tone, the time is " + datNow);
		Toolkit.getDefaultToolkit().beep();
	}
}



