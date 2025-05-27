package com.example.eventmanager.usefulclasses;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.example.eventmanager.usefulclasses.exceptions.CapaciteMaxAtteinteException;
//import com.fasterxml.jackson.annotation.JsonSubTypes;
//import com.fasterxml.jackson.annotation.JsonTypeName;

//@JsonTypeName("Concert")
public class Concert extends Evenement {
    private String artiste;
    private String genreMusical;
    private static List<Participant> participants = new ArrayList<>();
    //Getters and setters
    public String getArtiste() {
        return artiste;
    }

    public Concert() {
        
    }
    public Concert(String nom, LocalDateTime date, String lieu, int capaciteMax) {
        super(nom, date, lieu, capaciteMax);
    }

    public void setArtiste(String artiste) {
        this.artiste = artiste;
    }

    public String getGenreMusical() {
        return genreMusical;
    }

    public void setGenreMusical(String genreMusical) {
        this.genreMusical = genreMusical;
    }

    //Concert related methods
    void annuler() {
        //implementation of the method

        notifyObservers(this, "CANCELLED");
    }

    void afficherDetails() {
        //implementation of the method
    }

    @Override
    void modifierEvenement() {
        //Implementation of the method

        notifyObservers(this, "MODIFIED");
    }

    public static List<Participant> getParticipants() {
        return participants;
    }

    public void ajouterParticipant(Participant participant) throws CapaciteMaxAtteinteException{
        //implementation of the method
        List<Participant> currentParticipants= Concert.getParticipants();
        if (currentParticipants.size() >= getCapaciteMax()) {
            throw new CapaciteMaxAtteinteException(getNom(), getCapaciteMax());
        }else{
            currentParticipants.add(participant);
        }

    }
}
