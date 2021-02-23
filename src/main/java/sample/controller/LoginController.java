package sample.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.animations.Shaker;
import sample.entity.Utilisateur;
import sample.repository.UtilisateurRepositoryImpl;
import sample.service.UtilisateurService;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class LoginController {
    private int userId;

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

    private UtilisateurService utilisateurService = null;
    private UtilisateurRepositoryImpl utilisateurRepository = null;
    @FXML
    void initialize() {
        utilisateurService = new UtilisateurService();
        utilisateurRepository = new UtilisateurRepositoryImpl();

       loginNextButton.setOnAction(event -> {
           String pseudo = loginUsernameTf.getText().trim();
           String motDePasse = loginPasswordTf.getText().trim();
           Utilisateur utilisateur = new Utilisateur();
           utilisateur.setPseudo(pseudo);
           utilisateur.setMotdepasse(motDePasse);

           ResultSet rs = utilisateurService.getUtilisateur(utilisateur);

           int counter = 0;
           try{
               while(rs.next()){
                   counter++;
                   userId = rs.getInt("utilisateur_id");
               }
               if(counter == 1){
                   System.out.println("Login successful!");
                   goToAddItemScene();
               }else{
                   Shaker shaker = new Shaker(loginNextButton);
                   shaker.shake();
               }
               } catch (SQLException e) {
                   e.printStackTrace();
               }

           });
       loginSignupButton.setOnAction(event -> {
           goToSignupScene();
       });

    }


    private void goToAddItemScene(){
        //Transiter vers la page addItem
        loginSignupButton.getScene().getWindow().hide();
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
        AddItemController addItemController = loader.getController();
        addItemController.setUserId(userId);
        stage.showAndWait();
    }
    private void goToSignupScene(){
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
    }
}
