package lec05.glab.real;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewEditHouse {
    private JPanel panRoot;
    private JTextField txtAddress;
    private JTextField txtPrice;
    private JTextField txtForeclosed;
    private JButton btnCancel;
    private JButton btnSubmit;



    public NewEditHouse(RealEstate realEstate) {

        JFrame frame = new JFrame("NewEditHouse");
        frame.setContentPane(this.panRoot);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(new Dimension(400, 500));

        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realEstate.addHouse(new House(txtAddress.getText(), Double.parseDouble(txtPrice.getText()), Boolean.parseBoolean(txtForeclosed.getText())));
                frame.dispose();
            }
        });

        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });


    }
}
