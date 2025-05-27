package com.example.eventmanager;

import com.example.eventmanager.usefulclasses.Concert;
import com.example.eventmanager.usefulclasses.Conference;
import com.example.eventmanager.usefulclasses.Evenement;
import com.example.eventmanager.usefulclasses.GestionEvenements;
import com.example.eventmanager.usefulclasses.Participant;
import com.example.eventmanager.usefulclasses.exceptions.CapaciteMaxAtteinteException;
import com.example.eventmanager.usefulclasses.serializers.JsonDataManager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class addParticipantController {

    @FXML
    private TextField emailpartf;

    public Label getEventlb() {
        return eventlb;
    }

    @FXML
    private Label eventlb;
    @FXML
    private TextField nomparticipanttf;

    public TextField getEmailpartf() {
        return emailpartf;
    }

    public TextField getNomparticipanttf() {
        return nomparticipanttf;
    }

    @FXML
    public void addToEvent(ActionEvent event) throws CapaciteMaxAtteinteException {
        try {
            String nom = nomparticipanttf.getText();
            String email = emailpartf.getText();
            Participant par = new Participant(nom, email);
            Evenement eve = GestionEvenements.getInstance().rechercherEvenement(eventlb.getText());
            if(eve instanceof Conference) {
                Conference conf = (Conference) eve;
                conf.ajouterParticipant(par);
                GestionEvenements.getInstance().ajouterPersonne(par, GestionEvenements.getInstance().rechercherEvenement(eventlb.getText()));
                JsonDataManager.saveEvents();
            }else if(eve instanceof Concert) {
                Concert conc = (Concert) eve;
                conc.ajouterParticipant(par);
                GestionEvenements.getInstance().ajouterPersonne(par, GestionEvenements.getInstance().rechercherEvenement(eventlb.getText()));
                JsonDataManager.saveEvents();
            }else{
                System.out.println("Event type not recognized. Cannot add participant.");
            }
            
            GestionEvenements.getInstance().ajouterPersonne(par, GestionEvenements.getInstance().rechercherEvenement(eventlb.getText()));
            JsonDataManager.saveEvents();
        } catch (CapaciteMaxAtteinteException e) {
            // Handle the exception (e.g., show an error message)
            System.err.println("Error max limit of participants reached already " + e.getMessage());
        }
    }

}
