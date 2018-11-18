package lec08.glab.more_javafx;


        import java.net.URL;
        import java.util.ResourceBundle;

        import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.scene.control.Button;
        import javafx.scene.layout.HBox;

        import javax.swing.*;

public class YepController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private HBox hb;

    @FXML
    private Button btn;

    @FXML
    void hb_drag_released(ActionEvent event) {

        System.out.println(event.getSource());
    }

    @FXML
    void btn_click(ActionEvent event) {

        JOptionPane.showConfirmDialog(null, "You clicked me");

    }

    @FXML
    void initialize() {
        assert hb != null : "fx:id=\"hb\" was not injected: check your FXML file 'Yep.fxml'.";
        assert btn != null : "fx:id=\"btn\" was not injected: check your FXML file 'Yep.fxml'.";

    }
}
