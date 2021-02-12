package sample.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import sample.entity.Utilisateur;
import sample.service.UtilisateurService;

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
        UtilisateurService utilisateurService = new UtilisateurService();
        su_valider.setOnAction(event -> {
            Utilisateur utilisateur = new Utilisateur();
            utilisateur.setNom(su_nom.getText());
            utilisateur.setPrenom(su_prenom.getText());
            utilisateur.setPseudo(su_pseudo.getText());
            utilisateur.setMotdepasse(su_motDePasse.getText());
            utilisateur.setNom(su_nom.getText());
            utilisateur.setSexe("Homme");
            utilisateurService.createUtilisateur(utilisateur);
        });
    }
}
