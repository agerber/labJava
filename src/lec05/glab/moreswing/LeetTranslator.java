/*
 * Created by JFormDesigner on Sun Oct 27 23:45:28 CDT 2013
 */

package lec05.glab.moreswing;

import lec01.glab.BinaryToDigital;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.*;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;
import javax.swing.*;

/**
 * @author Adam Gerber
 */
public class LeetTranslator extends JFrame {

    Hashtable htbLeet = new Hashtable<String, String>();

    public LeetTranslator() {
        initComponents();
        initListeners();
        populateTable();
    }

      public static void main(String[] args) {
              EventQueue.invokeLater(new Runnable() {
                  public void run() {
                      try {
      	            //change ClassName to name of this class
                          LeetTranslator window = new LeetTranslator();
                          window.setVisible(true);
                      } catch (Exception e) {
                          e.printStackTrace();
                      }
                  }
              });
          }


    private void populateTable(){
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
        String strSentence = txtPane.getText();

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
                    && Math.random() * 100 < sldLeet.getValue()) {

                strSentence = strSentence.replace(str, strHashValue);
            }

        }

        Clipboard clp = Toolkit.getDefaultToolkit().getSystemClipboard();
        StringSelection sel = new StringSelection(strSentence);
        clp.setContents(sel, null);

        txtPane.setText("");

    }


         //call initListeners upon construction
          private void initListeners() {
              txtPane.addKeyListener(mKeyEnter);
          }

          private KeyListener mKeyEnter = new KeyAdapter(){

              @Override
              public void keyReleased(KeyEvent e) {
                  //To change body of implemented methods use File | Settings | File Templates.
                  if (e.getKeyCode() == KeyEvent.VK_ENTER){
                      translate();
                  }

              }
          };


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Adam Gerber
        sldLeet = new JSlider();
        scrollPane1 = new JScrollPane();
        txtPane = new JTextPane();

        //======== this ========
        setTitle("Leet Translator");
        Container contentPane = getContentPane();
        contentPane.setLayout(null);
        contentPane.add(sldLeet);
        sldLeet.setBounds(15, 10, 520, sldLeet.getPreferredSize().height);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(txtPane);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(15, 40, 525, 335);

        { // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Adam Gerber
    private JSlider sldLeet;
    private JScrollPane scrollPane1;
    private JTextPane txtPane;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
