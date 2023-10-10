package edu.uchicago.gerber.labjava.lec06.latin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Map;

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

    private DefaultListModel<String> mModel;


    //step 1: create a main method
    public static void main(String[] args) {
        JFrame frame = new JFrame("LatinDictionary");
        frame.setContentPane(new LatinDictionary().mValue);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.pack();
        frame.setVisible(true);
    }

    public LatinDictionary() {

        //init
        mModel = new DefaultListModel<>();

        //event listeners
        mButtonNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                NewDef dialog = new NewDef(LatinDictionary.this);
                dialog.pack();
                dialog.setVisible(true);


            }
        });

        mList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JList list = (JList) e.getSource();
                if (e.getClickCount() == 2) {
                    int nIndexSelected = list.getSelectedIndex();
                    int nReply = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this item?", "confirm delete", JOptionPane.YES_NO_OPTION);
                    if (nReply == JOptionPane.YES_OPTION) {
                        mModel.remove(nIndexSelected);

                    }

                }
            }
        });

        mButtonSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //search here

            }


        });

    }

    public void setList(Map map) {
        String strBuild = "";
        for (Object obj : map.keySet()) {
            strBuild += ((String) obj);
            strBuild += " : ";
            strBuild += ((String) map.get(obj)).toString();
            mModel.addElement(strBuild);
        }

        mList.setModel(mModel);
        mList.setSelectedIndex(mModel.getSize() - 1);
        mList.updateUI();

    }


}
