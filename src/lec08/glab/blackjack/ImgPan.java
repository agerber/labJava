package lec08.glab.blackjack;

import javax.swing.*;
import java.awt.*;

/**
 * Created by ag on 11/17/2014.
 */
public class ImgPan extends JPanel {

    private Image img;

    public ImgPan(Image img){
        this.img = img;
        Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        setLayout(null);
    }

    public Image getImg() {
        return img;
    }

    public void setImg(Image img){
        this.img = img;
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(img, 0,0,null);
    }
}
