package lec06.glab.moreswing2;


import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Adam on 11/2/2015.
 */
public class Leeet implements ActionListener {

    //step1  creat the frame
    private JFrame frm;

    private JMenuBar mJMenuBar;

    private JMenu mJMenuFile;
    private JMenu mJMenuEdit;

    private JMenuItem mJMenuItemExit;
    private JMenuItem mJMenuItemCut;
    private JMenuItem mJMenuItemCopy;
    private JMenuItem mJMenuItemPaste;

    private JTextArea mJTextArea;





    //step 2 create create the swing main method
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Leeet window = new Leeet();
                    window.frm.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    //4 call init from the construtor
    public Leeet() {
        initialize();
    }

    //3 create the intialize method
    private void initialize() {
        frm = new JFrame();
        frm.setBounds(100, 100, 700, 476);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        //set the components
        mJMenuBar = new JMenuBar();
        frm.setJMenuBar(mJMenuBar);

        mJMenuFile = new JMenu("File");
        mJMenuEdit = new JMenu("Edit");

        mJMenuBar.add(mJMenuFile);
        mJMenuBar.add(mJMenuEdit);

        mJMenuItemExit = new JMenuItem("Exit");

        mJMenuFile.add(mJMenuItemExit);

        mJMenuItemExit.addActionListener(this);

        mJMenuItemCut = new JMenuItem("Cut");
        mJMenuItemCopy = new JMenuItem("Copy");
        mJMenuItemPaste = new JMenuItem("Paste");


        mJMenuEdit.add(mJMenuItemCut);
        mJMenuItemCut.addActionListener(this);

        mJMenuEdit.add(mJMenuItemCopy);
        mJMenuItemCopy.addActionListener(this);

        mJMenuEdit.add(mJMenuItemPaste);
        mJMenuItemPaste.addActionListener(this);


        mJTextArea = new JTextArea();
        frm.getContentPane().add(mJTextArea, BorderLayout.CENTER);

        mJTextArea.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_ENTER){
                    System.out.println("you pressed enter");
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        JMenuItem jMenuItem = (JMenuItem) e.getSource();

        String strName = jMenuItem.getText().toUpperCase();
        switch (strName){

            case "CUT":
                mJTextArea.cut();
                break;
            case "PASTE":
                mJTextArea.paste();
                break;
            case "COPY":
                mJTextArea.copy();
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents( new StringSelection(mJTextArea.getText().toString()), null );
                break;
            case "EXIT":
                System.exit(0);
                break;
            default:

                break;
        }
    }
}
