package edu.uchicago.gerber.labjava.lec08.glab.more_javafx;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SampleMain extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Sample.fxml"));

        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Sample.css");

        stage.setTitle("Sample");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }


}
