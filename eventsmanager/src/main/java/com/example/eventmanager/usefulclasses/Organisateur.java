package com.example.eventmanager.usefulclasses;

import java.util.List;

public class Organisateur extends Participant {
    public Organisateur(String nom, String email) {
        super(nom, email);
        //TODO Auto-generated constructor stub
    }

    private List<Evenement> evenementsOrganises;

    //Methods for dealing with the list
    public List<Evenement> getEvenementsOrganises() {
        return evenementsOrganises;
    }

    
}
