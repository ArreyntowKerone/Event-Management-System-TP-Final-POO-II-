package com.example.eventmanager;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.example.eventmanager.usefulclasses.EventFactory;
import com.example.eventmanager.usefulclasses.exceptions.EvenementDejaExistantException;
import com.example.eventmanager.usefulclasses.serializers.JsonDataManager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class addConcertController {

    @FXML
    private TextField artisteconcerttf;

    public TextField getArtisteconcerttf() {
        return artisteconcerttf;
    }

    public TextField getCapacitemaxconcerttf() {
        return capacitemaxconcerttf;
    }

    public TextField getDateconcerttf() {
        return dateconcerttf;
    }

    public TextField getGenremusicaltf() {
        return genremusicaltf;
    }

    public TextField getLieuconcerttf() {
        return lieuconcerttf;
    }

    public TextField getNomconcerttxtfld() {
        return nomconcerttxtfld;
    }

    @FXML
    private TextField capacitemaxconcerttf;

    @FXML
    private TextField dateconcerttf;

    @FXML
    private TextField genremusicaltf;

    @FXML
    private TextField lieuconcerttf;

    @FXML
    private TextField nomconcerttxtfld;

    @FXML
    void addConcert(ActionEvent event) throws EvenementDejaExistantException {
        String nom = nomconcerttxtfld.getText();
        String lieu = lieuconcerttf.getText();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            
        // Parse the text to LocalDateTime
        LocalDateTime date = LocalDateTime.parse(dateconcerttf.getText(), formatter);
        int capaciteMax = Integer.parseInt(capacitemaxconcerttf.getText());
        String genre = genremusicaltf.getText();
        String artiste = artisteconcerttf.getText();
    
        EventFactory.createConcert(nom, date, lieu, capaciteMax, artiste, genre);
        JsonDataManager.saveEvents();
        
        

    }

}
