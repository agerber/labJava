package edu.uchicago.gerber.labjava.lec07.notepad;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;

/**
 * Created with IntelliJ IDEA.
 * User: ag
 * Date: 11/3/13
 * Time: 6:29 PM
 * To change this template use File | Settings | File Templates.
 */
public class GoodNotepad {
    private JPanel mPanel;
    private JTextArea mTextArea;
    private JScrollPane mScrollPane;

    private JMenuBar mMenuBar;
    private JMenu mMenuFile;
    private JMenu mMenuEdit;
    private JMenu mMenuHelp;
    private JMenu mMenuInsert;
    private JMenuItem mMenuItemNew;
    private JMenuItem mMenuItemOpen;
    private JMenuItem mMenuItemSave;
    private JMenuItem mMenuItemExit;
    private JMenuItem mMenuItemCut;
    private JMenuItem mMenuItemCopy;
    private JMenuItem mMenuItemPaste;
    private JMenuItem mMenuItemSelectAll;
    private JMenuItem mMenuItemTime;
    private JMenuItem mMenuItemDate;
    private JMenuItem mMenuItemAbout;
    private static JFrame sFrame;

    public static void main(String[] args) {
        sFrame = new JFrame("Good-Notepad");
        sFrame.setContentPane(new GoodNotepad().mPanel);
        sFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        sFrame.pack();
        sFrame.setSize(600,600);
        sFrame.setVisible(true);
    }


    public GoodNotepad() {

        //init
        mTextArea.setLineWrap(true);
        mTextArea.setWrapStyleWord(true);
        mTextArea.setBackground(Color.GRAY);
        mTextArea.setEditable(false);

        mMenuBar = new JMenuBar();
        //we will need access to the frame as a member so that we can ad the menu-bar
        //refactor/extract/field
        sFrame.setJMenuBar(mMenuBar);

        //File menu
        mMenuFile = new JMenu("File");
        mMenuBar.add(mMenuFile);

            mMenuItemNew = new JMenuItem("New");
            mMenuFile.add(mMenuItemNew);
            mMenuItemNew.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    mTextArea.setBackground(Color.WHITE);
                    mTextArea.setEditable(true);

                }
            });

            mMenuItemOpen = new JMenuItem("Open");
            mMenuFile.add(mMenuItemOpen);
            mMenuItemOpen.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                   mTextArea.setText(ClipboardAndFileUtil.open());
                }
            });

            mMenuItemSave = new JMenuItem("Save");
            mMenuFile.add(mMenuItemSave);
            mMenuItemSave.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                   ClipboardAndFileUtil.save(mTextArea.getText());
                }
            });



            mMenuItemExit = new JMenuItem("Exit");
            mMenuFile.add(mMenuItemExit);
            mMenuItemExit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            });



       //Edit menu
        mMenuEdit = new JMenu("Edit");
        mMenuBar.add(mMenuEdit);



            mMenuItemCut = new JMenuItem("Cut");
            mMenuEdit.add(mMenuItemCut);
            mMenuItemCut.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ClipboardAndFileUtil.copy(mTextArea.getSelectedText());
                    mTextArea.replaceSelection("");
                }
            });

            mMenuItemCopy = new JMenuItem("Copy");
            mMenuEdit.add(mMenuItemCopy);
            mMenuItemCopy.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ClipboardAndFileUtil.copy(mTextArea.getSelectedText());

                }
            });

            mMenuItemPaste = new JMenuItem("Paste");
            mMenuEdit.add(mMenuItemPaste);
            mMenuItemPaste.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                   mTextArea.insert(ClipboardAndFileUtil.paste(), mTextArea.getSelectionStart());


                }
            });

            mMenuItemSelectAll = new JMenuItem("Select All");
            mMenuEdit.add(mMenuItemSelectAll);
            mMenuItemSelectAll.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    mTextArea.selectAll();
                }
            });

               //submenu of insert
                mMenuInsert = new JMenu("Insert");
                mMenuEdit.add(mMenuInsert);

                mMenuItemDate = new JMenuItem("Date");
                mMenuInsert.add(mMenuItemDate);
                mMenuItemDate.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                       mTextArea.insert(new GregorianCalendar().getTime().toString().substring(0,10),  mTextArea.getSelectionStart());
                    }
                });

                mMenuItemTime = new JMenuItem("Time");
                mMenuInsert.add(mMenuItemTime);
                mMenuItemTime.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        mTextArea.insert(new GregorianCalendar().getTime().toString().substring(11), mTextArea.getSelectionStart());
                    }
                });



        //Help Menu
        mMenuHelp = new JMenu("Help");
        mMenuBar.add(mMenuHelp);

            mMenuItemAbout = new JMenuItem("About");
            mMenuHelp.add(mMenuItemAbout);
            mMenuItemAbout.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "<html>Good Notepad<br/>University of Chicago<br/>Copyright 2013<br/>Version 0.0.1</html>" );
                }
            });


        //set eventListeners



    }





}
