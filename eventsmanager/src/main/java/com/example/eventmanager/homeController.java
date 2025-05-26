package com.example.eventmanager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class homeController {

    @FXML
    private Label deleteParid;
    @FXML
    void changeEvent(ActionEvent event) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/eventmanager/searchtoaction.fxml"));
            Parent root = loader.load();
            Stage opt1 = new Stage();
            Scene scene = new Scene(root);
            opt1.setTitle("SmartEventManager");
            opt1.setScene(scene);
            opt1.setResizable(false); // Disable resizing
            opt1.setMaximized(false); // Prevent maximizing
            opt1.setFullScreen(false); // Prevent fullscreen
            opt1.show();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    @FXML
    void listAllEvents(ActionEvent event) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/eventmanager/newlist.fxml"));
            Parent root = loader.load();
            Stage opt2 = new Stage();
            Scene scene = new Scene(root);
            opt2.setTitle("SmartEventManager");
            opt2.setScene(scene);
            opt2.setResizable(false); // Disable resizing
            opt2.setMaximized(false); // Prevent maximizing
            opt2.setFullScreen(false); // Prevent fullscreen
            opt2.show();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    @FXML
    void newConcert(ActionEvent event) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/eventmanager/addNewConcert.fxml"));
            Parent root = loader.load();
            Stage opt3 = new Stage();
            Scene scene = new Scene(root);
            opt3.setTitle("SmartEventManager");
            opt3.setScene(scene);
            opt3.setResizable(false); // Disable resizing
            opt3.setMaximized(false); // Prevent maximizing
            opt3.setFullScreen(false); // Prevent fullscreen
            opt3.show();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    @FXML
    void newConference(ActionEvent event) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/eventmanager/addNewConference.fxml"));
            Parent root = loader.load();
            Stage opt4 = new Stage();
            Scene scene = new Scene(root);
            opt4.setTitle("SmartEventManager");
            opt4.setScene(scene);
            opt4.setResizable(false); // Disable resizing
            opt4.setMaximized(false); // Prevent maximizing
            opt4.setFullScreen(false); // Prevent fullscreen
            opt4.show();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    @FXML
    void deletePart(MouseEvent event) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/eventmanager/delete.fxml"));
            Parent root = loader.load();
            Stage opt4 = new Stage();
            Scene scene = new Scene(root);
            opt4.setTitle("SmartEventManager");
            opt4.setScene(scene);
            opt4.setResizable(false); // Disable resizing
            opt4.setMaximized(false); // Prevent maximizing
            opt4.setFullScreen(false); // Prevent fullscreen
            opt4.show();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

}
