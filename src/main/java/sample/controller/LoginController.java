package sample.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.service.UtilisateurService;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXTextField loginUsernameTf;

    @FXML
    private JFXPasswordField loginPasswordTf;

    @FXML
    private JFXButton loginNextButton;

    @FXML
    private JFXButton loginSignupButton;

    UtilisateurService userService = new UtilisateurService();

    @FXML
    void initialize() {

       loginNextButton.setOnAction(event -> {
           String pseudo = loginUsernameTf.getText().trim();
           String motDePasse = loginPasswordTf.getText().trim();
           if(!pseudo.equals("") || !motDePasse.equals("")) {
                //userService.loginUser(pseudo, motDePasse);
               FXMLLoader loader = new FXMLLoader();
               loader.setLocation(getClass().getResource("/addItem.fxml"));

               try {
                   loader.load();
               } catch (IOException e) {
                   e.printStackTrace();
               }

               Parent root = loader.getRoot();
               Stage stage = new Stage();
               stage.setScene(new Scene(root));
               stage.showAndWait();
           }else{
               System.out.println("Une erreur est survenue.");
           }
       });

       loginSignupButton.setOnAction(event -> {
           //Lien vers la page d'inscription
           loginSignupButton.getScene().getWindow().hide();
           FXMLLoader loader = new FXMLLoader();
           loader.setLocation(getClass().getResource("/signup.fxml"));

           try {
               loader.load();
           } catch (IOException e) {
               e.printStackTrace();
           }

           Parent root = loader.getRoot();
           Stage stage = new Stage();
           stage.setScene(new Scene(root));
           stage.showAndWait();
       });
    }
}
