package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        //Parent root = FXMLLoader.load(getClass().getResource("/sample/view/login.fxml"));
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("login.fxml"));
        //Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("addItem.fxml"));

        primaryStage.setTitle("COQTAIL");
        Scene scene = new Scene(root,700,400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
