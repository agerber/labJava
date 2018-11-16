package lec08.glab.lambda.behaviorParam;

/**
 * Created by Adam on 7/15/2015.
 */

import javax.swing.*;

public class BehaviorP1 {

    public static void main(String[] args) {


        Runnable runner = () -> {
            int nC = 0;
            while (true) {
                System.out.println("hello " + ++nC);
                try {
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread thread;

       // thread =   new Thread(runner);
        thread =   new Thread(runner);
        thread.start();



//        new Timer(500, new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                Toolkit.getDefaultToolkit().beep();
//            }
//        }).start();

        new Timer(500, e -> System.out.println(e.getSource().getClass().getName())).start();




    }
}
