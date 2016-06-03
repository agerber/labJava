package lec10.glab.behavior_param;

import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Adam on 6/3/2016.
 */
public class BPDriver {

    public static void main(String[] args) {


        //anonymous inner class
     Thread thread = new Thread(new Runnable() {
         @Override
         public void run() {

             for (int nC = 0; nC < 10; nC++) {
                 System.out.println("Hello " +nC);
                 try {
                     Thread.sleep(1000);
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
             }

         }
     });

        thread.start();








    }
}
