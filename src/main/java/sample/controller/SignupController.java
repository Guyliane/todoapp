package sample.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;

import java.net.URL;
import java.util.ResourceBundle;

public class SignupController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXTextField su_nom;

    @FXML
    private JFXTextField su_prenom;

    @FXML
    private JFXTextField su_pseudo;

    @FXML
    private JFXCheckBox su_cb_homme;

    @FXML
    private JFXCheckBox su_cb_femme;

    @FXML
    private JFXCheckBox su_cb_autre;

    @FXML
    private JFXPasswordField su_motDePasse;

    @FXML
    private JFXButton su_valider;

    @FXML
    void initialize() {
        
    }
}
