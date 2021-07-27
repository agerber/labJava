package edu.uchicago.gerber.labjava.lec07.glab.jpanel_gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: ag
 * Date: 11/16/13
 * Time: 10:06 AM
 * To change this template use File | Settings | File Templates.
 */
public class MockTable {
    private JPanel mPanel;
    private JButton mButtonShow;
    private JPanel mPanelPlayer;

    private ArrayList<Card> crdHands;


    public static void main(String[] args) {
        JFrame frame = new JFrame("MockTable");
        frame.setContentPane(new MockTable().mPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(400, 300);
    }


    //pass in the graphics context of the jPanel you want to draw on
    protected void drawCards(Graphics g) {
        BufferedImage bufferedImage;
        //use this counter to position the cards horizontally
        int nXPos = 10;
        for (Card card : crdHands) {
            bufferedImage = SoundImageUtils.genBuffImage("/src/edu.uchicago.gerber.labjava.lec07/glab/jpanel_gui/imgs/" + card + ".png");
            //nc = x-pos, 100 = y-pos
            g.drawImage(bufferedImage, nXPos, 100, null);
            nXPos = nXPos +25;
        }

    }


    public MockTable() {

        //initialization
        crdHands = new ArrayList<Card>();
        crdHands.add(new Card('9', Card.Suit.SPADES));
        crdHands.add(new Card('T', Card.Suit.SPADES));
        crdHands.add(new Card('J', Card.Suit.SPADES));
        crdHands.add(new Card('Q', Card.Suit.SPADES));
        crdHands.add(new Card('K', Card.Suit.SPADES));

        //eventlisteners
        mButtonShow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               drawCards(mPanelPlayer.getGraphics());
            }
        });


    }
}
