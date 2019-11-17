package lec05.glab.real;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RealEstate {
    private JPanel panRoot;
    private JPanel panNorth;
    private JPanel panSouth;
    private JList lstHouses;
    private JButton btnAdd;

    //my vars
    private   DefaultListModel demoList;

    public static void main(String[] args) {
        JFrame frame = new JFrame("RealEstate");
        frame.setContentPane(new RealEstate().panRoot);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(new Dimension(700, 500));
    }

    public RealEstate() {

         demoList = new DefaultListModel();
        lstHouses.setModel(demoList);

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //fire up a new form and pass a reference to the mother ship
                new NewEditHouse(RealEstate.this);
            }
        });


    }

    public void addHouse(House house){
        demoList.addElement(house);
    }
}
