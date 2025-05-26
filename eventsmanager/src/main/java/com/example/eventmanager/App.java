package com.example.eventmanager;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import com.example.eventmanager.usefulclasses.serializers.JsonDataManager;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/eventmanager/login.fxml"));
            Parent root = loader.load();
            
            Scene scene = new Scene(root, 600, 400);
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
    public static void main(String[] args) throws Exception {
        // Load events and participants from JSON files
        JsonDataManager.loadEvents();
        launch(args);
        
    }

}