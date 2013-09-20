package lec06.inner;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;


public class TimePrintOuter implements ActionListener {
		
		public void actionPerformed(ActionEvent evn){
			Date datNow = new Date();
			System.out.println("outer -> at the tone, the time is " + datNow);
			Toolkit.getDefaultToolkit().beep();
		}
}
