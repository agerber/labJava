/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lec10.glab.javafx;

/**
 * Sample Skeleton for 'CssExample.fxml' Controller Class
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CssExampleController {

    @FXML // fx:id="lblName"
    private Label lblName; // Value injected by FXMLLoader

    @FXML // fx:id="lblResult"
    private Label lblResult; // Value injected by FXMLLoader

    @FXML // fx:id="txtHello"
    private TextField txtHello; // Value injected by FXMLLoader

    @FXML // fx:id="btnGo"
    private Button btnGo; // Value injected by FXMLLoader

    @FXML
    void btnGoAction(ActionEvent event) {

     lblResult.setText(
         "Hello there :" +txtHello.getText());

    }

}
