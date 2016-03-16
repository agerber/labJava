package lec10.glab.swing_worker;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created with IntelliJ IDEA.
 * User: ag
 * Date: 12/2/13
 * Time: 2:16 PM
 * To change this template use File | Settings | File Templates.
 */
public class SWorker {
    private JProgressBar mProgressBar;
    private JButton mGoButton;
    private JPanel mPanel;


    public static void main(String[] args) {
        JFrame frame = new JFrame("SWorker");
        frame.setContentPane(new SWorker().mPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(500,200);
    }

    public SWorker() {
        //do any intialization

        //event listeners
        mGoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mGoButton.setText("Running");
                ProgressWorker progressWorker = new ProgressWorker();
                progressWorker.execute();
            }
        });


    }

   /* @param <PARAM1> the result type returned by this {@code SwingWorker's}
            *        {@code doInBackground} and {@code get} methods
            * @param <PARAM2> the type used for carrying out intermediate results by this
            *        {@code SwingWorker's} {@code publish} and {@code process} methods
            *
            * @since 1.6
    */

    //the first generic parameter is the return value, the second is the intermediate chunked value
    private class ProgressWorker extends SwingWorker<String, Integer> {

        private int nC = 0;

        //on background thread
        @Override
        protected String doInBackground() throws Exception {
            while (nC <=100){
                Thread.sleep((int)(Math.random() * 100));
                publish(nC++);
            }
            return "Done";

        }

        //this is the feedback it gets while it's running   - on UI Thread
        @Override
        protected void process(List<Integer> chunks) {

            //all we need is the first value of the chunks
            //this occurs because of time-slicing
            mProgressBar.setValue(chunks.get(0));

        }


        //this is what happens when it's done - on UI Thread
        @Override
        protected void done() {
            try {
                mProgressBar.setValue(100);
                mGoButton.setText(get());
            } catch (InterruptedException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            } catch (ExecutionException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }



    }
}
