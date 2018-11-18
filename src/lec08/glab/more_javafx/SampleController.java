package lec08.glab.more_javafx;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import javax.swing.*;

public class SampleController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn;

    @FXML
    void btn_click(ActionEvent event) {

        JOptionPane.showConfirmDialog(null, event.getSource().getClass().getName());

    }

    @FXML
    void initialize() {
        assert btn != null : "fx:id=\"btn\" was not injected: check your FXML file 'Sample.fxml'.";

    }
}
