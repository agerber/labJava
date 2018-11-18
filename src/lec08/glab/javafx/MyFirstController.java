package lec08.glab.javafx;

/**
 * Sample Skeleton for 'myfirst.fxml' Controller Class
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;

public class MyFirstController {

    @FXML // fx:id="mnuQuit"
    private MenuItem mnuQuit; // Value injected by FXMLLoader

    @FXML // fx:id="txtName"
    private TextField txtName; // Value injected by FXMLLoader

    @FXML // fx:id="lblResult"
    private Label lblResult; // Value injected by FXMLLoader

    @FXML // fx:id="btnGo"
    private Button btnGo; // Value injected by FXMLLoader

    @FXML
    void mnuQuitAction(ActionEvent event) {

        System.exit(0);

    }

    @FXML
    void btnGoAction(ActionEvent event) {

       lblResult.setText(txtName.getText());

    }

}
