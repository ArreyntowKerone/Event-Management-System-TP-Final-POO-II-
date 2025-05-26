package com.example.eventmanager.usefulclasses.exceptions;

public class CapaciteMaxAtteinteException extends Exception {
    // Constructeur avec un message d'erreur
    public CapaciteMaxAtteinteException(String nom, int capaciteMax) {
        super("L'événement '" + nom + "' a atteint sa capacité maximale (" + capaciteMax + " participants).");
    }

    // Constructeur avec cause (pour chaînage d'exceptions)
    public CapaciteMaxAtteinteException(String message, Throwable cause) {
        super(message, cause);
    }
}
