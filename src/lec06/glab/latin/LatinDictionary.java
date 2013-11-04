package lec06.glab.latin;

import javax.swing.*;

/**
 * Created with IntelliJ IDEA.
 * User: ag
 * Date: 11/4/13
 * Time: 10:59 AM
 * To change this template use File | Settings | File Templates.
 */
public class LatinDictionary {
    private JPanel mValue;
    private JButton mButtonNew;
    private JButton mButtonSearch;
    private JList mList;

    public static void main(String[] args) {
        JFrame frame = new JFrame("LatinDictionary");
        frame.setContentPane(new LatinDictionary().mValue);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,600);
        frame.pack();
        frame.setVisible(true);
    }

    public LatinDictionary() {

        //init

        //event listeners



    }
}
