package lec06.glab.notepad;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Notepad implements ActionListener {

    private JFrame frame;
    private JTextArea textArea;
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenu menu_1;
    private JMenu menu_2;
    private JMenu menu_3;
    private JMenuItem menuItem;
    private JMenuItem menuItem_1;
    private JMenuItem menuItem_2;
    private JMenuItem menuItem_3;
    private JMenuItem menuItem_4;
    private JMenuItem menuItem_5;
    private JMenuItem menuItem_6;
    private JMenuItem menuItem_7;
    private JMenuItem menuItem_8;
    private JMenuItem menuItem_9;
    private JMenuItem menuItem_10;
    private JMenuItem menuItem_11;
    private JMenuItem menuItem_12;
    private JMenuItem menuItem_13;
    private JMenuItem menuItem_14;
    private JMenuItem menuItem_15;
    private JMenuItem menuItem_16;
    private JMenuItem menuItem_17;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Notepad window = new Notepad();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public Notepad() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();


        frame.setTitle("Notepad");
        frame.setBounds(100, 100, 528, 420);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textArea = new JTextArea();
        frame.getContentPane().add(textArea, BorderLayout.CENTER);

        textArea.setLineWrap(true);

        textArea.setWrapStyleWord(true);

        menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);

        menu = new JMenu("File");
        menuBar.add(menu);

        menuItem = new JMenuItem("New");
        menu.add(menuItem);

        menuItem_1 = new JMenuItem("Open");
        menu.add(menuItem_1);

        menuItem_2 = new JMenuItem("Save");
        menu.add(menuItem_2);

        menuItem_3 = new JMenuItem("Save As...");
        menu.add(menuItem_3);

        menuItem_4 = new JMenuItem("Print");
        menu.add(menuItem_4);

        menuItem_5 = new JMenuItem("Exit");
        menu.add(menuItem_5);

        menu_1 = new JMenu("Edit");
        menuBar.add(menu_1);

        menuItem_6 = new JMenuItem("Undo");
        menu_1.add(menuItem_6);

        menuItem_7 = new JMenuItem("Redo");
        menu_1.add(menuItem_7);

        menuItem_8 = new JMenuItem("Cut");
        menu_1.add(menuItem_8);
        menuItem_8.addActionListener(this);

        menuItem_9 = new JMenuItem("Copy");
        menu_1.add(menuItem_9);
        menuItem_9.addActionListener(this);

        menuItem_10 = new JMenuItem("Paste");
        menu_1.add(menuItem_10);
        menuItem_10.addActionListener(this);

        menuItem_11 = new JMenuItem("Find");
        menu_1.add(menuItem_11);

        menuItem_12 = new JMenuItem("Select All");
        menu_1.add(menuItem_12);

        menuItem_13 = new JMenuItem("Date/Time");
        menu_1.add(menuItem_13);

        menu_2 = new JMenu("Format");
        menuBar.add(menu_2);

        menuItem_14 = new JMenuItem("Font");
        menu_2.add(menuItem_14);

        menuItem_15 = new JMenuItem("Color");
        menu_2.add(menuItem_15);

        menuItem_16 = new JMenuItem("Word Wrap");
        menu_2.add(menuItem_16);

        menu_3 = new JMenu("Help");
        menuBar.add(menu_3);

        menuItem_17 = new JMenuItem("About");
        menu_3.add(menuItem_17);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JMenuItem menuItem = (JMenuItem) e.getSource();
        String action = menuItem.getText();
        switch (action.toUpperCase()){

            case "CUT":
                textArea.cut();
                break;

            case "COPY":
                textArea.copy();
                break;

            case "PASTE":
                textArea.paste();
                break;
        }



    }
}
