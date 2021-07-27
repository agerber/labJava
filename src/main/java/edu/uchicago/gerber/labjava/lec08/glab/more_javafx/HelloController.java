package edu.uchicago.gerber.labjava.lec08.glab.more_javafx;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;


import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class HelloController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn;

    @FXML
    void btn_click(ActionEvent event) {


    }

    @FXML
    void initialize() {
        assert btn != null : "fx:id=\"btn\" was not injected: check your FXML file 'Hello.fxml'.";

    }
}

