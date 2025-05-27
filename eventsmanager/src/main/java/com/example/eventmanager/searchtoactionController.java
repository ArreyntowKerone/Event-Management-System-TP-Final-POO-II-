package com.example.eventmanager;


import com.example.eventmanager.usefulclasses.Concert;
import com.example.eventmanager.usefulclasses.Conference;
import com.example.eventmanager.usefulclasses.Evenement;
import com.example.eventmanager.usefulclasses.GestionEvenements;
import com.example.eventmanager.usefulclasses.serializers.JsonDataManager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class searchtoactionController {

    @FXML
    private TextArea searchresult;

    @FXML
    private TextField textfld_eventname;

    @FXML
    void cancel(ActionEvent event) {
        String eventname = textfld_eventname.getText();
        if (eventname.isEmpty()) {
            searchresult.setText("Please enter an event name to search.");
            return;
        }else{
            Evenement result = (Concert) GestionEvenements.getInstance().rechercherEvenement(eventname);
            if (result != null) {
                searchresult.setText("Canceling Event: " + result.toString());
                GestionEvenements.getInstance().supprimerEvenement(eventname);
                result.notifyObservers(result, "CANCELLED"); // Notify observers about the cancellation
                JsonDataManager.saveEvents(); // Save changes to JSON file
                
            } else {
                searchresult.setText("No event found with the name: " + eventname);
            }
        }
    }

    @FXML
    void modifyConcert(ActionEvent event) {
        String eventname = textfld_eventname.getText();
        if (eventname.isEmpty()) {
            searchresult.setText("Please enter a valid event name to modify");
            return;
        }else{
            Concert result = (Concert) GestionEvenements.getInstance().rechercherEvenement(eventname);
            if (result != null) {
                searchresult.setText("Modifying the Concert: " + result.toString());
                try{
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/eventmanager/addConcert.fxml"));
                    Parent root = loader.load();
                    Stage modStage = new Stage();
                    Scene scene = new Scene(root);
                    modStage.setTitle("SmartEventManager");
                    modStage.setScene(scene);
                    modStage.setResizable(false); // Disable resizing
                    modStage.setMaximized(false); // Prevent maximizing
                    modStage.setFullScreen(false); // Prevent fullscreen
                    modStage.show();
                    addConcertController controller = loader.getController();
                    controller.getNomconcerttxtfld().setText(eventname);
                    controller.getLieuconcerttf().setText(result.getLieu());
                    controller.getDateconcerttf().setText(String.valueOf(result.getDate()));
                    controller.getCapacitemaxconcerttf().setText(String.valueOf(result.getCapaciteMax()));
                    controller.getArtisteconcerttf().setText(result.getArtiste());
                    controller.getGenremusicaltf().setText(result.getGenreMusical());
                    GestionEvenements.getInstance().supprimerEvenement(eventname);
                    result.notifyObservers(result, "MODIFIED");
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }
            } else {
                searchresult.setText("No event found with the name: " + eventname);
            }
        }
    }
    @FXML
    void modifyConference(ActionEvent event){
        String eventname = textfld_eventname.getText();
        if (eventname.isEmpty()) {
            searchresult.setText("Please enter a valid event name to modify");
            return;
        }else{
            Conference result = (Conference) GestionEvenements.getInstance().rechercherEvenement(eventname);
            if (result != null) {
                searchresult.setText("Modifying the Conference: " + result.toString());
                try{
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/eventmanager/addConference.fxml"));
                    Parent root = loader.load();
                    Stage modStage = new Stage();
                    Scene scene = new Scene(root);
                    modStage.setTitle("SmartEventManager");
                    modStage.setScene(scene);
                    modStage.setResizable(false); // Disable resizing
                    modStage.setMaximized(false); // Prevent maximizing
                    modStage.setFullScreen(false); // Prevent fullscreen
                    modStage.show();
                    addConferenceController controller = loader.getController();
                    controller.getNomconftf().setText(eventname);
                    controller.getLieuconftf().setText(result.getLieu());
                    controller.getDateconftf().setText(String.valueOf(result.getDate()));
                    controller.getCapacitemaxconftf().setText(String.valueOf(result.getCapaciteMax()));
                    controller.getThemeconftf().setText(result.getTheme());
                    GestionEvenements.getInstance().supprimerEvenement(eventname);
                    result.notifyObservers(result, "MODIFIED");
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }
            } else {
                searchresult.setText("No event found with the name: " + eventname);
            }
        }
    }

    @FXML
    void register(ActionEvent event) {
        String eventname = textfld_eventname.getText();
        if (eventname.isEmpty()) {
            searchresult.setText("Please enter an event name to join");
            return;
        }else{
            Evenement result = GestionEvenements.getInstance().rechercherEvenement(eventname);
            if (result != null) {
                searchresult.setText("Trying to join: " + result.toString());
                try{
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/eventmanager/addParticipant.fxml"));
                    Parent root = loader.load();
                    Stage primaryStage = new Stage();
                    Scene scene = new Scene(root);
                    primaryStage.setTitle("SmartEventManager");
                    primaryStage.setScene(scene);
                    primaryStage.setResizable(false); // Disable resizing
                    primaryStage.setMaximized(false); // Prevent maximizing
                    primaryStage.setFullScreen(false); // Prevent fullscreen
                    primaryStage.show();
                    addParticipantController controller = loader.getController();
                    controller.getEventlb().setText(eventname);
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }
            } else {
                searchresult.setText("No event found with the name: " + eventname);
            }
        }
        
    }

    @FXML
    void search(ActionEvent event) {
        String eventname = textfld_eventname.getText();
        if (eventname.isEmpty()) {
            searchresult.setText("Please enter an event name to search.");
            return;
        }else{
            try{
                Evenement result = GestionEvenements.getInstance().rechercherEvenement(eventname);
                if (result != null) {
                    searchresult.setText("Event found: " + result.getNom() +" " +result.getDate()+ " "+ result.getLieu());
                } else {
                    searchresult.setText("No event found with the name: " + eventname);
                }
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
            
            
        }
    }

}
