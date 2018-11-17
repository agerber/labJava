/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lec10.glab.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * FXML Controller class
 *
 * @author ag
 */
public class FirstController implements Initializable {
    @FXML
    private Label lblFirst;
    @FXML
    private Label lblLast;
    @FXML
    private Label lblWelcome;
    @FXML
    private Label lblStatus;
    @FXML
    private TextField txtFirst;
    @FXML
    private TextField txtLast;
    @FXML
    private Button btnPress;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    
    
   

    @FXML
    private void btnPress_press(ActionEvent event) {
        
        System.out.println(txtFirst.getText() + " " + txtLast.getText());
        
    }
    
}
