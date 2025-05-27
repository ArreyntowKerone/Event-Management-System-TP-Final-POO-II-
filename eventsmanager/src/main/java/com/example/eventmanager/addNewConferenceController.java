package com.example.eventmanager;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.example.eventmanager.usefulclasses.Conference;
import com.example.eventmanager.usefulclasses.EventFactory;
import com.example.eventmanager.usefulclasses.GestionEvenements;
import com.example.eventmanager.usefulclasses.Intervenant;
import com.example.eventmanager.usefulclasses.exceptions.EvenementDejaExistantException;
import com.example.eventmanager.usefulclasses.serializers.JsonDataManager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class addNewConferenceController {

    @FXML
    private TextField capacitemaxconftf;

    @FXML
    private TextField dateconftf;

    @FXML
    private TextField intervenantconftf;

    @FXML
    private TextField lieuconftf;

    @FXML
    private TextField nomconftf;

    @FXML
    private TextField themeconftf;

    @FXML
    void addConference(ActionEvent event) throws EvenementDejaExistantException {
        // Logic to add a conference
        String nom = nomconftf.getText();
        // Define the expected date-time format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            
        // Parse the text to LocalDateTime
        LocalDateTime date = LocalDateTime.parse(dateconftf.getText(), formatter);
        String lieu = lieuconftf.getText();
        String theme = themeconftf.getText();
        int capaciteMax = Integer.parseInt(capacitemaxconftf.getText());
        String intervenant = intervenantconftf.getText();
        Intervenant inter = new Intervenant(intervenant);
        try {
            if(GestionEvenements.getInstance().rechercherEvenement(nom) == null){
                Conference.ajouterIntervenant(inter);
                // Create a new Conference object and add it to the event manager
                EventFactory.createConference(nom, date, lieu, capaciteMax, theme, inter);
                //save to json
                JsonDataManager.saveEvents();
                
            }else{
                throw new EvenementDejaExistantException(nom);
            }
        } catch (Exception e) {
            Conference.ajouterIntervenant(inter);
            // Create a new Conference object and add it to the event manager
            EventFactory.createConference(nom, date, lieu, capaciteMax, theme, inter);
            //save to json
            JsonDataManager.saveEvents();

            
        }
        
    }

}

