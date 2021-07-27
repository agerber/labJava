package edu.uchicago.gerber.labjava.lec08.glab.more_javafx;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HelloMain extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Hello.fxml"));

        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Hello.css");

        stage.setTitle("Hello");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }


}
