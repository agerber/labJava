package edu.uchicago.gerber.labjava.lec05.real;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyRealEstate {
    private JButton btnAdd;
    private JList lstHouse;
    private JPanel panRoot;

    //my members
    DefaultListModel<House> defaultListModel;


    public static void main(String[] args) {


        JFrame frame = new JFrame("MyRealEstate");
        frame.setContentPane(new MyRealEstate().panRoot);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public MyRealEstate() {
        defaultListModel = new DefaultListModel<>();

        defaultListModel.addElement(new House("123 Main", 45676.89, false));
        defaultListModel.addElement(new House("567 Main", 45676.89, false));

        lstHouse.setModel(defaultListModel);

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //fire off a new form
            }
        });

    }
}
