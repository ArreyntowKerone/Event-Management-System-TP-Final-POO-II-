package com.example.eventmanager.usefulclasses.exceptions;

public class EvenementDejaExistantException extends Exception {
    // Constructeur avec un message d'erreur
    public EvenementDejaExistantException(String nom) {
        super("L'événement avec le nom'" + nom + "' existe déjà.");
    }

    // Constructeur avec cause (pour chaînage d'exceptions)
    public EvenementDejaExistantException(String message, Throwable cause) {
        super(message, cause);
    }
    

}
