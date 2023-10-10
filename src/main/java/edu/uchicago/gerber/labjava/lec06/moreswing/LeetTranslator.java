package edu.uchicago.gerber.labjava.lec06.moreswing;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: ag
 * Date: 10/28/13
 * Time: 8:43 AM
 * To change this template use File | Settings | File Templates.
 */
public class LeetTranslator {
    private JEditorPane mEditorPane;
    private JPanel mPanel;
    private JSlider mSlider;

    //my members
    private Hashtable htbLeet;


    public static void main(String[] args) {
        JFrame frame = new JFrame("LeetTranslator");
        frame.setContentPane(new LeetTranslator().mPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(300,200);
        frame.setVisible(true);

    }

    public LeetTranslator() {
        //do any intialization here
        populateTable();
        //add actionlisteners here
        mEditorPane.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER){
                    translate();
                }
            }
        });
    }

    private void populateTable(){
        htbLeet =  new Hashtable<String, String>();
        htbLeet.put("a", "@");
        htbLeet.put("b", "8");
        htbLeet.put("c", "(");
        htbLeet.put("d", ")");
        htbLeet.put("e", "3");
        htbLeet.put("f", "|=");
        htbLeet.put("g", "6");
        htbLeet.put("h", "#");
        htbLeet.put("i", "1");
        htbLeet.put("j", "]");
        htbLeet.put("k", "X");
        htbLeet.put("l", "|");
        htbLeet.put("m", "|v|");
        htbLeet.put("n", "|\\|");
        htbLeet.put("o", "0");
        htbLeet.put("p", "|0");
        htbLeet.put("q", "9");
        htbLeet.put("r", "2");
        htbLeet.put("s", "5");
        htbLeet.put("t", "7");
        htbLeet.put("u", "(_)");
        htbLeet.put("v", "\\/");
        htbLeet.put("w", "VV");
        htbLeet.put("x", "%");
        htbLeet.put("y", "'/");
        htbLeet.put("z", "2");
    }

    private void translate() {
        String strSentence = mEditorPane.getText();

        //letters of the sentence as a set
        Set<String> setLetters = new HashSet<String>();
        //keys from our leet hashtable

        //add all the chars
        for (int nC = 0; nC < strSentence.length(); nC++) {
            setLetters.add(String.valueOf(strSentence.charAt(nC)));
        }

        for (String str : setLetters) {

            String strHashValue = (String) htbLeet.get(str);

            if ((strHashValue != null)
                    && Math.random() * 100 < mSlider.getValue()) {

                strSentence = strSentence.replace(str, strHashValue);
            }

        }

        Clipboard clp = Toolkit.getDefaultToolkit().getSystemClipboard();
        StringSelection sel = new StringSelection(strSentence);
        clp.setContents(sel, null);

        mEditorPane.setText("");

    }

}
