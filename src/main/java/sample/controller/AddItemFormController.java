package sample.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;

import java.net.URL;
import java.util.ResourceBundle;

public class AddItemFormController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXTextField titre_tf;

    @FXML
    private JFXTextField description_tf;

    @FXML
    private JFXButton ok_bt;

    @FXML
    void initialize() {

    }
}
