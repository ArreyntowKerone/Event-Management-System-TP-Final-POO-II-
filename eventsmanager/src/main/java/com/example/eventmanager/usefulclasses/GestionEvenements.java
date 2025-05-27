package com.example.eventmanager.usefulclasses;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import com.example.eventmanager.usefulclasses.serializers.JsonDataManager;

import javafx.scene.control.TextArea;

public class GestionEvenements {
    //Singleton means we need to make sure only one instance of the class exists
    private static GestionEvenements instance;
    private static Map<String, Evenement> evenements;
    private static Map<Participant, Evenement> personnes;

    //private constructor to prevent instantiation
    private GestionEvenements(){
        evenements = new HashMap<>();
        personnes = new HashMap<>();
    }

    //public static method to get the single instance
    public static GestionEvenements getInstance(){
        if (instance == null){
            instance = new GestionEvenements();
        }
        return instance;
    }

    public Map<String, Evenement> getEvenements() {
        return evenements;
    }

    public Map<Participant, Evenement> getPersonnes() {
        return personnes;
    }

    //Relevant methods
    public Participant rechercherParticipant(String nom){
        if (personnes == null) {
            throw new IllegalStateException("personnes map is not initialized!");
        }
        
        for (Map.Entry<Participant, Evenement> entry : personnes.entrySet()) {
            if (entry.getKey().getNom().equalsIgnoreCase(nom)) {
                return entry.getKey();
            }
        }
        return null; // Return null if no participant found with the given name
    }
        
    public void ajouterEvenement(String nom, Evenement evenement){
        evenements.put(nom, evenement);
        JsonDataManager.saveEvents(); 
    }

    public Evenement getEvenementParticipant(Participant participant) {
        return personnes.get(participant);
    }

    public void supprimerEvenement(String nom){
        evenements.remove(nom);
    }

    public void supprimerParticipant(Participant par){
        personnes.remove(par);
    }

    public Evenement rechercherEvenement(String nom){
        if (evenements == null) {
            throw new IllegalStateException("evenements map is not initialized!");
        }
        return evenements.get(nom);
    }

    public void ajouterPersonne(Participant p, Evenement event){
        personnes.put(p, event);
    }

    public void supprimerDansParticipantsJson(String nom){
        evenements.entrySet().removeIf(entry -> entry.getValue().equals(nom));
    }

     private static String formatDateTime(LocalDateTime dateTime) {
        if (dateTime == null) return "Not specified";
        return dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    }

    public static void displayEventsInTextArea(TextArea textArea, Map<String, Evenement> evenements) {
        if (evenements == null) {
            textArea.setText("Currently empty");
            return;
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("=== LIST OF ALL EVENTS (").append(evenements.size()).append(") ===\n\n");
        
        evenements.forEach((key, event) -> {
            sb.append("🔹 Event ID: ").append(key).append("\n");
            sb.append("   Name: ").append(event.getNom()).append("\n");
            sb.append("   Date: ").append(formatDateTime(event.getDate())).append("\n");
            sb.append("   Location: ").append(event.getLieu()).append("\n");
            //sb.append("   Number of places: ").append(event.getCapaciteMax()).append("\n");
            
            // Add any additional event properties you want to display
            if (event.getCapaciteMax() > 0) {
                sb.append("   Max Capacity: ").append(event.getCapaciteMax()).append("\n");
            }
            
            sb.append("\n"); // Add space between events
        });
        
        textArea.setText(sb.toString());
        textArea.setStyle("-fx-font-family: monospace; -fx-font-size: 14px;");
    }
}
