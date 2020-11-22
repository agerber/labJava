package lec06.glab.moreswing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private JButton mColorButton;
    private JButton mClearScreenButton;

    private ButtonGroup mButtonGroup;
    private Color mColor;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Painter");

        frame.setContentPane(new Painter().mPanel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(600,900);
        frame.setVisible(true);
    }

//    public JPanel getPanel() {
//        return mPanel;
//    }
//
//    public void setPanel(JPanel mPanel) {
//        this.mPanel = mPanel;
//    }

    public Painter() {
        mButtonGroup = new ButtonGroup();
        mButtonGroup.add(mRoundRadioButton);
        mButtonGroup.add(mSquareRadioButton);
        mRoundRadioButton.setSelected(true);

        mColor = Color.BLACK;
        mColorButton.setBackground(mColor);


        mPanel.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {

                Graphics grp = mPanelNorth.getGraphics();
                grp.setColor(mColor);

                if (!mSquareRadioButton.isSelected()) {
                    grp.fillOval(e.getX(), e.getY(), mSlider.getValue(), mSlider.getValue());
                } else {
                    grp.fillRect(e.getX(), e.getY(), mSlider.getValue(), mSlider.getValue());

                }

            }
        });


        mColorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mColor = JColorChooser.showDialog(mPanelSouth, "Select a Background Color", Color.BLACK);
                if (mColor != null) {
                    mColorButton.setBackground(mColor);
                }
            }
        });
        mClearScreenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Graphics grp = mPanelNorth.getGraphics();
                grp.setColor(Color.LIGHT_GRAY);
                grp.fillRect(0,0,mPanelNorth.getWidth(), mPanelNorth.getHeight());
               mPanelNorth.setBackground(Color.GRAY);
            }
        });
    }
}
