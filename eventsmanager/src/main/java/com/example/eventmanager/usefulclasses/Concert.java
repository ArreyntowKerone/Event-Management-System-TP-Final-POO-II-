package com.example.eventmanager.usefulclasses;

import java.time.LocalDateTime;
import java.util.List;

import com.example.eventmanager.usefulclasses.exceptions.CapaciteMaxAtteinteException;

public class Concert extends Evenement {
    private String artiste;
    private String genreMusical;
    private List<Participant> participants;
    //Getters and setters
    public String getArtiste() {
        return artiste;
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

    public List<Participant> getParticipants() {
        return participants;
    }

    void ajouterParticipant(Participant participant) throws CapaciteMaxAtteinteException{
        //implementation of the method
        List<Participant> currentParticipants = getParticipants();
        if (currentParticipants.size() >= getCapaciteMax()) {
            throw new CapaciteMaxAtteinteException(getNom(), getCapaciteMax());
        }else{
            currentParticipants.add(participant);
        }

    }
}
