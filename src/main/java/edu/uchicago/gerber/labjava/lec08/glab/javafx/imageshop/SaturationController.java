package edu.uchicago.gerber.labjava.lec08.glab.javafx.imageshop;

/**
 * Sample Skeleton for 'saturation.fxml' Controller Class
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class SaturationController {

    @FXML // fx:id="lblDetails"
    private Label lblDetails; // Value injected by FXMLLoader

    @FXML // fx:id="cancelButton"
    private Button cancelButton; // Value injected by FXMLLoader

    @FXML // fx:id="sldSaturation"
    private Slider sldSaturation; // Value injected by FXMLLoader

    @FXML // fx:id="actionParent"
    private HBox actionParent; // Value injected by FXMLLoader

    @FXML // fx:id="okButton"
    private Button okButton; // Value injected by FXMLLoader

    @FXML // fx:id="okParent"
    private HBox okParent; // Value injected by FXMLLoader

    @FXML // fx:id="messageLabel"
    private Label messageLabel; // Value injected by FXMLLoader
    private double mVal;

    @FXML
    void cancelButtonAction(ActionEvent event) {

        Cc.getInstance().getSaturationStage().close();

    }

    @FXML
    void okButtonAction(ActionEvent event) {

        //saturation value .9 is little  and .1 is a lot. So we need to invert the value from the slider
        double dLevel = 1 - sldSaturation.getValue();


        Image image = Cc.transform(Cc.getInstance().getImg(), (Color c, Double d) -> c.deriveColor(0, 1.0 / d, 1.0, 1.0), dLevel);
        Cc.getInstance().setImageAndRefreshView(image);
       // Cc.getInstance().getImgView().setImage(image);
        Cc.getInstance().getSaturationStage().close();


    }




}
