package edu.uchicago.gerber.labjava.lec06.moreswing;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created with IntelliJ IDEA.
 * User: ag
 * Date: 10/28/13
 * Time: 9:01 AM
 * To change this template use File | Settings | File Templates.
 */
public class ColorSelect {
    private JPanel mPanel;
    private JPanel mPanelSouth;
    private JPanel mPanelCenter;
    private JSlider mSliderRed;
    private JSlider mSliderGreen;
    private JSlider mSliderBlue;

    private ChangeListener mChangeListener;
    //menus
    private JMenuBar mMenuBar;
    private JMenu mMenu;
    private JMenuItem mMenuItem;
    private static JFrame sFrame;


    public static void main(String[] args) {
        //refactor extract field
        sFrame = new JFrame("ColorSelect");
        sFrame.setContentPane(new ColorSelect().mPanel);
        sFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        sFrame.pack();
        sFrame.setSize(600, 400);
        sFrame.setVisible(true);
    }

    public ColorSelect() {
        //do any init
        mMenuBar = new JMenuBar();
        sFrame.setJMenuBar(mMenuBar);
        mMenu = new JMenu("File");
        mMenuBar.add(mMenu);
        mMenuItem = new JMenuItem("Exit");
        mMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        mMenu.add(mMenuItem);

        //create listeners here
        mChangeListener = new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                setColor();
            }
        };
        mSliderBlue.addChangeListener(mChangeListener);
        mSliderGreen.addChangeListener(mChangeListener);
        mSliderRed.addChangeListener(mChangeListener);
        setColor();
    }

    private void setColor() {

        System.out.println("red" + mSliderRed.getValue() + "gree" + mSliderGreen.getValue() + "blue" +mSliderBlue.getValue() );

        mPanelCenter.setBackground(new Color(mSliderRed.getValue(), mSliderGreen.getValue(), mSliderBlue.getValue()));
    }


}
