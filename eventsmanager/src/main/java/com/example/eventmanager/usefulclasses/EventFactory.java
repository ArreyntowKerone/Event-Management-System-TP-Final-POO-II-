package com.example.eventmanager.usefulclasses;

import java.time.LocalDateTime;


public class EventFactory {
    public enum EventType {
        CONFERENCE,
        CONCERT
    }

    public static Evenement createEvent(EventType type, String nom, LocalDateTime date, String lieu,int capaciteMax) {
        switch (type) {
            case CONFERENCE:
                return new Conference(nom, date, lieu, capaciteMax);
            case CONCERT:
                return new Concert(nom, date, lieu, capaciteMax);
            default:
                throw new IllegalArgumentException("Unknown event type: " + type);
        }
    }
    //Using the factory methods to create specific events
    //We will easily create events like this: Evenement concert = EventFactory.createConcert(<arguments to be put in here>)
    public static Conference createConference(String nom, LocalDateTime date, String lieu, int capaciteMax, String theme, Intervenant intervenant){
        Conference conference = (Conference) createEvent(EventType.CONFERENCE, nom, date, lieu, capaciteMax);
        conference.setTheme(theme);
        conference.setId();
        Conference.ajouterIntervenant(intervenant);
        GestionEvenements.getInstance().ajouterEvenement(nom, conference);
        return conference;
    } 
    public static Concert createConcert(String nom, LocalDateTime date, String lieu, int capaciteMax, String artiste, String genreMusical) {
        Concert concert = (Concert) createEvent(EventType.CONCERT, nom, date, lieu, capaciteMax);
        concert.setArtiste(artiste);
        concert.setGenreMusical(genreMusical);
        concert.setId();
        GestionEvenements.getInstance().ajouterEvenement(nom, concert);
        return concert;
    }

    
}
