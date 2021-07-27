package edu.uchicago.gerber.labjava.lec08.glab.javafx.basics;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CssExampleMain extends Application {


    //controller code
    //dependency injection

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



    //main

    @Override
    public void start(Stage stage) throws Exception {
        
        //Stage
            //Scene
                //Root
        
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/CssExample.fxml"));

        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/cssexample.css");
        
        stage.setTitle("CSS example");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }








}
