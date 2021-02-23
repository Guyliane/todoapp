package sample.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import sample.entity.Task;
import sample.repository.TaskRepositoryImpl;
import sample.service.TaskService;

import java.net.URL;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.ResourceBundle;

public class AddItemFormController {
    private TaskService taskService;

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
        taskService = new TaskService();

        ok_bt.setOnAction(event -> {
            String dateDuJour = aujourdhui();
            Task task = new Task();
            task.setTasktitle(titre_tf.getText());
            task.setDescription(description_tf.getText());
            task.setDatecreated(dateDuJour);
            taskService.createTask(task);
        });
    }

    public String aujourdhui() {
        Long millis = System.currentTimeMillis();
        Date date = new Date(millis);
        return new SimpleDateFormat("dd-MM-yyyy").format(date);
    }
}
