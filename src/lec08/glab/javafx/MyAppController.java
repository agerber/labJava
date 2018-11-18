package lec08.glab.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class MyAppController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnGo;

    @FXML
    void initialize() {

        System.out.println("hello from initialize");

    }

    @FXML
    void btnGo_action(ActionEvent event) {

        System.out.println("hello from button");
    }
}