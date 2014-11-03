package lec06.glab.more_ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by ag on 11/2/2014.
 */
public class MyUI implements ActionListener {
    private JPanel mPanel;
    private JButton mButtonRoll1;
    private JPanel mPanImage;
    private JButton mButtonRoll2;

  //  private MyListener mMyListener;


    public static void main(String[] args) {
        JFrame frame = new JFrame("MyUI");
        frame.setContentPane(new MyUI().mPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(400,400);
        frame.setVisible(true);
    }


    private void createUIComponents() {

        //both instantiate and add behavior to our customer components
        mPanImage  = new ImgPan(new ImageIcon("").getImage());
        mButtonRoll1 = new JButton();

        mButtonRoll1.addActionListener(this);

        mButtonRoll2 = new JButton();
        mButtonRoll2.addActionListener(this);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
         System.out.println(this.getClass().getName());

        if (((JButton)e.getSource()).getText().equalsIgnoreCase("Click 1")){

            ((ImgPan) mPanImage).setImg(new ImageIcon(System.getProperty("user.dir") + "/src/lec06/glab/more_ui/freez.jpg").getImage());


        } else {
            ((ImgPan) mPanImage).setImg(new ImageIcon(System.getProperty("user.dir") + "/src/lec06/glab/more_ui/mortal.jpg").getImage());

        }


        mPanImage.repaint();

    }
 }


class ImgPan extends JPanel {

    private Image img;
    private static final Dimension SIZE = new Dimension(400,300);

    public ImgPan(Image img) {
        this.img = img;
       setPreferredSize(SIZE);
        setMinimumSize(SIZE);
        setMaximumSize(SIZE);
        setSize(SIZE);

    }

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(img, 0,0, (int)SIZE.getWidth(), (int)SIZE.getHeight(), null);

    }

}



//class MyListener implements  ActionListener {
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//
//        System.out.println(this.getClass().getName());
//
//        if (((JButton)e.getSource()).getText().equalsIgnoreCase("Click 1")){
//            JOptionPane.showConfirmDialog(null, "Clicked 1");
//        } else {
//            JOptionPane.showConfirmDialog(null, "Clicked 2");
//        }
//
//    }
//}

