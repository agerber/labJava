package edu.uchicago.gerber.labjava.lec08.glab.javafx.examples;

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


public class FirstMain extends Application  {

    @Override
    public void start(Stage stage) throws Exception {
        
        //Stage
            //Scene
                //Root
        
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/First.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/first.css");
        stage.setTitle("First app");
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
//    public static void main(String[] args) {
//        launch(args);
//    }


    //controller

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


    @FXML
    private void btnPress_press(ActionEvent event) {

        System.out.println(txtFirst.getText() + " " + txtLast.getText());

    }

}
