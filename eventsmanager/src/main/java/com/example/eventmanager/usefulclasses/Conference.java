package com.example.eventmanager.usefulclasses;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.example.eventmanager.usefulclasses.exceptions.CapaciteMaxAtteinteException;
//import com.fasterxml.jackson.annotation.JsonTypeName;

//@JsonTypeName("Conference")
public class Conference extends Evenement {
    private String theme;
    private static List<Intervenant> presentateurs = new ArrayList<>();
    private static List<Participant> participants = new ArrayList<>();


    public Conference() {
        
    }

    public static List<Participant> getParticipants() {
        return participants;
    }

    
    //Getters and setters
    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    //Methods for dealing with the list
    public static List<Intervenant> getIntervenant() {
        
        return presentateurs;
    }

    

    

    public Conference(String nom, LocalDateTime date, String lieu, int capaciteMax) {
        super(nom, date, lieu, capaciteMax);
    }

    //Conference related methods
    public void ajouterParticipant(Participant participant) throws CapaciteMaxAtteinteException{
        //implementation of the method
        List<Participant> currentParticipants = Conference.getParticipants();
        if (currentParticipants.size() >= getCapaciteMax()) {
            throw new CapaciteMaxAtteinteException(getNom(), getCapaciteMax());

        }else{
            currentParticipants.add(participant);
            addObserver(participant);
        }

    }

    void annuler() {
        //implementation of the method

        notifyObservers(this, "CANCELLED");
    }

    void afficherDetails() {
        //implementation of the method
    }

    public static void ajouterIntervenant(Intervenant intervenant) {
        getIntervenant().add(intervenant);
    }
    @Override
    void modifierEvenement() {
        //Implementation of the method
        

        notifyObservers(this, "MODIFIED");
    }

    public void rechercherIntervenant(String nom){
        
    }
    

}
