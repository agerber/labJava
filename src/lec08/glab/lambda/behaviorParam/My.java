package lec08.glab.lambda.behaviorParam;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class My {
    public static void main(String[] args) {

        new Timer(250, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println("hello" );
            }
        });

    }
}
