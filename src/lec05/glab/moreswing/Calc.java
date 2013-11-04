package lec05.glab.moreswing;

import lec09.glab.structs.Queue;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: ag
 * Date: 10/28/13
 * Time: 9:27 AM
 * To change this template use File | Settings | File Templates.
 */
public class Calc {
    private JTextField mTextField;
    private JButton m7Button;
    private JButton m4Button;
    private JButton m8Button;
    private JButton m5Button;
    private JButton m9Button;
    private JButton m6Button;
    private JButton m1Button;
    private JButton m2Button;
    private JButton m3Button;
    private JButton m0Button;
    private JButton mButtonPlus;
    private JButton mButtonEqual;
    private JButton mButtonDiff;
    private JButton mButtonMult;
    private JButton mButtonDiv;
    private JPanel mPanel;


   //my members
    private ActionListener mActionListener;




    public static void main(String[] args) {
        JFrame frame = new JFrame("Calc");
        frame.setContentPane(new Calc().mPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


    public Calc() {
        //do any initialization



        //create and add any listeners
        mActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               String strButtonText =  ((JButton)e.getSource()).getText();
                try {
                    int nVal = Integer.parseInt(strButtonText);
                    mTextField.setText(mTextField.getText() + String.valueOf(nVal));
                } catch (NumberFormatException e1) {

                    //just set to nothing for now
                    mTextField.setText("");

                }
            }
        };


        m0Button.addActionListener(mActionListener);
        m1Button.addActionListener(mActionListener);
        m2Button.addActionListener(mActionListener);
        m3Button.addActionListener(mActionListener);
        m4Button.addActionListener(mActionListener);
        m5Button.addActionListener(mActionListener);
        m6Button.addActionListener(mActionListener);
        m8Button.addActionListener(mActionListener);
        m7Button.addActionListener(mActionListener);
        m9Button.addActionListener(mActionListener);
        mButtonPlus.addActionListener(mActionListener);
        mButtonEqual.addActionListener(mActionListener);
        mButtonDiff.addActionListener(mActionListener);
        mButtonMult.addActionListener(mActionListener);
        mButtonDiv.addActionListener(mActionListener);




    }


}
