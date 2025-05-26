package com.example.eventmanager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {

    @FXML
    private TextField lgnpswrd_fld;

    @FXML
    private TextField lgnusr_namefld;

    @FXML
    void login(ActionEvent event) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/eventmanager/home.fxml"));
            Parent root = loader.load();
            Stage primaryStage = new Stage();
            Scene scene = new Scene(root);
            primaryStage.setTitle("SmartEventManager");
            primaryStage.setScene(scene);
            primaryStage.setResizable(false); // Disable resizing
            primaryStage.setMaximized(false); // Prevent maximizing
            primaryStage.setFullScreen(false); // Prevent fullscreen
            primaryStage.show();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

}

