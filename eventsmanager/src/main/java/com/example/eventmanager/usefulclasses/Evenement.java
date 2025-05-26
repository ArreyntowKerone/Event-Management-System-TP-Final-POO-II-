package com.example.eventmanager.usefulclasses;

import java.util.UUID;
import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.*;
import com.example.eventmanager.usefulclasses.exceptions.CapaciteMaxAtteinteException;

@JsonTypeInfo(
    use = JsonTypeInfo.Id.CLASS,
    include = JsonTypeInfo.As.PROPERTY,
    property = "@class"
)
@JsonInclude(JsonInclude.Include.NON_NULL) // Ignore les champs null
public abstract class Evenement extends Observable{
    private String id;
    public Evenement() {
    }
    private String nom;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime date;
    private String lieu;
    private int capaciteMax;
    

    public Evenement(String nom, LocalDateTime date, String lieu, int capaciteMax) {
        this.nom = nom;
        this.date = date;
        this.lieu = lieu;
        this.capaciteMax = capaciteMax;
    }
    public String getId() {
        return id;
    }
    public void setId() {
        this.id = UUID.randomUUID().toString(); // Generate a unique ID
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public LocalDateTime getDate() {
        return date;
    }
    public void setDate(LocalDateTime date) {
        this.date = date;
    }
    public String getLieu() {
        return lieu;
    }
    public void setLieu(String lieu) {
        this.lieu = lieu;
    }
    public int getCapaciteMax() {
        return capaciteMax;
    }
    public void setCapaciteMax(int capaciteMax) {
        this.capaciteMax = capaciteMax;
    }
    //Methodes
    abstract void ajouterParticipant(Participant participant) throws CapaciteMaxAtteinteException;
    abstract void annuler();
    abstract void afficherDetails();
    abstract void modifierEvenement();

}
