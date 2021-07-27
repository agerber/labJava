package edu.uchicago.gerber.labjava.lec08.glab.more_javafx;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class YepMain extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Yep.fxml"));

        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Yep.css");

        stage.setTitle("Yep");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }


}
