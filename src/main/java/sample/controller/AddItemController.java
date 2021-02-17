package sample.controller;

import com.jfoenix.controls.JFXButton;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddItemController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label label_pasDispo;

    @FXML
    private JFXButton add_bt;

    @FXML
    void initialize() {
        add_bt.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            FadeTransition fadeTransition = new FadeTransition(Duration.millis(2000), add_bt);
            FadeTransition fadeTransition2 = new FadeTransition(Duration.millis(2000), label_pasDispo);

            System.out.println("Add clicked");
            //add_bt.setOpacity(0);

            fadeTransition.setFromValue(1f);
            fadeTransition.setToValue(0f);
            fadeTransition.setCycleCount(1);
            fadeTransition.setAutoReverse(false);
            fadeTransition.play();

            fadeTransition2.setFromValue(1f);
            fadeTransition2.setToValue(0f);
            fadeTransition2.setCycleCount(1);
            fadeTransition2.setAutoReverse(false);
            fadeTransition2.play();
        });
    }
}
