package lec06.glab.latin;

import javax.swing.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;

public class NewDef extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextArea mTextAreaLatin;
    private JTextArea mTextAreaEnglish;
    private LatinDictionary mLatinDictionary;

    public NewDef(LatinDictionary latinDictionary) {
        mLatinDictionary = latinDictionary;
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

// call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

// call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
// add your code here

        Map<String,String> map = new HashMap<>();
        map.put(mTextAreaLatin.getText(), mTextAreaEnglish.getText());
        mLatinDictionary.setList(map);
        dispose();
    }

    private void onCancel() {
// add your code here if necessary
        dispose();
    }

//    public static void main(String[] args) {
//        NewDef dialog = new NewDef();
//        dialog.pack();
//        dialog.setVisible(true);
//        System.exit(0);
//    }
}
