package lec05.glab.moreswing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

/**
 * Created with IntelliJ IDEA.
 * User: ag
 * Date: 10/28/13
 * Time: 10:59 AM
 * To change this template use File | Settings | File Templates.
 */
public class Painter {
    private JPanel mPanel;
    private JPanel mPanelSouth;
    private JPanel mPanelNorth;
    private JSlider mSlider;
    private JRadioButton mRoundRadioButton;
    private JRadioButton mSquareRadioButton;

    private ButtonGroup mButtonGroup;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Painter");
        frame.setContentPane(new Painter().mPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public Painter() {
        mButtonGroup = new ButtonGroup();
       mButtonGroup.add(mRoundRadioButton);
       mButtonGroup.add(mSquareRadioButton);
       mRoundRadioButton.setSelected(true);


        mPanel.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {

              Graphics grpGraphic =  mPanelNorth.getGraphics();
             grpGraphic.setColor(new Color(35,156,79));

                if(!mSquareRadioButton.isSelected()){
                 grpGraphic.fillOval(e.getX(), e.getY(), mSlider.getValue(), mSlider.getValue());
                } else {
                 grpGraphic.fillRect(e.getX(), e.getY(), mSlider.getValue(), mSlider.getValue());

                }

            }
        });


    }
}
