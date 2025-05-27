package com.example.eventmanager;

import com.example.eventmanager.usefulclasses.GestionEvenements;
import com.example.eventmanager.usefulclasses.Participant;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class deleteParticipantController {

    @FXML
    private TextField emailpartf;

    @FXML
    private Label eventlb;

    @FXML
    private TextField nomparticipanttf;

    @FXML
    void deleteFromEvent(ActionEvent event) {
        String nomParticipant = nomparticipanttf.getText();
        String emailParticipant = emailpartf.getText();
        
        if (nomParticipant.isEmpty() || emailParticipant.isEmpty()) {
            eventlb.setText("Please enter both name and email of the participant.");
            return;
        }
        Participant participant = new Participant(nomParticipant, emailParticipant);
        eventlb.setText("Your are about to delete " + nomParticipant + " from " +GestionEvenements.getInstance().getEvenementParticipant(participant));
        GestionEvenements.getInstance().supprimerParticipant(nomParticipant);
        
    }

}
